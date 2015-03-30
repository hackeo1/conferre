package co.com.eafit.conferre.conferencias.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.conferencias.data.factory.FactoryDAO;
import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.generics.UnitOfWork;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;
import co.com.eafit.conferre.support.ExceptionValidation;

public class BuySillaUseCase implements UnitOfWork {

	@Override
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork {
		SillaTO sillaTO = (SillaTO) parametros;
		SillaTO res = null;
		Collection<GenericDTO> resultado = new ArrayList<GenericDTO>();
		try {
			validarDatosSilla(sillaTO);
			SillaDAO sillaDAO = FactoryDAO.createSillaDAO();
			UUID id = UUID.randomUUID();
			sillaTO.setId(id.toString());
			res= (SillaTO) sillaDAO.create(sillaTO);
			resultado.add(res);
		} catch (ExceptionValidation e) {
			throw new ExceptionUnitOfWork(e);
		}
				
		
		return resultado;
	}
	
	private void validarDatosSilla(SillaTO sillaTO) throws ExceptionValidation{
		if(sillaTO.getPosition() == null){
			throw new ExceptionValidation("La posición de la silla no puede ser nulo");
		}
		
	}

}
