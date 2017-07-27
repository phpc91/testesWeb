package entidade;

/*
 * string questoes, boolean respostas
 */
public class Prova {
	
	private int id;
	private String questoes[] = new String[10];
	private Boolean respostas[] = new Boolean[10];
	
	public int getId() {
		return id;
	}
	
	public String[] getQuestoes() {
		return questoes;
	}
	
	public String getQuestao(int i) {
		return questoes[i];
	}
	
	public Boolean[] getRespostas() {
		return respostas;
	}
	
	public Boolean getResposta(int i) {
		return respostas[i];
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
	
	public void setRespostas(Boolean[] respostas) {
		this.respostas = respostas;
	}
	
	public void setResposta(Boolean resposta, int i) {
		this.respostas[i] = resposta;
	}
}
