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

import servico.UCManterEvento;

/**
 * Servlet implementation class CadastroEvt
 */
@WebServlet("/CadastroEvt")
public class CadastroEvt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroEvt() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		doGet(request, response);
		
		UCManterEvento ucME = new UCManterEvento();

		
		request.setCharacterEncoding("UTF-8");
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String nome = request.getParameter("nome_evt");
		Date datai = null;
		Date dataf = null;
		String data_ini = request.getParameter("inicio");
		String data_fim = request.getParameter("fim");
		
		try {
			datai = sdf.parse(data_ini);
			dataf = sdf.parse(data_fim);
		}catch(ParseException e ) {
			e.printStackTrace();
		}

		System.out.println("Teste de dados \nnome:" + nome + " ini:" + data_ini +
				" fim:" + data_fim);
		
		int res = 0;
		if(nome != "") {
			try {
				
				res = ucME.cadastrarEvento(nome, datai, dataf); 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();
		
		if(res == 1) {
			session.setAttribute("Alert", "Transfência Realizada");
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("Alert", "Ocorreu um erro ao transferir!");
			response.sendRedirect("index.jsp");
		}
		
		request.getRequestDispatcher("").forward(request, response);
		
	}

}
