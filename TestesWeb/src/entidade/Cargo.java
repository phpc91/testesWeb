package entidade;

import java.util.ArrayList;

public class Cargo {
	
	private int id;
	private String nome;
	private Prova prova;
	private ArrayList<Treinamento> treinamentos;
	
	public Cargo() {
		treinamentos = new ArrayList<Treinamento>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Prova getProva() {
		return prova;
	}
	
	public ArrayList<Treinamento> getTreinamentos() {
		return treinamentos;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	public void setTreinamentos(ArrayList<Treinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}
	
	public void addTreinamento(Treinamento treinamento) {
		this.treinamentos.add(treinamento);
	}
	
}
