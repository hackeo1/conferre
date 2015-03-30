package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.generics.GenericDAO;
import co.com.eafit.conferre.generics.GenericDTO;

public class SillaDAO implements GenericDAO{
	
	java.sql.Connection  conn;
	
	public SillaDAO(Connection conn2) {
		this.conn = conn2;
	}

	@Override
	public GenericDTO create(GenericDTO parametro) {
		SillaTO sill = null;
		
		try {
			sill = (SillaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO conferencias values(?,?)");
			prep.setString(1, sill.getPosition());
			prep.setString(2, sill.getId());
			int resultado = prep.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sill;
	}

	@Override
	public Collection<GenericDTO> read(GenericDTO parametros) {
		Collection<GenericDTO> conf = null;
		/*
		 * pedir de base de datos quienes cumplan con los parametros
		 * 
		 */
		return conf;
	}

	@Override
	public GenericDTO update(GenericDTO nuevoObjeto, GenericDTO parametros) {
		SillaTO conf = (SillaTO) nuevoObjeto;
		/*
		 * busca por parametros y actualizar en base de datos a nuevo Objeto.
		 */
		return conf;
	}

	@Override
	public int delete(GenericDTO objetoaBorrar) {
		/*
		 * busca por objetoBorrar y eliminar en base de datos.
		 */
		return 1;
	}

	@Override
	public Collection<GenericDTO> readAll() {
		Collection<GenericDTO> result= null; 
		/*
		 * busca todos lo datos de sillas y los devuelve.
		 */
		return result;
	}

}
