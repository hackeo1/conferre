package co.com.eafit.conferre.conferencias.business;

import java.util.Collection;

import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.conferencias.data.factory.FactoryDAO;
import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.generics.UnitOfWork;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;
import co.com.eafit.conferre.support.ExceptionValidation;

public class FindSillaUseCase implements UnitOfWork {

	@Override
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork {
		SillaTO sillaTO = (SillaTO) parametros;
		Collection<GenericDTO> resultado = null;
		try {
			
			int peticion = validarDatosSilla(sillaTO);
			if(peticion == 0){
				SillaDAO sillaDAO = FactoryDAO.createSillaDAO();
				resultado = sillaDAO.read(sillaTO);
			}else{
				SillaDAO sillaDAO = FactoryDAO.createSillaDAO();
				resultado = sillaDAO.readAll();
			}
			
		} catch (ExceptionValidation e) {
			throw new ExceptionUnitOfWork(e);
		}
				
		return resultado;
	}
	
	//retorna  0:normal; 1: si se pide todo;
	private int validarDatosSilla(SillaTO sillaTO) throws ExceptionValidation{
		if(sillaTO.getPosition() == null){
			throw new ExceptionValidation("La posici�n de la silla no puede ser nulo");
		}else if(sillaTO.getPosition().equals("*")){
			return 1;
		}
		return 0;
		
	}

}
