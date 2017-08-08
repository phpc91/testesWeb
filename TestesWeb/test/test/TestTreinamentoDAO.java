package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.TreinamentoDAO;
import entidade.Prova;
import entidade.Treinamento;

public class TestTreinamentoDAO {
	
	TreinamentoDAO dao = TreinamentoDAO.getInstance();
	ArrayList<Prova> provas;
	String nome = "Treinamento 1";
	int id = 1, numeroDeProvas = 2;
	
	@Test
	public void testGetTreinamentoPorId() {
		Treinamento treinamento = dao.getTreinamentoPorId(id);
		assertTrue("Erro no nome do treinamento", treinamento.getNome().equals(nome));
		assertTrue("Erro no id de treinamento", treinamento.getId() == id);
		
		provas = treinamento.getProvas(); //provas id=1 e id=2
		assertTrue("Erro no número de provas obtidas", provas.size() == numeroDeProvas);
		assertTrue("Erro no ID da prova", provas.get(0).getId() == 1);
		assertTrue("Erro no ID da prova", provas.get(1).getId() == 2);
	}

	@Test
	public void testGetTreinamentoPorNome() {
		Treinamento treinamento = dao.getTreinamentoPorNome(nome);
		assertTrue("Erro no nome do treinamento", treinamento.getNome().equals(nome));
		assertTrue("Erro no id de treinamento", treinamento.getId() == id);
		
		provas = treinamento.getProvas(); //provas id=1 e id=2
		assertTrue("Erro no número de provas obtidas", provas.size() == numeroDeProvas);
		assertTrue("Erro no ID da prova", provas.get(0).getId() == 1);
		assertTrue("Erro no ID da prova", provas.get(1).getId() == 2);
	}

}
