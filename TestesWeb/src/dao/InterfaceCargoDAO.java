package dao;

import entidade.Cargo;

public interface InterfaceCargoDAO {
	
	public Cargo getCargoPorId(int id);
	
	//TODO adicionar edicao/exclusao de cargos?
}
