package entidade;

public class Funcionario {
	
	private int id;
	private String nome;
	private Cargo cargo;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}
