package co.com.eafit.conferre.conferencias.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import co.com.eafit.conferre.conferencia.web.model.Conferencia;
import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencia.web.model.Silla;
import co.com.eafit.conferre.data.to.ConferenciaTO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.generics.GenericDTO;

public class Utilities {

	static public ConferenciaTO toConferenciaTO(Conferencia confe) {
		ConferenciaTO result = new ConferenciaTO();
		result.setFecha(confe.getFecha());
		result.setId(confe.getId());
		result.setNombre(confe.getNombre());
		result.setNombreConferencista(confe.getNombreConferencista());
		result.setSillasDisponibles(confe.getSillasDisponibles());
		result.setTipo(confe.getTipo());
		return result;
	}

	static public Conferencia toConferencia(ConferenciaTO confe) {
		Conferencia result = new Conferencia();
		result.setFecha(confe.getFecha());
		result.setId(confe.getId());
		result.setNombre(confe.getNombre());
		result.setNombreConferencista(confe.getNombreConferencista());
		result.setSillasDisponibles(confe.getSillasDisponibles());
		result.setTipo(confe.getTipo());
		return result;
	}
	
	static public Collection<ConferenciaTO> genericsToConferencias(Collection<GenericDTO> generics){
	    Iterator<GenericDTO> it = generics.iterator();
	    Collection<ConferenciaTO> result= new ArrayList<ConferenciaTO>();
	    while(it.hasNext())
	    	result.add((ConferenciaTO)it.next());
		return result;
	}

	static public SillaTO toSillaTO(Silla silla) {
		SillaTO result = new SillaTO(silla.getId(),silla.getPosition());
		return result;
	}

	static public Silla toSilla(SillaTO silla) {
		Silla result = new Silla();
		result.setId(silla.getId());
		result.setPosition(silla.getPosition());
		return result;
	}
	
	static public Collection<SillaTO> genericsToSillas(Collection<GenericDTO> generics){
	    Iterator<GenericDTO> it = generics.iterator();
	    Collection<SillaTO> result= new ArrayList<SillaTO>();
	    while(it.hasNext())
	    	result.add((SillaTO)it.next());
		return result;
	}

	public EspacioTO toEspacioTO(Espacio espacio) {
		EspacioTO result = new EspacioTO(espacio.getCode(), espacio.getId());
		return result;
	}

	static public Espacio toEspacio(EspacioTO espacio) {
		Espacio result = new Espacio();
		result.setCode(espacio.getCode());
		result.setId(espacio.getId());
		return result;
	}
	
	static public Collection<EspacioTO> genericsToEspacios(Collection<GenericDTO> generics){
	    Iterator<GenericDTO> it = generics.iterator();
	    Collection<EspacioTO> result= new ArrayList<EspacioTO>();
	    while(it.hasNext())
	    	result.add((EspacioTO)it.next());
		return result;
	}
	
	
}
