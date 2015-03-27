package co.com.eafit.conferre.generics;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;

public class FactoryDAO {
	
	public static ConferenciaDAO createConferenciaDAO(){
		Connection conn = createConnection();
		return new ConferenciaDAO(conn);
	}
	
	// agregar  lo de ↑ pero para todos (lo de ↑ es para conferencia)
	
	public static Connection createConnection(){
		Driver driver;
		Connection conn = null;
		try {
			driver = DriverManager.getDriver("com.mysql.Driver");
			conn = driver.connect("mysql://localhost:3693", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

}
