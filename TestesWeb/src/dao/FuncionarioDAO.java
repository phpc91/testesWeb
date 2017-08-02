package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidade.Funcionario;

public class FuncionarioDAO extends BaseDAO implements InterfaceFuncionarioDAO {
	
	private static final FuncionarioDAO instance = new FuncionarioDAO();
	private static final CargoDAO cargoDAO = CargoDAO.getInstance();
	
	public static FuncionarioDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Funcionario> getFuncionariosPorNome(String nome) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		//TODO e se resultar nulo? preparar pagina de erro 
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Funcionario WHERE nome_funcionario LIKE '%"+nome+"%'");
			
			while(resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt("id_funcionario"));
				funcionario.setCargo(cargoDAO.getCargoPorId(resultSet.getInt("cargo_id")));
				funcionario.setNome(resultSet.getString("nome_funcionario"));
				
				funcionarios.add(funcionario);
			}
			
			conn.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.err.println("Funcionario nao encontrado");
			return null;
		}
		
		return funcionarios;
	}
	
	public Funcionario getFuncionarioPorId(int id) {
		Funcionario funcionario = new Funcionario();
		
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Funcionario WHERE id_funcionario LIKE '"+id+"%'");
			resultSet.next();
			
			funcionario.setId(resultSet.getInt("id_funcionario"));
			funcionario.setCargo(cargoDAO.getCargoPorId(resultSet.getInt("cargo_id")));
			funcionario.setNome(resultSet.getString("nome_funcionario"));
			
			conn.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.err.println("Funcionario nao encontrado");
			return null;
		} 
		
		return funcionario;
	}

}
