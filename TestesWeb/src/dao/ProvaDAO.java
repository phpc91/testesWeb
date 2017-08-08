package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidade.Prova;

public class ProvaDAO extends BaseDAO implements InterfaceProvaDAO {
	
	private static final ProvaDAO instance = new ProvaDAO();
	
	public static ProvaDAO getInstance() {
		return instance;
	}
	
	public Prova getProvaPorId(int id) {
		System.out.println("Buscando prova por id="+id);
		Prova prova = new Prova();
		
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Prova WHERE id_prova = "+id+" ");
			resultSet.next();
			
			String[] questoes = new String[10];
			Boolean[] respostas = new Boolean[10];
			
			for(int i=0; i<10; i++) { //TODO vai dar merda se numero de questoes != 10
				questoes[i] = resultSet.getString("questao"+(i+1));
				respostas[i] = resultSet.getBoolean("resposta"+(i+1));
			}
			
			prova.setId(resultSet.getInt("id_prova"));
			prova.setQuestoes(questoes);
			prova.setRespostas(respostas);
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Prova não encontrada");
			return null;
		}
		System.out.println("Prova encontrada");
		return prova;
	}
	
	//TODO add UpdateQuestaoDaProva(int idProva, int numeroQuestao, String questao)
	//"UPDATE Prova SET 'questao'"+numeroQuestao+"="+questao+" WHERE id_prova = "+idProva
}
