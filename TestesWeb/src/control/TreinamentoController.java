package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidade.Funcionario;
import entidade.Treinamento;

/**
 * Servlet implementation class TreinamentosController
 */
@WebServlet("/treinamentos")
public class TreinamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		Enumeration<String> parametros = request.getParameterNames();
		int numeroFuncionarios = 0;
		while(parametros.hasMoreElements()) {
			if(parametros.nextElement().contains("obj_funcionario")){
				numeroFuncionarios++;
			}
		}
		Gson gson = new Gson();
		Funcionario funcionario = new Funcionario();
		
		int idFuncionario = Integer.parseInt(request.getParameter("id_funcionario"));
		for(int i=0; i<numeroFuncionarios; i++){
			String objFuncionario = (String)request.getParameter("obj_funcionario"+(i+1));
			funcionario = gson.fromJson(objFuncionario, Funcionario.class); 
			if(idFuncionario == funcionario.getId()){
				break;
			}
			
			//se está no último item da lista e os ids ainda não batem => erro
			if(i == numeroFuncionarios-1 && idFuncionario != funcionario.getId()){ 
				request.getRequestDispatcher("/erro/erro.jsp").forward(request, response);
			}
		}
		
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
		request.setAttribute("obj_funcionario", gson.toJson(funcionario));

//		request.getRequestDispatcher("/treinamentos/teste.jsp").forward(request, response);
		request.getRequestDispatcher("/treinamentos/lista-treinamentos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
