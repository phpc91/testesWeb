package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidade.Cargo;
import entidade.Treinamento;

public class CargoDAO extends BaseDAO implements InterfaceCargoDAO {
	
	private static final CargoDAO instance = new CargoDAO();
	
	public static CargoDAO getInstance() {
		return instance;
	}
	
	public Cargo getCargoPorId(int id) {
		System.out.println("Buscando cargo por id="+id);
		Cargo cargo = new Cargo();
		
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cargo WHERE id_cargo = "+id+" ");
			resultSet.next();
			
			int idCargo = resultSet.getInt("id_cargo");
			cargo.setId(idCargo);
			cargo.setNome(resultSet.getString("nome_cargo"));
			cargo.setTreinamentos(getTreinamentos(idCargo));
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Cargo não encontrado");
			return null;
		}
		System.out.println("Cargo encontrado");
		return cargo;
	}
	
	private ArrayList<Treinamento> getTreinamentos(int idCargo) {
		System.out.println("Buscando os treinamentos para o cargo="+idCargo);
		ArrayList<Treinamento> treinamentos = new ArrayList<Treinamento>();
		TreinamentoDAO dao = TreinamentoDAO.getInstance();
		
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT treinamento_id FROM CargoFazTreinamento WHERE cargo_id = "+idCargo+" "
					+ "ORDER BY treinamento_id ASC ");
			
			while(resultSet.next()){
				Treinamento t = new Treinamento();
				t = dao.getTreinamentoPorId(resultSet.getInt("treinamento_id"));
				treinamentos.add(t);
			}
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Treinamentos para id_cargo="+idCargo+" não encontrados");
			return null;
		}
		System.out.println("Treinamentos encontrados");
		return treinamentos;
	}

}
