package co.com.eafit.conferre.conferencias.business;

import java.util.Collection;

import co.com.eafit.conferre.conferencia.web.model.Conferencia;
import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencia.web.model.Silla;
import co.com.eafit.conferre.data.to.ConferenciaTO;
import co.com.eafit.conferre.data.to.EspacioTO;
import co.com.eafit.conferre.data.to.SillaTO;
import co.com.eafit.conferre.generics.GenericDTO;
import co.com.eafit.conferre.support.ExceptionUnitOfWork;

import static java.util.stream.Collectors.toList;

public class ConferreBusinessFacade implements ConferenciasFacade {

	@Override
	public ConferenciaTO crearConferencia(ConferenciaTO conferencia) throws ExceptionUnitOfWork {
		CreateConferenciaUseCase useCase = new CreateConferenciaUseCase();
		GenericDTO param = conferencia;
		ConferenciaTO result = (ConferenciaTO) useCase.execute(param);
		return result;
	}

	@Override
	public SillaTO comprarSilla(SillaTO silla) throws ExceptionUnitOfWork {
		BuySillaUseCase useCase = new BuySillaUseCase();
		GenericDTO param = silla;
		SillaTO result = (SillaTO) useCase.execute(param);
		return result;
	}

	@Override
	public EspacioTO reservarEspacio(EspacioTO espacio) throws ExceptionUnitOfWork{
		BookEspacionUseCase useCase = new BookEspacionUseCase();
		GenericDTO param = espacio;
		EspacioTO resul = (EspacioTO) useCase.execute(param);
		return resul;
	}

	@Override
	public Conferencia obtenerConferencia(ConferenciaTO conferencia) throws ExceptionUnitOfWork {
		FindConferenciaUseCase useCase = new FindConferenciaUseCase();
		GenericDTO param = conferencia;
		ConferenciaTO resultDTO = (ConferenciaTO) useCase.execute(param);
		Conferencia result = Utilities.toConferencia(resultDTO);
		return result;
	}

	@Override
	public Silla obtenerSilla(SillaTO silla) throws ExceptionUnitOfWork {
		FindSillaUseCase useCase = new FindSillaUseCase();
		GenericDTO param = silla;
		SillaTO resultDTO = (SillaTO) useCase.execute(param);
		Silla result = Utilities.toSilla(resultDTO);
		return result;
	}

	@Override
	public Espacio obtenerEspacio(EspacioTO espacio) throws ExceptionUnitOfWork {
		FindEspacioUseCase useCase = new FindEspacioUseCase();
		GenericDTO param = espacio;
		EspacioTO resultDTO = (EspacioTO) useCase.execute(param);
		Espacio result = Utilities.toEspacio(resultDTO);
		return result;
	}

	@Override
	public Collection<Conferencia> obtenerConferencias() throws ExceptionUnitOfWork {
		FindConferenciaUseCase useCase = new FindConferenciaUseCase();
		ConferenciaTO param = new ConferenciaTO();
		param.setNombre("*");
		Collection<GenericDTO> resultDTO = useCase.execute(param);
		Collection<ConferenciaTO> res = Utilities.genericsToConferencias(resultDTO);
		Collection<Conferencia> result = res.stream().map(x -> Utilities.toConferencia(x)).collect(toList());
		return result;
	}

	@Override
	public Collection<Silla> obtenerSillas() throws ExceptionUnitOfWork {
		FindSillaUseCase useCase = new FindSillaUseCase();
		SillaTO param = new SillaTO("*","*");
		Collection<GenericDTO> resultDTO = useCase.execute(param);
		Collection<SillaTO> res = Utilities.genericsToSillas(resultDTO);
		Collection<Silla> result = res.stream().map(x -> Utilities.toSilla(x)).collect(toList());
		return result;
	}

	@Override
	public Collection<Espacio> obtenerEspacios() throws ExceptionUnitOfWork {
		FindEspacioUseCase useCase = new FindEspacioUseCase();
		EspacioTO param = new EspacioTO("*","*");
		Collection<GenericDTO> resultDTO = useCase.execute(param);
		Collection<EspacioTO> res = Utilities.genericsToEspacios(resultDTO);
		Collection<Espacio> result = res.stream().map(x -> Utilities.toEspacio(x)).collect(toList());
		return result;
	}



}
