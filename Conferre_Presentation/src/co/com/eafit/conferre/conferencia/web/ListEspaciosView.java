package co.com.eafit.conferre.conferencia.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencias.business.ConferenciasFacade;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;

@ManagedBean
public class ListEspaciosView {
	private List<Espacio> espacios;
	private ConferenciasFacade confFacade;
	private Espacio espacio;
	
	@PostConstruct
	public void init() throws ExceptionUnitOfWork{
		espacios = (List<Espacio>) confFacade.obtenerEspacios();
	}
	
	public List<Espacio> getEspacios() {
		return espacios;
	}
	public void setEspacios(List<Espacio> espacios) {
		this.espacios = espacios;
	}
	public Espacio getEspacio() {
		return espacio;
	}
	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}
	public ConferenciasFacade getConfFacade() {
		return confFacade;
	}
	
	
}
