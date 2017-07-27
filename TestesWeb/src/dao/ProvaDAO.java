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
		Prova prova = new Prova();
		
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("");
			resultSet.next();
			
			String[] questoes = new String[10];
			Boolean[] respostas = new Boolean[10];
			
			for(int i=1; i<=10; i++) {
				questoes[i] = resultSet.getString("questao"+i);
				respostas[i] = resultSet.getBoolean("resposta"+i);
			}
			
			prova.setId(resultSet.getInt("id_prova"));
			prova.setQuestoes(questoes);
			prova.setRespostas(respostas);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prova;
	}

}
