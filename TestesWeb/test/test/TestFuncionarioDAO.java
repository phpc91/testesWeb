package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.FuncionarioDAO;
import entidade.Funcionario;

public class TestFuncionarioDAO {
	
	FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();
	
	@Test
	public void testGetFuncionarioPorNome() {
		String nome = "Jose"; //id=1, José Da Silva, cargo_id=1 >> prova_id=1
		ArrayList<Funcionario> func = funcionarioDAO.getFuncionariosPorNome(nome);
		
		assertTrue("Erro no nome encontrado", func.get(0).getNome().equals("José Da Silva"));
		assertTrue("Erro no cargo_id", func.get(0).getCargo().getId() == 1);
		assertTrue("Erro no id_funcionário", func.get(0).getId() == 1);
		assertTrue("Erro no tipo de prova", func.get(0).getCargo().getProva().getId() == 1);
	}

}
