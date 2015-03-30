package co.com.eafit.conferre.conferencias.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.factory.FactoryDAO;
import co.com.eafit.conferre.data.to.ConferenciaTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.generics.UnitOfWork;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;
import co.com.eafit.conferre.support.ExceptionValidation;

public class CreateConferenciaUseCase implements UnitOfWork {

	@Override
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork {
		ConferenciaTO conferenciaTO = (ConferenciaTO) parametros;
		Collection<GenericDTO> resultado = new ArrayList<GenericDTO>();
		ConferenciaTO res = null;
		try {
			
			validarDatosConferencia(conferenciaTO);
			ConferenciaDAO conferenciaDAO = FactoryDAO.createConferenciaDAO();
			UUID id = UUID.randomUUID();
			conferenciaTO.setId(id.toString());
			res = (ConferenciaTO) conferenciaDAO.create(conferenciaTO);
			resultado.add(res);
			
		} catch (ExceptionValidation e) {
			throw new ExceptionUnitOfWork(e);
		}
		
		return resultado;
	}

	private void validarDatosConferencia(ConferenciaTO conferenciaTO) throws ExceptionValidation{
		if(conferenciaTO.getNombre() == null){
			throw new ExceptionValidation("El nombre de la conferencia no puede ser nulo");
		}
		
	}

}
