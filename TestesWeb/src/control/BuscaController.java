package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.FuncionarioDAO;
import entidade.Funcionario;

/**
 * Servlet implementation class Busca
 */
@WebServlet("/busca")
public class BuscaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		ArrayList<Funcionario> funcionarios = funcionarioDAO.getFuncionariosPorNome(nome);
		int numeroFuncionarios = funcionarios.size();
		String[] nomesFuncionarios = new String[numeroFuncionarios], cargosFuncionarios = new String[numeroFuncionarios];
		Integer[] idsFuncionarios = new Integer[numeroFuncionarios];
		Gson gson = new Gson();
		
		if(numeroFuncionarios > 0) {
			try {
				for(int i=0; i<numeroFuncionarios; i++) {
					nomesFuncionarios[i] = funcionarios.get(i).getNome();
					idsFuncionarios[i] = funcionarios.get(i).getId();
					cargosFuncionarios[i] = funcionarios.get(i).getCargo().getNome();

					//serializacao dos objetos Funcionarios
					String json = gson.toJson(funcionarios.get(i));
					System.out.println("\nOlha o JSON:\n"+json+"\n");
					request.setAttribute("obj_funcionario"+(i+1), json);
				}

				request.setAttribute("nomes_funcionarios", nomesFuncionarios);
				request.setAttribute("ids_funcionarios", idsFuncionarios);
				request.setAttribute("cargos_funcionarios", cargosFuncionarios);
				request.setAttribute("numero_funcionarios", numeroFuncionarios);
				
				request.getRequestDispatcher("/lista-funcionarios.jsp").forward(request, response);
				
			} catch (NullPointerException e) {
				request.getRequestDispatcher("/erro/erro.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/erro/nao-encontrado.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
