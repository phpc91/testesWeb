package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import entidade.Treinamento;

/**
 * Servlet implementation class TreinamentosController
 */
@WebServlet("/treinamentos")
public class TreinamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreinamentoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idFuncionario = Integer.parseInt(request.getParameter("id_funcionario"));
		Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(idFuncionario);
		ArrayList<Treinamento> treinamentos = funcionario.getCargo().getTreinamentos();
		int numeroTreinamentos = treinamentos.size();
		Integer[] idsTreinamentos = new Integer[numeroTreinamentos];
		String[] nomesTreinamentos = new String[numeroTreinamentos];
		
		for(int i=0; i<treinamentos.size(); i++) {
			Treinamento treinamento = treinamentos.get(i);
			idsTreinamentos[i] = treinamento.getId();
			nomesTreinamentos[i] = treinamento.getNome();
		}
		request.setAttribute("ids_treinamentos", idsTreinamentos);
		request.setAttribute("nomes_treinamentos", nomesTreinamentos);
		
		request.getRequestDispatcher("/treinamentos/lista-treinamentos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
