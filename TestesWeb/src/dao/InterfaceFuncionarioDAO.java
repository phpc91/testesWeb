package dao;

import java.util.ArrayList;

import entidade.Funcionario;

public interface InterfaceFuncionarioDAO {
	
	public ArrayList<Funcionario> getFuncionariosPorNome(String nome);
	public Funcionario getFuncionarioPorId(int id);
	
	//TODO adicionar edicao/exclusao de funcionarios?
}
