package co.com.eafit.conferre.conferencias.business;

import java.util.Collection;

import co.com.eafit.conferre.conferencias.data.dac.EspacioDAO;
import co.com.eafit.conferre.conferencias.data.factory.FactoryDAO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.generics.UnitOfWork;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;
import co.com.eafit.conferre.support.ExceptionValidation;

public class FindEspacioUseCase implements UnitOfWork {

	@Override
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork {
		EspacioTO espacioTO = (EspacioTO) parametros;
		Collection<GenericDTO> res = null;
		try {
			int peticion =validarDatosEspacio(espacioTO);
			if(peticion == 0){
				EspacioDAO espacioDAO = FactoryDAO.createEspacioDAO();
				res =  espacioDAO.read(espacioTO);
			}else{
				EspacioDAO espacioDAO = FactoryDAO.createEspacioDAO();
				res =  espacioDAO.readAll();
			}
			
		} catch (ExceptionValidation e) {
			throw new ExceptionUnitOfWork(e);
		}
				
		return res;
	}
	
	//retorna  0:normal; 1: si se pide todo;
	private int validarDatosEspacio(EspacioTO espacioTO) throws ExceptionValidation{
		if(espacioTO.getCode() == null){
			throw new ExceptionValidation("El código del espacio no puede ser nulo");
		}else if(espacioTO.getCode().equals("*")){
			return 1;
		}
		return 0;
		
	}


}
