package co.com.eafit.conferre.conferencias.business;

import java.util.Collection;
import co.com.eafit.conferre.conferencia.web.model.Conferencia;
import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencia.web.model.Silla;
import co.com.eafit.conferre.data.to.ConferenciaTO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;

public interface ConferenciasFacade {
	public ConferenciaTO crearConferencia(ConferenciaTO conferencia) throws ExceptionUnitOfWork;
	
	public SillaTO comprarSilla(SillaTO silla) throws ExceptionUnitOfWork;

	public EspacioTO reservarEspacio(EspacioTO espacio) throws ExceptionUnitOfWork; 
	
	public Conferencia obtenerConferencia(ConferenciaTO conferencia) throws ExceptionUnitOfWork;
	
	public Silla obtenerSilla(SillaTO silla) throws ExceptionUnitOfWork;
	
	public Espacio obtenerEspacio(EspacioTO espacio) throws ExceptionUnitOfWork;
	
	public Collection<Conferencia> obtenerConferencias() throws ExceptionUnitOfWork;
	
	public Collection<Silla> obtenerSillas() throws ExceptionUnitOfWork;
	
	public Collection<Espacio> obtenerEspacios() throws ExceptionUnitOfWork;
	
	
}
