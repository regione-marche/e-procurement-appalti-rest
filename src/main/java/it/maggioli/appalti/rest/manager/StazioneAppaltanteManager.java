package it.maggioli.appalti.rest.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.dto.StazioneAppaltanteEsteso;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltante;
import it.maggioli.appalti.rest.repositories.views.ws.StazioneAppaltanteRepository;

@Service
public class StazioneAppaltanteManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private StazioneAppaltanteRepository sa;

	public List<StazioneAppaltante> findAll() {
		return sa.findAll();
	}

	public List<StazioneAppaltanteEsteso> findAllEsteso() {
		List<StazioneAppaltante> listaFrom = sa.findAll();
		return listaFrom.stream().map(e->{
			StazioneAppaltanteEsteso transformed = new StazioneAppaltanteEsteso();
			BeanUtils.copyProperties(e, transformed);
			return transformed;
		}).collect(Collectors.toList());
			
	}

}
