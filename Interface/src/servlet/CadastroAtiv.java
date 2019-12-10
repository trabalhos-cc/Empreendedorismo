package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.UCManterAtividade;
import unioeste.geral.evento.bo.Apresentador;
import unioeste.geral.evento.bo.Evento;

/**
 * Servlet implementation class CadastroAtiv
 */
@WebServlet("/CadastroAtiv")
public class CadastroAtiv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroAtiv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		UCManterAtividade ucMA = new UCManterAtividade();


		request.setCharacterEncoding("UTF-8");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		//todos os dados chegam no formato string
		String nome = request.getParameter("nome");

//		System.out.println("teste avulso\n" + "nome=" + nome);

		
		String bloco = request.getParameter("bloco");
		String espaco = request.getParameter("espaco");
		String sala = request.getParameter("sala");
		String apresentadores [] = request.getParameterValues ("apresentador");
		String evento = request.getParameter("evt");

		System.out.println(apresentadores.length);

		SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
		//		String nome = request.getParameter("nome_evt");
		Date date = null;
		Date horai = null;
		Date horaf = null;
		String data = request.getParameter("data");
		String horIni = request.getParameter("horarioIni");
		String horFim= request.getParameter("horarioFim");

		int tipo;
		try {
			tipo = ucMA.getIDTipo(request.getParameter("tipo"));

			System.out.println("teste avulso\n" + "nome=" + nome + " data= " + data 
					+ " tipo= " + tipo + " horIni=" + horIni);

			try {
				date = sdf.parse(data);
				horai = sdfh.parse(horIni);
				horaf = sdfh.parse(horFim);
			}catch(Exception e) {
				e.printStackTrace();
			}

			Evento ev = new Evento();
			ev.setNome(evento);

			ArrayList<Apresentador> apre = new ArrayList<Apresentador>();
			for(int i = 0; i < apresentadores.length; i++) {
				Apresentador a = new Apresentador();
				a.setNome(apresentadores[i]);
				apre.add(a);
			}

			try {
				ucMA.cadastrarAtividade(nome, date, horai, horaf, Integer.parseInt(bloco), Integer.parseInt(espaco), Integer.parseInt(sala), apre, tipo, ev);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//		Date data = null;
		//		String data_ini = request.getParameter("data");


		//		
		//		try {
		//			data = sdf.parse(data_ini);
		//		}catch(ParseException e ) {
		//			e.printStackTrace();
		//		}

		//		System.out.println("Teste de dados \nnome:" + nome + " ini:" + data_ini +
		//				" fim:" + data_fim);
		//		
		//		int res = 0;
		//		if(nome != "") {
		//			try {
		//				
		//				res = ucME.cadastrarEvento(nome, datai, dataf); 
		//				
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//			}
		//		}
		//		HttpSession session = request.getSession();
		//		
		//		if(res == 1) {
		//			session.setAttribute("Alert", "Transfência Realizada");
		//			response.sendRedirect("index.jsp");
		//		}
		//		else {
		//			session.setAttribute("Alert", "Ocorreu um erro ao transferir!");
		//			response.sendRedirect("index.jsp");
		//		}
		//		
		request.setAttribute("nome_evt", evento);
		request.getRequestDispatcher("cadastro_ativ.jsp").forward(request, response);
	}

}
