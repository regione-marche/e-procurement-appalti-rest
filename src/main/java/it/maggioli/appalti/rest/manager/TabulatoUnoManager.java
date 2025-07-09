package it.maggioli.appalti.rest.manager;

import it.maggioli.appalti.rest.dto.TabulatoDto;
import it.maggioli.appalti.rest.repositories.TabulatoUnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabulatoUnoManager {

    @Autowired
    private TabulatoUnoRepository tabUnoRepo;

    public List<TabulatoDto> findDtoByCodiceFilteringArchOrderByOrdinamento(String codice) {
        return tabUnoRepo.findDtoByCodiceFilteringArchOrderByOrdinamento(codice);
    }

    public List<TabulatoDto> getTipologiaAvviso(String codice) {
        List<TabulatoDto> tabulati = findDtoByCodiceFilteringArchOrderByOrdinamento(codice);

        TabulatoDto tabElencoOperatoreEconomico = new TabulatoDto(0, "Elenco operatori economici");
        if (!tabulati.contains(tabElencoOperatoreEconomico))
            tabulati.add(tabElencoOperatoreEconomico);

        return tabulati;
    }

}
