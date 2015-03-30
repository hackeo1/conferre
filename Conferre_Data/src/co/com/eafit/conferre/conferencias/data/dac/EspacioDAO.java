package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import co.com.eafit.conferre.data.to.ConferenciaTO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.generics.GenericDAO;
import co.com.eafit.conferre.generics.GenericDTO;

public class EspacioDAO implements GenericDAO {

	java.sql.Connection  conn;
	
	public EspacioDAO(Connection conn2) {
		this.conn = conn2;
	}
	@Override
	public GenericDTO create(GenericDTO parametro) {
		EspacioTO esp = null;
		
		try {
			esp = (EspacioTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO conferencias values(?,?)");
			prep.setString(1, esp.getCode());
			prep.setString(2, esp.getId());
			int resultado = prep.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return esp;
	}

	@Override
	public Collection<GenericDTO> read(GenericDTO parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericDTO update(GenericDTO nuevoObjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(GenericDTO objetoaBorrar) {
		// TODO Auto-generated method stub
		return 0;
	}

}
