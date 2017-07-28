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
		//TODO implementar corretamente
		Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(Integer.parseInt(request.getParameter("id_funcionario")));
		
		Prova prova = funcionario.getCargo().getProva();
		String[] questoes = prova.getQuestoes();
		Boolean[] respostas = prova.getRespostas();
		
		for(int i=0; i<10; i++) {
			request.setAttribute("questao"+(i+1), questoes[i]);
			request.setAttribute("resposta"+(i+1), respostas[i]);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
