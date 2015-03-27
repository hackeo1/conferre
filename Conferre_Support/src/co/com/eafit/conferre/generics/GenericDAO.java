package co.com.eafit.conferre.generics;

import java.util.Collection;

public interface GenericDAO {
	
	public GenericDTO create(GenericDTO parametro);
	public Collection<GenericDTO> read(GenericDTO parametros);
	public GenericDTO update(GenericDTO nuevoObjeto);
	public int delete(GenericDTO objetoaBorrar);
	
}
