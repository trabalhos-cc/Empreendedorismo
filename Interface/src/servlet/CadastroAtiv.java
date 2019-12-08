package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servico.UCManterAtividade;

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
		String nome = request.getParameter("nome");
		Date data = null;
		String data_ini = request.getParameter("data");
	
		
		try {
			data = sdf.parse(data_ini);
		}catch(ParseException e ) {
			e.printStackTrace();
		}

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
//		request.getRequestDispatcher("").forward(request, response);
	}

}
