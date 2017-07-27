package entidade;

public class Cargo {
	
	private int id;
	private String nome;
	private Prova prova;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Prova getProva() {
		return prova;
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
	
}
