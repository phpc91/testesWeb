package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TreinamentoDAO;
import entidade.Prova;
import entidade.Treinamento;

/**
 * Servlet implementation class ProvaController
 */
@WebServlet("/prova")
public class ProvaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final TreinamentoDAO treinamentoDAO = TreinamentoDAO.getInstance();
	private Prova prova;
	
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idTreinamento = Integer.parseInt(request.getParameter("id_treinamento"));
		Treinamento treinamento = treinamentoDAO.getTreinamentoPorId(idTreinamento);
		ArrayList<Prova> provas = treinamento.getProvas();
		int numeroProvas = provas.size();
		
		Random r = new Random(); 
		int idProva = r.nextInt(numeroProvas); //gera indice para pegar prova aleatoriamente
		
		prova = provas.get(idProva);
		String[] questoes = prova.getQuestoes();
		
		request.setAttribute("questoes", questoes);
		request.setAttribute("id_prova", idProva);
		
//		request.getRequestDispatcher("/prova/lista-provas.jsp").forward(request, response); -- TODO descomentar se desejar seleção de prova
		request.getRequestDispatcher("/prova/realizar-prova.jsp").forward(request, response);
	}

}
