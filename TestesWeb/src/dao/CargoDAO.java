package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidade.Cargo;

public class CargoDAO extends BaseDAO implements InterfaceCargoDAO {
	
	private static final CargoDAO instance = new CargoDAO();
	private static final ProvaDAO provaDao = ProvaDAO.getInstance();
	
	public static CargoDAO getInstance() {
		return instance;
	}
	
	public Cargo getCargoPorId(int id) {
		Cargo cargo = new Cargo();
		
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cargo WHERE id_cargo LIKE '" +id+ "%'");
			resultSet.next();
			
			cargo.setId(resultSet.getInt("id_cargo"));
			cargo.setNome(resultSet.getString("nome_cargo"));
			cargo.setProva(provaDao.getProvaPorId(resultSet.getInt("prova_id")));
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cargo;
	}

}
