package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	
	//TODO passar admin e senha para properties? cripto?
	private static String user="admin", passwd="admin123",
			endpoint="tai-db.cyki8d0w5wwv.sa-east-1.rds.amazonaws.com/testesweb";
	
	public BaseDAO() {
		try{
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	protected static final Connection createConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mariadb://"+endpoint+"?user="+user+"&password="+passwd);
	}
	
	//TODO implementar cache aqui -- try cache, else db
	//serializar classes lidas, escrever no cache.
	//buscar no cache, deserializar 
}
