package it.maggioli.appalti.rest.enums;

import io.swagger.annotations.ApiModel;

/**
 * Enum dello stato di un Bando di gara o Avviso
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "statoInCorsoScaduto",description = "Enumeration per definire se la ricerca debba avvenire per dati scaduti o in corso")
public enum StatoInCorsoScadutoEnum {
  INCORSO,SCADUTO
}
