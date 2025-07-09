package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * Dto per le aggiudicazioni
 * @author gabriele.nencini
 *
 */
public class AggiudicazioniDto {
  private String codicegara;
  private String codicelotto;
  private Integer codicecontratto;
  private String idanac;
  private String cig;
  private Date dataacquisizionecig;
  private String navvisobando;
  private Date dtaperturaofferte;
  private String codaggiudicatario;
  private String denominazioneaggiudicatario;
  private Integer tpprocedura;
  private Integer modaggiudicazione;
  private Date dtverbaggiudicazione;
  private Integer tpattoaggiudicazione;
  private String nattoaggiudicazione;
  private Date dtaggiudicazione;
  private Date dtcomunicaggiudicataria;
  private String protcomunicaggiudicataria;
  private BigDecimal ribassooepv;
  private BigDecimal ribasso;
  private String richiestosubappalto;
  private Integer tpcontratto;
  private String nrepertorio;
  private Date dtcontratto;
  private String ncontratto;
  private String luogoregistrazionecontratto;
  private String nregistrazionecontratto;
  private Date dtregistrazionecontratto;
  private BigDecimal impaggiudicazione;
  private String riduzionegaranziaperiso;
  private BigDecimal impgaranzia;
  private String npolizzagaranziadef;
  private Date dtpolizzagaranziadef;
  private String istitutopolizzagaranziadef;
  private Date dtscadenzapolizzagaranziadef;
  private Date dtconsegna;
  private String ncontocorrente;
  private String biccontocorrente;
  private String bancacontocorrente;
  private BigDecimal impbasegara;
  private BigDecimal imponerisicurezza;
  private BigDecimal imponerisicurezzaamisura;
  private BigDecimal imponerisicurezzaacorpo;
  private BigDecimal impbasegaraopereacorpo;
  private BigDecimal impbasegaraopereamisura;
  private BigDecimal impnonsoggettoribasso;
  private BigDecimal impnonsoggettoribassoamisura;
  private BigDecimal impnonsoggettoribassoacorpo;
  private BigDecimal imponeriprogettazione;
  private String oneriprogettazionesoggribasso;
  private String cpvprincipale;
  private String oggetto;
  private String ubicazionedettaglio;
  private String ubicazione;
  private String provincia;
  private String comune;
  private String codistatcomune;
  private String cup;
  private String cui;
  private Integer tpattoacontrarre;
  private String nattoacontrarre;
  private Date dtattoacontrarre;
  private String sommeurgenze;
  private String uffint;
  
  private OperatoreEconomicoDto aggiudicataria;
  
  /**
   * @return the codicegara
   */
  public String getCodicegara() {
    return codicegara;
  }
  
  /**
   * @param codicegara the codicegara to set
   */
  public void setCodicegara(String codicegara) {
    this.codicegara = codicegara;
  }
  
  /**
   * @return the codicelotto
   */
  public String getCodicelotto() {
    return codicelotto;
  }
  
  /**
   * @param codicelotto the codicelotto to set
   */
  public void setCodicelotto(String codicelotto) {
    this.codicelotto = codicelotto;
  }
  
  /**
   * @return the codicecontratto
   */
  public Integer getCodicecontratto() {
    return codicecontratto;
  }
  
  /**
   * @param codicecontratto the codicecontratto to set
   */
  public void setCodicecontratto(Integer codicecontratto) {
    this.codicecontratto = codicecontratto;
  }
  
  /**
   * @return the idanac
   */
  public String getIdanac() {
    return idanac;
  }
  
  /**
   * @param idanac the idanac to set
   */
  public void setIdanac(String idanac) {
    this.idanac = idanac;
  }
  
  /**
   * @return the cig
   */
  public String getCig() {
    return cig;
  }
  
  /**
   * @param cig the cig to set
   */
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  /**
   * @return the dataacquisizionecig
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataacquisizionecig() {
    return dataacquisizionecig;
  }
  
  /**
   * @param dataacquisizionecig the dataacquisizionecig to set
   */
  public void setDataacquisizionecig(Date dataacquisizionecig) {
    this.dataacquisizionecig = dataacquisizionecig;
  }
  
  /**
   * @return the navvisobando
   */
  public String getNavvisobando() {
    return navvisobando;
  }
  
  /**
   * @param navvisobando the navvisobando to set
   */
  public void setNavvisobando(String navvisobando) {
    this.navvisobando = navvisobando;
  }
  
  /**
   * @return the dtaperturaofferte
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtaperturaofferte() {
    return dtaperturaofferte;
  }
  
  /**
   * @param dtaperturaofferte the dtaperturaofferte to set
   */
  public void setDtaperturaofferte(Date dtaperturaofferte) {
    this.dtaperturaofferte = dtaperturaofferte;
  }
  
  /**
   * @return the codaggiudicatario
   */
  public String getCodaggiudicatario() {
    return codaggiudicatario;
  }
  
  /**
   * @param codaggiudicatario the codaggiudicatario to set
   */
  public void setCodaggiudicatario(String codaggiudicatario) {
    this.codaggiudicatario = codaggiudicatario;
  }
  
  /**
   * @return the denominazioneaggiudicatario
   */
  public String getDenominazioneaggiudicatario() {
    return denominazioneaggiudicatario;
  }
  
  /**
   * @param denominazioneaggiudicatario the denominazioneaggiudicatario to set
   */
  public void setDenominazioneaggiudicatario(String denominazioneaggiudicatario) {
    this.denominazioneaggiudicatario = denominazioneaggiudicatario;
  }
  
  /**
   * @return the tpprocedura
   */
  public Integer getTpprocedura() {
    return tpprocedura;
  }
  
  /**
   * @param tpprocedura the tpprocedura to set
   */
  public void setTpprocedura(Integer tpprocedura) {
    this.tpprocedura = tpprocedura;
  }
  
  /**
   * @return the modaggiudicazione
   */
  public Integer getModaggiudicazione() {
    return modaggiudicazione;
  }
  
  /**
   * @param modaggiudicazione the modaggiudicazione to set
   */
  public void setModaggiudicazione(Integer modaggiudicazione) {
    this.modaggiudicazione = modaggiudicazione;
  }
  
  /**
   * @return the dtverbaggiudicazione
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtverbaggiudicazione() {
    return dtverbaggiudicazione;
  }
  
  /**
   * @param dtverbaggiudicazione the dtverbaggiudicazione to set
   */
  public void setDtverbaggiudicazione(Date dtverbaggiudicazione) {
    this.dtverbaggiudicazione = dtverbaggiudicazione;
  }
  
  /**
   * @return the tpattoaggiudicazione
   */
  public Integer getTpattoaggiudicazione() {
    return tpattoaggiudicazione;
  }
  
  /**
   * @param tpattoaggiudicazione the tpattoaggiudicazione to set
   */
  public void setTpattoaggiudicazione(Integer tpattoaggiudicazione) {
    this.tpattoaggiudicazione = tpattoaggiudicazione;
  }
  
  /**
   * @return the nattoaggiudicazione
   */
  public String getNattoaggiudicazione() {
    return nattoaggiudicazione;
  }
  
  /**
   * @param nattoaggiudicazione the nattoaggiudicazione to set
   */
  public void setNattoaggiudicazione(String nattoaggiudicazione) {
    this.nattoaggiudicazione = nattoaggiudicazione;
  }
  
  /**
   * @return the dtaggiudicazione
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtaggiudicazione() {
    return dtaggiudicazione;
  }
  
  /**
   * @param dtaggiudicazione the dtaggiudicazione to set
   */
  public void setDtaggiudicazione(Date dtaggiudicazione) {
    this.dtaggiudicazione = dtaggiudicazione;
  }
  
  /**
   * @return the dtcomunicaggiudicataria
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtcomunicaggiudicataria() {
    return dtcomunicaggiudicataria;
  }
  
  /**
   * @param dtcomunicaggiudicataria the dtcomunicaggiudicataria to set
   */
  public void setDtcomunicaggiudicataria(Date dtcomunicaggiudicataria) {
    this.dtcomunicaggiudicataria = dtcomunicaggiudicataria;
  }
  
  /**
   * @return the protcomunicaggiudicataria
   */
  public String getProtcomunicaggiudicataria() {
    return protcomunicaggiudicataria;
  }
  
  /**
   * @param protcomunicaggiudicataria the protcomunicaggiudicataria to set
   */
  public void setProtcomunicaggiudicataria(String protcomunicaggiudicataria) {
    this.protcomunicaggiudicataria = protcomunicaggiudicataria;
  }
  
  /**
   * @return the ribassooepv
   */
  public BigDecimal getRibassooepv() {
    return ribassooepv;
  }
  
  /**
   * @param ribassooepv the ribassooepv to set
   */
  public void setRibassooepv(BigDecimal ribassooepv) {
    this.ribassooepv = ribassooepv;
  }
  
  /**
   * @return the ribasso
   */
  public BigDecimal getRibasso() {
    return ribasso;
  }
  
  /**
   * @param ribasso the ribasso to set
   */
  public void setRibasso(BigDecimal ribasso) {
    this.ribasso = ribasso;
  }
  
  /**
   * @return the richiestosubappalto
   */
  public String getRichiestosubappalto() {
    return richiestosubappalto;
  }
  
  /**
   * @param richiestosubappalto the richiestosubappalto to set
   */
  public void setRichiestosubappalto(String richiestosubappalto) {
    this.richiestosubappalto = richiestosubappalto;
  }
  
  /**
   * @return the tpcontratto
   */
  public Integer getTpcontratto() {
    return tpcontratto;
  }
  
  /**
   * @param tpcontratto the tpcontratto to set
   */
  public void setTpcontratto(Integer tpcontratto) {
    this.tpcontratto = tpcontratto;
  }
  
  /**
   * @return the nrepertorio
   */
  public String getNrepertorio() {
    return nrepertorio;
  }
  
  /**
   * @param nrepertorio the nrepertorio to set
   */
  public void setNrepertorio(String nrepertorio) {
    this.nrepertorio = nrepertorio;
  }
  
  /**
   * @return the dtcontratto
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtcontratto() {
    return dtcontratto;
  }
  
  /**
   * @param dtcontratto the dtcontratto to set
   */
  public void setDtcontratto(Date dtcontratto) {
    this.dtcontratto = dtcontratto;
  }
  
  /**
   * @return the ncontratto
   */
  public String getNcontratto() {
    return ncontratto;
  }
  
  /**
   * @param ncontratto the ncontratto to set
   */
  public void setNcontratto(String ncontratto) {
    this.ncontratto = ncontratto;
  }
  
  /**
   * @return the luogoregistrazionecontratto
   */
  public String getLuogoregistrazionecontratto() {
    return luogoregistrazionecontratto;
  }
  
  /**
   * @param luogoregistrazionecontratto the luogoregistrazionecontratto to set
   */
  public void setLuogoregistrazionecontratto(String luogoregistrazionecontratto) {
    this.luogoregistrazionecontratto = luogoregistrazionecontratto;
  }
  
  /**
   * @return the nregistrazionecontratto
   */
  public String getNregistrazionecontratto() {
    return nregistrazionecontratto;
  }
  
  /**
   * @param nregistrazionecontratto the nregistrazionecontratto to set
   */
  public void setNregistrazionecontratto(String nregistrazionecontratto) {
    this.nregistrazionecontratto = nregistrazionecontratto;
  }
  
  /**
   * @return the dtregistrazionecontratto
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtregistrazionecontratto() {
    return dtregistrazionecontratto;
  }
  
  /**
   * @param dtregistrazionecontratto the dtregistrazionecontratto to set
   */
  public void setDtregistrazionecontratto(Date dtregistrazionecontratto) {
    this.dtregistrazionecontratto = dtregistrazionecontratto;
  }
  
  /**
   * @return the impaggiudicazione
   */
  public BigDecimal getImpaggiudicazione() {
    return impaggiudicazione;
  }
  
  /**
   * @param impaggiudicazione the impaggiudicazione to set
   */
  public void setImpaggiudicazione(BigDecimal impaggiudicazione) {
    this.impaggiudicazione = impaggiudicazione;
  }
  
  /**
   * @return the riduzionegaranziaperiso
   */
  public String getRiduzionegaranziaperiso() {
    return riduzionegaranziaperiso;
  }
  
  /**
   * @param riduzionegaranziaperiso the riduzionegaranziaperiso to set
   */
  public void setRiduzionegaranziaperiso(String riduzionegaranziaperiso) {
    this.riduzionegaranziaperiso = riduzionegaranziaperiso;
  }
  
  /**
   * @return the impgaranzia
   */
  public BigDecimal getImpgaranzia() {
    return impgaranzia;
  }
  
  /**
   * @param impgaranzia the impgaranzia to set
   */
  public void setImpgaranzia(BigDecimal impgaranzia) {
    this.impgaranzia = impgaranzia;
  }
  
  /**
   * @return the npolizzagaranziadef
   */
  public String getNpolizzagaranziadef() {
    return npolizzagaranziadef;
  }
  
  /**
   * @param npolizzagaranziadef the npolizzagaranziadef to set
   */
  public void setNpolizzagaranziadef(String npolizzagaranziadef) {
    this.npolizzagaranziadef = npolizzagaranziadef;
  }
  
  /**
   * @return the dtpolizzagaranziadef
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtpolizzagaranziadef() {
    return dtpolizzagaranziadef;
  }
  
  /**
   * @param dtpolizzagaranziadef the dtpolizzagaranziadef to set
   */
  public void setDtpolizzagaranziadef(Date dtpolizzagaranziadef) {
    this.dtpolizzagaranziadef = dtpolizzagaranziadef;
  }
  
  /**
   * @return the istitutopolizzagaranziadef
   */
  public String getIstitutopolizzagaranziadef() {
    return istitutopolizzagaranziadef;
  }
  
  /**
   * @param istitutopolizzagaranziadef the istitutopolizzagaranziadef to set
   */
  public void setIstitutopolizzagaranziadef(String istitutopolizzagaranziadef) {
    this.istitutopolizzagaranziadef = istitutopolizzagaranziadef;
  }
  
  /**
   * @return the dtscadenzapolizzagaranziadef
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtscadenzapolizzagaranziadef() {
    return dtscadenzapolizzagaranziadef;
  }
  
  /**
   * @param dtscadenzapolizzagaranziadef the dtscadenzapolizzagaranziadef to set
   */
  public void setDtscadenzapolizzagaranziadef(Date dtscadenzapolizzagaranziadef) {
    this.dtscadenzapolizzagaranziadef = dtscadenzapolizzagaranziadef;
  }
  
  /**
   * @return the dtconsegna
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtconsegna() {
    return dtconsegna;
  }
  
  /**
   * @param dtconsegna the dtconsegna to set
   */
  public void setDtconsegna(Date dtconsegna) {
    this.dtconsegna = dtconsegna;
  }
  
  /**
   * @return the ncontocorrente
   */
  public String getNcontocorrente() {
    return ncontocorrente;
  }
  
  /**
   * @param ncontocorrente the ncontocorrente to set
   */
  public void setNcontocorrente(String ncontocorrente) {
    this.ncontocorrente = ncontocorrente;
  }
  
  /**
   * @return the biccontocorrente
   */
  public String getBiccontocorrente() {
    return biccontocorrente;
  }
  
  /**
   * @param biccontocorrente the biccontocorrente to set
   */
  public void setBiccontocorrente(String biccontocorrente) {
    this.biccontocorrente = biccontocorrente;
  }
  
  /**
   * @return the bancacontocorrente
   */
  public String getBancacontocorrente() {
    return bancacontocorrente;
  }
  
  /**
   * @param bancacontocorrente the bancacontocorrente to set
   */
  public void setBancacontocorrente(String bancacontocorrente) {
    this.bancacontocorrente = bancacontocorrente;
  }
  
  /**
   * @return the impbasegara
   */
  public BigDecimal getImpbasegara() {
    return impbasegara;
  }
  
  /**
   * @param impbasegara the impbasegara to set
   */
  public void setImpbasegara(BigDecimal impbasegara) {
    this.impbasegara = impbasegara;
  }
  
  /**
   * @return the imponerisicurezza
   */
  public BigDecimal getImponerisicurezza() {
    return imponerisicurezza;
  }
  
  /**
   * @param imponerisicurezza the imponerisicurezza to set
   */
  public void setImponerisicurezza(BigDecimal imponerisicurezza) {
    this.imponerisicurezza = imponerisicurezza;
  }
  
  /**
   * @return the imponerisicurezzaamisura
   */
  public BigDecimal getImponerisicurezzaamisura() {
    return imponerisicurezzaamisura;
  }
  
  /**
   * @param imponerisicurezzaamisura the imponerisicurezzaamisura to set
   */
  public void setImponerisicurezzaamisura(BigDecimal imponerisicurezzaamisura) {
    this.imponerisicurezzaamisura = imponerisicurezzaamisura;
  }
  
  /**
   * @return the imponerisicurezzaacorpo
   */
  public BigDecimal getImponerisicurezzaacorpo() {
    return imponerisicurezzaacorpo;
  }
  
  /**
   * @param imponerisicurezzaacorpo the imponerisicurezzaacorpo to set
   */
  public void setImponerisicurezzaacorpo(BigDecimal imponerisicurezzaacorpo) {
    this.imponerisicurezzaacorpo = imponerisicurezzaacorpo;
  }
  
  /**
   * @return the impbasegaraopereacorpo
   */
  public BigDecimal getImpbasegaraopereacorpo() {
    return impbasegaraopereacorpo;
  }
  
  /**
   * @param impbasegaraopereacorpo the impbasegaraopereacorpo to set
   */
  public void setImpbasegaraopereacorpo(BigDecimal impbasegaraopereacorpo) {
    this.impbasegaraopereacorpo = impbasegaraopereacorpo;
  }
  
  /**
   * @return the impbasegaraopereamisura
   */
  public BigDecimal getImpbasegaraopereamisura() {
    return impbasegaraopereamisura;
  }
  
  /**
   * @param impbasegaraopereamisura the impbasegaraopereamisura to set
   */
  public void setImpbasegaraopereamisura(BigDecimal impbasegaraopereamisura) {
    this.impbasegaraopereamisura = impbasegaraopereamisura;
  }
  
  /**
   * @return the impnonsoggettoribasso
   */
  public BigDecimal getImpnonsoggettoribasso() {
    return impnonsoggettoribasso;
  }
  
  /**
   * @param impnonsoggettoribasso the impnonsoggettoribasso to set
   */
  public void setImpnonsoggettoribasso(BigDecimal impnonsoggettoribasso) {
    this.impnonsoggettoribasso = impnonsoggettoribasso;
  }
  
  /**
   * @return the impnonsoggettoribassoamisura
   */
  public BigDecimal getImpnonsoggettoribassoamisura() {
    return impnonsoggettoribassoamisura;
  }
  
  /**
   * @param impnonsoggettoribassoamisura the impnonsoggettoribassoamisura to set
   */
  public void setImpnonsoggettoribassoamisura(BigDecimal impnonsoggettoribassoamisura) {
    this.impnonsoggettoribassoamisura = impnonsoggettoribassoamisura;
  }
  
  /**
   * @return the impnonsoggettoribassoacorpo
   */
  public BigDecimal getImpnonsoggettoribassoacorpo() {
    return impnonsoggettoribassoacorpo;
  }
  
  /**
   * @param impnonsoggettoribassoacorpo the impnonsoggettoribassoacorpo to set
   */
  public void setImpnonsoggettoribassoacorpo(BigDecimal impnonsoggettoribassoacorpo) {
    this.impnonsoggettoribassoacorpo = impnonsoggettoribassoacorpo;
  }
  
  /**
   * @return the imponeriprogettazione
   */
  public BigDecimal getImponeriprogettazione() {
    return imponeriprogettazione;
  }
  
  /**
   * @param imponeriprogettazione the imponeriprogettazione to set
   */
  public void setImponeriprogettazione(BigDecimal imponeriprogettazione) {
    this.imponeriprogettazione = imponeriprogettazione;
  }
  
  /**
   * @return the oneriprogettazionesoggribasso
   */
  public String getOneriprogettazionesoggribasso() {
    return oneriprogettazionesoggribasso;
  }
  
  /**
   * @param oneriprogettazionesoggribasso the oneriprogettazionesoggribasso to set
   */
  public void setOneriprogettazionesoggribasso(String oneriprogettazionesoggribasso) {
    this.oneriprogettazionesoggribasso = oneriprogettazionesoggribasso;
  }
  
  /**
   * @return the cpvprincipale
   */
  public String getCpvprincipale() {
    return cpvprincipale;
  }
  
  /**
   * @param cpvprincipale the cpvprincipale to set
   */
  public void setCpvprincipale(String cpvprincipale) {
    this.cpvprincipale = cpvprincipale;
  }
  
  /**
   * @return the oggetto
   */
  public String getOggetto() {
    return oggetto;
  }
  
  /**
   * @param oggetto the oggetto to set
   */
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  /**
   * @return the ubicazionedettaglio
   */
  public String getUbicazionedettaglio() {
    return ubicazionedettaglio;
  }
  
  /**
   * @param ubicazionedettaglio the ubicazionedettaglio to set
   */
  public void setUbicazionedettaglio(String ubicazionedettaglio) {
    this.ubicazionedettaglio = ubicazionedettaglio;
  }
  
  /**
   * @return the ubicazione
   */
  public String getUbicazione() {
    return ubicazione;
  }
  
  /**
   * @param ubicazione the ubicazione to set
   */
  public void setUbicazione(String ubicazione) {
    this.ubicazione = ubicazione;
  }
  
  /**
   * @return the provincia
   */
  public String getProvincia() {
    return provincia;
  }
  
  /**
   * @param provincia the provincia to set
   */
  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }
  
  /**
   * @return the comune
   */
  public String getComune() {
    return comune;
  }
  
  /**
   * @param comune the comune to set
   */
  public void setComune(String comune) {
    this.comune = comune;
  }
  
  /**
   * @return the codistatcomune
   */
  public String getCodistatcomune() {
    return codistatcomune;
  }
  
  /**
   * @param codistatcomune the codistatcomune to set
   */
  public void setCodistatcomune(String codistatcomune) {
    this.codistatcomune = codistatcomune;
  }
  
  /**
   * @return the cup
   */
  public String getCup() {
    return cup;
  }
  
  /**
   * @param cup the cup to set
   */
  public void setCup(String cup) {
    this.cup = cup;
  }
  
  /**
   * @return the cui
   */
  public String getCui() {
    return cui;
  }
  
  /**
   * @param cui the cui to set
   */
  public void setCui(String cui) {
    this.cui = cui;
  }
  
  /**
   * @return the tpattoacontrarre
   */
  public Integer getTpattoacontrarre() {
    return tpattoacontrarre;
  }
  
  /**
   * @param tpattoacontrarre the tpattoacontrarre to set
   */
  public void setTpattoacontrarre(Integer tpattoacontrarre) {
    this.tpattoacontrarre = tpattoacontrarre;
  }
  
  /**
   * @return the nattoacontrarre
   */
  public String getNattoacontrarre() {
    return nattoacontrarre;
  }
  
  /**
   * @param nattoacontrarre the nattoacontrarre to set
   */
  public void setNattoacontrarre(String nattoacontrarre) {
    this.nattoacontrarre = nattoacontrarre;
  }
  
  /**
   * @return the dtattoacontrarre
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDtattoacontrarre() {
    return dtattoacontrarre;
  }
  
  /**
   * @param dtattoacontrarre the dtattoacontrarre to set
   */
  public void setDtattoacontrarre(Date dtattoacontrarre) {
    this.dtattoacontrarre = dtattoacontrarre;
  }
  
  /**
   * @return the sommeurgenze
   */
  public String getSommeurgenze() {
    return sommeurgenze;
  }
  
  /**
   * @param sommeurgenze the sommeurgenze to set
   */
  public void setSommeurgenze(String sommeurgenze) {
    this.sommeurgenze = sommeurgenze;
  }
  
  /**
   * @return the uffint
   */
  public String getUffint() {
    return uffint;
  }
  
  /**
   * @param uffint the uffint to set
   */
  public void setUffint(String uffint) {
    this.uffint = uffint;
  }

  /**
   * @return the aggiudicataria
   */
  public OperatoreEconomicoDto getAggiudicataria() {
    return aggiudicataria;
  }

  /**
   * @param aggiudicataria the aggiudicataria to set
   */
  public void setAggiudicataria(OperatoreEconomicoDto aggiudicataria) {
    this.aggiudicataria = aggiudicataria;
  }
}
