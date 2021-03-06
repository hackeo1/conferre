package co.com.eafit.conferre.conferencia.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import co.com.eafit.conferre.conferencia.web.model.Conferencia;
import co.com.eafit.conferre.conferencias.business.ConferenciasFacade;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;

@ManagedBean
public class ListConferenciasView {
	private List<Conferencia> conferencias;
	private ConferenciasFacade confFacade;
	private Conferencia conferencia;
	
	

	@PostConstruct
	public void init() throws ExceptionUnitOfWork{
		conferencias = (List<Conferencia>) confFacade.obtenerConferencias();
	}

	public List<Conferencia> getConferencias() {
		return conferencias;
	}

	public void setConferencias(List<Conferencia> conferencias) {
		this.conferencias = conferencias;
	}
	
	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}
	public ConferenciasFacade getConfFacade() {
		return confFacade;
	}
	
}
