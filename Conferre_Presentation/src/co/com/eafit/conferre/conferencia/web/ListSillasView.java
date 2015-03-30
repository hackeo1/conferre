package co.com.eafit.conferre.conferencia.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencia.web.model.Silla;
import co.com.eafit.conferre.conferencias.business.ConferenciasFacade;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;

@ManagedBean
public class ListSillasView {
	private List<Silla> sillas;
	private ConferenciasFacade confFacade;
	private Silla silla;
	
	@PostConstruct
	public void init() throws ExceptionUnitOfWork{
		sillas = (List<Silla>) confFacade.obtenerSillas();
	}

	public List<Silla> getSillas() {
		return sillas;
	}

	public void setSillas(List<Silla> sillas) {
		this.sillas = sillas;
	}

	public Silla getSilla() {
		return silla;
	}

	public void setSilla(Silla silla) {
		this.silla = silla;
	}
	public ConferenciasFacade getConfFacade() {
		return confFacade;
	}
}
