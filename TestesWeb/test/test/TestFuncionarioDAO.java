package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import entidade.Treinamento;

public class TestFuncionarioDAO {
	
	FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	@Test
	public void testGetFuncionarioPorNome() {
		String nome = "Jose"; //id=1, José Da Silva, cargo_id=1
		ArrayList<Funcionario> func = funcionarioDAO.getFuncionariosPorNome(nome);
		
		assertTrue("Erro no nome encontrado", func.get(0).getNome().equals("José Da Silva"));
		assertTrue("Erro no cargo_id", func.get(0).getCargo().getId() == 1);
		assertTrue("Erro no id_funcionário", func.get(0).getId() == 1);
		
		assertTrue("Erro para id nao existente", funcionarioDAO.getFuncionarioPorId(351)==null); //id não existente
	}
	
	@Test
	public void testGetFuncionarioPorId() {
		int id = 2; //nome=João da Mata, cargo_id=2
		Funcionario func = funcionarioDAO.getFuncionarioPorId(id);
		
		assertTrue("Erro no nome_funcionario obtido", func.getNome().equals("João Da Mata"));
		assertTrue("Erro no id_funcionario obtido", func.getId() == id);
		assertTrue("Erro no id_cargo obtido", func.getCargo().getId() == 2);
	}
	
	@Test
	public void testProvaDoFuncionario() {
		int id = 4; //nome=Felipe Da Silva, cargo_id=2 >> treinamento_ids=1,6,7 >> prova_ids = {1,2; 11; 12}
		Funcionario func = funcionarioDAO.getFuncionarioPorId(id);
		
		assertTrue("Erro no nome_funcionario obtido", func.getNome().equals("Felipe Da Silva"));
		assertTrue("Erro no id_funcionario obtido", func.getId() == id);
		assertTrue("Erro no id_cargo obtido", func.getCargo().getId() == 2);
		
		ArrayList<Treinamento> treinamentos = func.getCargo().getTreinamentos();
		int numeroTreinamentos = treinamentos.size();
		assertTrue("Erro no numero de treinamentos", numeroTreinamentos == 3);
		
		Treinamento t;
		t = treinamentos.get(0);
		assertTrue("Erro no id_treinamento", t.getId() == 1);
		assertTrue("Erro no numero de provas do id_treinamento=1", t.getProvas().size() == 2);
		assertTrue("Erro no id_prova do id_treinamento=1", t.getProvas().get(0).getId() == 1);
		assertTrue("Erro no id_prova do id_treinamento=1", t.getProvas().get(1).getId() == 2);
		
		t = treinamentos.get(1);
		assertTrue("Erro no id_treinamento", t.getId() == 6);
		assertTrue("Erro no numero de provas do id_treinamento=6", t.getProvas().size() == 1);
		assertTrue("Erro no id_prova do id_treinamento=1", t.getProvas().get(0).getId() == 11);
		
		t = treinamentos.get(2);
		assertTrue("Erro no id_treinamento", t.getId() == 7);
		assertTrue("Erro no numero de provas do id_treinamento=7", t.getProvas().size() == 1);
		assertTrue("Erro no id_prova do id_treinamento=7", t.getProvas().get(0).getId() == 12);
	}
}
