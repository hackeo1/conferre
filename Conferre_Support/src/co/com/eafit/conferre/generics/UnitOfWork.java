package co.com.eafit.conferre.generics;

import java.util.Collection;

import co.com.eafit.conferre.support.ExceptionUnitOfWork;

public interface UnitOfWork {
	public Collection<GenericDTO> execute(GenericDTO parametros) throws ExceptionUnitOfWork;
}
