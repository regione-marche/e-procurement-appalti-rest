package it.maggioli.appalti.rest.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Enum dei tipi documento
 * @author gabriele.nencini
 *
 */
public enum DocumentoGruppoEnum {
  
  DOCUMENTO_BANDO_LOTTO(1),
  DOCUMENTO_INVITO_LOTTO(6),
  DOCUMENTO_INVITO_ASTA_LOTTO(12),
  REQUISITO_RICHIESTO_BANDO_LOTTO(2)
//  ,REQUISITO_RICHIESTO_BANDO(2)//TODO to be defined
  ;
  
  private static final Map<Integer, DocumentoGruppoEnum> BY_VALUE = new HashMap<Integer, DocumentoGruppoEnum>();
  static {
    for (DocumentoGruppoEnum e: values()) {
      BY_VALUE.put(e.value, e);
    }
  }

  public final Integer value;
  
  private DocumentoGruppoEnum(Integer value) {
    this.value = value;
  }
  
  public static Set<Integer> getListByValues() {
    return BY_VALUE.keySet();
  }
}
