package entidade;

public class Funcionario {
	
	private int id;
	private String nome;
	private Cargo cargo;
	private Treinamento treinamentoAtivo;
	private Prova provaAtiva;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public Treinamento getTreinamentoAtivo() {
		return treinamentoAtivo;
	}
	
	public Prova getProvaAtiva() {
		return provaAtiva;
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
	
	public void setTreinamentoAtivo(Treinamento treinamento) {
		this.treinamentoAtivo = treinamento;
	}
	
	public void setProvaAtiva(Prova prova) {
		this.provaAtiva = prova;
	}
	
}
