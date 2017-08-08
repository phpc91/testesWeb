package entidade;

import java.util.ArrayList;

public class Treinamento {
	
	private String nome;
	private int id;
	private ArrayList<Prova> provas;
	
	public Treinamento() {
		provas = new ArrayList<Prova>();
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Prova> getProvas() {
		return provas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setProvas(ArrayList<Prova> provas) {
		this.provas = provas;
	}
	
	public void addProva(Prova prova) {
		this.provas.add(prova);
	}
}
