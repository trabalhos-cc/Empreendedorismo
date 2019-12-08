package servico;

import java.sql.Connection;

import controle.ColLocal;
import sql.Query;

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
}
