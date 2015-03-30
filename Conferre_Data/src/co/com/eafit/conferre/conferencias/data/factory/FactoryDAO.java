package co.com.eafit.conferre.conferencias.data.factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.EspacioDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;

public class FactoryDAO {
	
	public static ConferenciaDAO createConferenciaDAO(){
		Connection conn = createConnection();
		return new ConferenciaDAO(conn);
	}
	
	public static EspacioDAO createEspacioDAO(){
		Connection conn = createConnection();
		return new EspacioDAO(conn);
	}
	
	public static SillaDAO createSillaDAO(){
		Connection conn = createConnection();
		return new SillaDAO(conn);
	}
	
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
