package dao;

import entidade.Prova;

public interface InterfaceProvaDAO {
	
	public Prova getProvaPorId(int id);
	
	//TODO adicionar edicao/exclusao de provas?
}
