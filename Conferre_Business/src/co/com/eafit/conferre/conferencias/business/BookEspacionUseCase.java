package co.com.eafit.conferre.conferencias.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.dac.EspacioDAO;
import co.com.eafit.conferre.conferencias.data.factory.FactoryDAO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.generics.UnitOfWork;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;
import co.com.eafit.conferre.support.ExceptionValidation;

public class BookEspacionUseCase implements UnitOfWork {

	@Override
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork {
		EspacioTO espacioTO = (EspacioTO) parametros;
		EspacioTO res = null;
		Collection<GenericDTO> resultado = new ArrayList<GenericDTO>();
		try {
			validarDatosEspacio(espacioTO);
			EspacioDAO espacioDAO = FactoryDAO.createEspacioDAO();
			UUID id = UUID.randomUUID();
			espacioTO.setId(id.toString());
			res = (EspacioTO) espacioDAO.create(espacioTO);
			resultado.add(res);
			
		} catch (ExceptionValidation e) {
			throw new ExceptionUnitOfWork(e);
		}
				
		return resultado;
	}
	
	private void validarDatosEspacio(EspacioTO espacioTO) throws ExceptionValidation{
		if(espacioTO.getCode() == null){
			throw new ExceptionValidation("El código del espacio no puede ser nulo");
		}
		
	}

}
