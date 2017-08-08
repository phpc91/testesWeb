package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProvaDAO;

/**
 * Servlet implementation class CorrecaoController
 */
@WebServlet("/correcao")
public class CorrecaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorrecaoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		
		Boolean[] respostas = new Boolean[10];
		int idProva = Integer.parseInt(request.getParameter("prova_id"));
		Boolean[] gabarito = ProvaDAO.getInstance().getProvaPorId(idProva).getRespostas();
		int acertos = 0;
		
		for(int i=0; i<respostas.length; i++) {
			respostas[i] = Boolean.parseBoolean(request.getParameter("resposta"+i)); //pega todas respostas
			
			if(respostas[i] == gabarito[i]){
				acertos++;
				p.println(acertos);
			}
		}
		
		float nota = 100 * (acertos/(float)respostas.length); //já pensando em tamanho de prova != 10 questoes
		p.println("Nota="+nota);
		request.setAttribute("nota", nota);
		if(nota >= 80.0) {
			p.println("Sua nota foi "+nota+". Parabéns, você foi aprovado neste treinamento!");
			//TODO aprovado no treinamento, exibir relatório com tentativas e respectivas notas até aprovação
		} else {
			p.println("Sua nota "+nota+" foi baixa demais. Você foi reprovado.");
			//TODO reprovado, guardar nota e numero de tentativas do treinamento
		}
		
//		request.getRequestDispatcher("/prova/nota.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
