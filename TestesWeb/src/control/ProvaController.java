package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import entidade.Prova;

/**
 * Servlet implementation class ProvaController
 */
@WebServlet("/prova")
public class ProvaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	private Prova prova;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO corrigir prova
//		Boolean[] respostas = prova.getRespostas();
//		
//		for(int i=0; i<respostas.length; i++) {
//			
//		}
		
		int idFuncionario = Integer.parseInt(request.getParameter("id_funcionario"));
		Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(idFuncionario);
		
		prova = funcionario.getCargo().getProva();
		String[] questoes = prova.getQuestoes();
		int idProva = prova.getId();
		
		request.setAttribute("questoes", questoes);
		request.setAttribute("id_prova", idProva);
		
		request.getRequestDispatcher("/prova/realizar-prova.jsp").forward(request, response);
	}

}
