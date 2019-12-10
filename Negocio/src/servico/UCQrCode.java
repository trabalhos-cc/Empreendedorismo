package servico;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controle.ColLocal;
import dao.DaoAtividade;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import sql.Query;
import unioeste.geral.evento.bo.Atividade;

public class UCQrCode {

	public UCQrCode() {}
	
	public String getLatitude(int id) throws Exception{
		
		Connection con = Query.getConnection();
		con.setAutoCommit(false);

		ColLocal colLocal = new ColLocal(con);
		String ok = null;
		
		try {
			ok = colLocal.getLatitude(id, con);
		
			con.commit();
				
		}catch(Exception e) {
			e.printStackTrace();
			con.rollback();
			System.err.println("A Coordenada  não foi recuperada - Erro na classe: " + UCQrCode.class.getName());
		}
		return ok;
	}
	
	public String getLongitude(int id) throws Exception{
		
		Connection con = Query.getConnection();
		con.setAutoCommit(false);

		ColLocal colLocal = new ColLocal(con);
		String ok = null;
		
		try {
			ok = colLocal.getLongitude(id, con);
		
			con.commit();
				
		}catch(Exception e) {
			e.printStackTrace();
			con.rollback();
			System.err.println("A Coordenada  não foi recuperada - Erro na classe: " + UCQrCode.class.getName());
		}
		return ok;
	}

	public void QrCode(int idEvento) throws Exception{
		/*
		 * obter lista de atividade por sala
		 */
		
		Connection con = Query.getConnection();
		con.setAutoCommit(false);
		
		ArrayList<Atividade> ativ = new ArrayList<Atividade>();
		DaoAtividade daoAtividade = new DaoAtividade();
		
		//obtem todas as atividades de um evento
		ativ = daoAtividade.buscarAtividadesPorEvento(idEvento, con); 
		
		//obtem todos os locais que as atividades iram ocorrer
		ArrayList<Integer> locais = obterLocais(ativ);
		
		//obtem as atividades de cada local
		for(int i = 0; i < ativ.size(); i++) {
			ArrayList<Atividade> ativEspecifica = new ArrayList<Atividade>();
			
			//cria uma nova tabela com as atividades especificas de cada local 
			for(int j = 0; j < ativ.size(); j++) {
				if(buscaID(locais, ativ.get(j).getLocal().getId())) {
					ativEspecifica.add(ativ.get(j));
				}
			}
			
			/*
			 * gerar o arquivo.txt
			 */
			
			SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");  
			String buffer = null;
			String finalS = null;
			for(int j = 0; j < ativEspecifica.size(); j++) {
				Timestamp timeI = ativEspecifica.get(j).getHorarioI(); 
				String formatedTimeI = format.format(timeI.getTime()); 
				Timestamp timeF = ativEspecifica.get(j).getHorarioF(); 
				String formatedTimeF = format.format(timeF.getTime()); 

				buffer = ativEspecifica.get(j).getTipoAtividade().getNome() + " " 
						+ ativEspecifica.get(j).getNome() + "; " 
						+ "Data:" + ativEspecifica.get(j).getData() + "; "
						+ "Horario:" + formatedTimeI + " - " + formatedTimeF + "; "
						+ "Apresentadores" + ativEspecifica.get(j).getApresentadores() + " ;\n";
				if(finalS == null) {
					finalS = buffer;
				}else{
					finalS = finalS.concat(buffer);
				}
			}
			/*
			 * gerar qrCode
			 */
			
			gerarQrCode("QrCode.png", finalS);
			System.out.println("QRCode gerado!");
		}
	}
	
	private ArrayList<Integer> obterLocais(ArrayList<Atividade> geral){
		ArrayList<Integer> local = new ArrayList<Integer>();
		
		for(int i = 0; i < geral.size(); i++) {
			if(!buscaID(local, i)) {
				local.add(geral.get(i).getLocal().getId());
			}	
		}
		return local;
	}
	
	private boolean buscaID(ArrayList<Integer> lista, int index) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == index) return true;
		}
		return false;
	}
	
	private void gerarQrCode(String fileName, String info) throws FileNotFoundException, IOException{
		
		int size = 125; // tamanho do QrCode
		FileOutputStream f = new FileOutputStream(fileName); 
		try {
			ByteArrayOutputStream out = QRCode.from(info).to(ImageType.PNG).withSize(size, size).stream();
			
			f.write(out.toByteArray());
			f.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.err.println("Erro ao salvar o QrCode");
		}
		
	}
	
}
