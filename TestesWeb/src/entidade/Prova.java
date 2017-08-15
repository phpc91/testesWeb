package entidade;

public class Prova {
	
	private int id;
	private String questoes[];
	private Boolean gabarito[];
	
	public int getId() {
		return id;
	}
	
	public String[] getQuestoes() {
		return questoes;
	}
	
	public String getQuestao(int i) {
		return questoes[i];
	}
	/**
	 * Retorna gabarito completo da prova
	 * @return Boolean[] gabarito completo
	 */
	public Boolean[] getGabarito() {
		return gabarito;
	}
	/**
	 * Retorna gabarito de uma única questão
	 * @param i indice da questao (iniciado em 0)
	 * @return Boolean gabarito da questao i
	 */
	public Boolean getGabaritoDaQuestao(int i) {
		return gabarito[i];
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setQuestoes(String[] questoes) {
		this.questoes = questoes;
	}
	
	public void setQuestao(String questao, int i) {
		this.questoes[i] = questao;
	}
	
	public void setGabarito(Boolean[] gabarito) {
		this.gabarito = gabarito;
	}
	
	public void setGabaritoDaQuestao(Boolean gabarito, int i) {
		this.gabarito[i] = gabarito;
	}
}
