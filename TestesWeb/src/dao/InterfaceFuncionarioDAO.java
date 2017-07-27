package dao;

import entidade.Funcionario;

public interface InterfaceFuncionarioDAO {
	
	public Funcionario getFuncionarioPorNome(String nome);
	
	//TODO adicionar edicao/exclusao de funcionarios?
}
