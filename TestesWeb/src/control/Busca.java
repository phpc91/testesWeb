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
import entidade.Prova;

/**
 * Servlet implementation class Busca
 */
@WebServlet("/busca")
public class Busca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busca() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		ArrayList<Funcionario> funcionarios = funcionarioDAO.getFuncionariosPorNome(nome);
		
		for(int i=0; i<funcionarios.size(); i++) {
			Funcionario f = funcionarios.get(i);
			
			request.setAttribute("nome"+(i+1), f.getNome());
			request.setAttribute("id"+(i+1), f.getId());
		}
		
		request.getRequestDispatcher("/resultado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO implementar?
		doGet(request, response);
	}

}
