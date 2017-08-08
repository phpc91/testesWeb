package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidade.Prova;
import entidade.Treinamento;

public class TreinamentoDAO extends BaseDAO implements InterfaceTreinamentoDAO {
	
	private static final TreinamentoDAO instance = new TreinamentoDAO();
	
	public static TreinamentoDAO getInstance() {
		return instance;
	}
	
	public Treinamento getTreinamentoPorId(int id) {
		System.out.println("Buscando treinamento por id="+id);
		Treinamento treinamento = new Treinamento();
		
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Treinamento WHERE id_treinamento ="+id+" ");
			resultSet.next();
			
			int idTreinamento = resultSet.getInt("id_treinamento");
			treinamento.setId(idTreinamento);
			treinamento.setNome(resultSet.getString("nome_treinamento"));
			treinamento.setProvas(getProvas(idTreinamento));
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Treinamento não encontrado");
			return null;
		}
		System.out.println("Treinamento encontrado");
		return treinamento;
	}

	public Treinamento getTreinamentoPorNome(String nome) {
		System.out.println("Buscando treinamento por nome="+nome);
		Treinamento treinamento = new Treinamento();
		
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Treinamento WHERE nome_treinamento LIKE '%"+nome+"%' ");
			resultSet.next();
			
			int idTreinamento = resultSet.getInt("id_treinamento");
			treinamento.setId(idTreinamento);
			treinamento.setNome(resultSet.getString("nome_treinamento"));
			treinamento.setProvas(getProvas(idTreinamento));
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Treinamento não encontrado");
			return null;
		}
		System.out.println("Treinamento encontrado");
		return treinamento;
	}
	
	private ArrayList<Prova> getProvas(int idTreinamento) {
		System.out.println("Buscando todas as provas para id_treinamento="+idTreinamento);
		ArrayList<Prova> provas = new ArrayList<Prova>();
		ProvaDAO provaDAO = ProvaDAO.getInstance();
		
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id_prova FROM Prova WHERE treinamento_id = "+idTreinamento+" "
					+ "ORDER BY id_prova ASC");
			
			while(resultSet.next()){
				Prova prova = new Prova();
				prova = provaDAO.getProvaPorId(resultSet.getInt("id_prova"));
				provas.add(prova);
			}
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Provas para o id_treinamento="+idTreinamento+" não encontradas");
			return null;
		}
		System.out.println("Provas encontradas");
		return provas;
	}

}
