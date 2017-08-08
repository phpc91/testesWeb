package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dao.CargoDAO;
import entidade.Cargo;
import entidade.Treinamento;

public class TestCargoDAO {
	
	CargoDAO dao = CargoDAO.getInstance();
	ArrayList<Treinamento> treinamentos;
	String nome = "Cargo 1";
	int id = 1, numeroDeTreinamentos = 4;
	
	@Test
	public void testGetCargoPorId() {
		Cargo cargo = dao.getCargoPorId(id);
		assertTrue("Erro no id_cargo obtido", cargo.getId() == id);
		assertTrue("Erro no nome_cargo obtido", cargo.getNome().equals(nome));
		
		treinamentos = cargo.getTreinamentos(); //treinamentos id=1,2,3,5
		assertTrue("Erro no número de treinamentos", treinamentos.size() == numeroDeTreinamentos);
		assertTrue("Erro no id_treinamento", treinamentos.get(0).getId() == 1);
		assertTrue("Erro no id_treinamento", treinamentos.get(1).getId() == 2);
		assertTrue("Erro no id_treinamento", treinamentos.get(2).getId() == 3);
		assertTrue("Erro no id_treinamento", treinamentos.get(3).getId() == 5);
	}

}
