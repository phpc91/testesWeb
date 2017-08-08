package dao;

import entidade.Treinamento;

public interface InterfaceTreinamentoDAO {
	
	public Treinamento getTreinamentoPorId(int id);
	public Treinamento getTreinamentoPorNome(String nome);
}
