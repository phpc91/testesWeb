package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		Gson gson = new Gson();
		PrintWriter p = response.getWriter();
		
		Funcionario funcionario = gson.fromJson((String) request.getParameter("obj_funcionario"), Funcionario.class);
		Treinamento treinamentoAtivo = funcionario.getTreinamentoAtivo();
		ArrayList<Prova> provas = treinamentoAtivo.getProvas();
		
		int idProva = Integer.parseInt(request.getParameter("prova_id"));
		Boolean[] gabarito = null;
		
		for(int i=0; i<provas.size(); i++) {
			Prova prova = provas.get(i);
			if(idProva == prova.getId()) {
				gabarito = prova.getGabarito();
				break;
			}
			
			if(i == (provas.size() -1) && idProva != prova.getId()) {
				request.getRequestDispatcher("/erro/erro.jsp").forward(request, response);
			}
		}
		
		int acertos = 0, tamanhoProva = gabarito.length;
		Boolean[] respostas = new Boolean[tamanhoProva];
		for(int i=0; i<tamanhoProva; i++) {
			respostas[i] = Boolean.parseBoolean(request.getParameter("resposta"+i)); //pega todas respostas
			
			if(respostas[i] == gabarito[i]){
				acertos++;
				p.println(acertos);
			}
		}
		
		float nota = 100 * (acertos/(float)tamanhoProva); //já pensando em tamanho de prova != 10 questoes
		p.println("Nota="+nota);
		request.setAttribute("nota", nota);
		if(nota >= 80.0) {
			p.println("Sua nota foi "+nota+". Parabéns, você foi aprovado neste treinamento!");
			//TODO aprovado no treinamento, exibir relatório com tentativas e respectivas notas até aprovação
			
//			request.getRequestDispatcher("/caminho/para/aprovacao.jsp").forward(request,response);
		} else {
			p.println("Sua nota "+nota+" foi baixa demais. Você foi reprovado.");
			//TODO reprovado, guardar nota e numero de tentativas do treinamento, retry
			request.setAttribute("obj_funcionario", funcionario);
			
//			request.getRequestDispatcher("/caminho/para/tentar/novamente.jsp").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
