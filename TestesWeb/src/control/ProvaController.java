package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entidade.Funcionario;
import entidade.Prova;
import entidade.Treinamento;

/**
 * Servlet implementation class ProvaController
 */
@WebServlet("/prova")
public class ProvaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Enumeration<String> en = request.getParameterNames();
//		PrintWriter p = response.getWriter();
//		while(en.hasMoreElements()){
//			String nome = en.nextElement();
//			p.println(nome);
//			p.println("\t"+(String) request.getParameter(nome));
//		}
		
		Gson gson = new Gson();
		Funcionario funcionario = gson.fromJson((String)request.getParameter("funcionario"), Funcionario.class);
		
		int idTreinamento = Integer.parseInt(request.getParameter("id_treinamento"));
		ArrayList<Treinamento> treinamentos = funcionario.getCargo().getTreinamentos();
		ArrayList<Prova> provas = new ArrayList<Prova>();
		
		//percorre os treinamentos para encontrar o escolhido
		for(int i=0; i<treinamentos.size(); i++){
			Treinamento treinamento = treinamentos.get(i);
			if(treinamento.getId() == idTreinamento){
				funcionario.setTreinamentoAtivo(treinamento);
				provas = treinamento.getProvas();
				break;
			}
			
			if(i ==(treinamentos.size() -1) && idTreinamento != treinamento.getId()) {
				request.getRequestDispatcher("/erro/erro.jsp").forward(request, response);
			}
		}
		
		int numeroProvas = provas.size();
		Random r = new Random(); 
		int indiceProva = r.nextInt(numeroProvas); //gera indice para pegar prova aleatoriamente
		
		Prova prova = provas.get(indiceProva);
		funcionario.setProvaAtiva(prova);
		String[] questoes = prova.getQuestoes();
		
		request.setAttribute("questoes", questoes);
		request.setAttribute("id_prova", prova.getId());
		request.setAttribute("obj_funcionario", gson.toJson(funcionario));
		//TODO enviar atributos para exibição na tela
		
//		request.getRequestDispatcher("/prova/lista-provas.jsp").forward(request, response); -- TODO descomentar se desejar seleção de prova
		request.getRequestDispatcher("/prova/realizar-prova.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
