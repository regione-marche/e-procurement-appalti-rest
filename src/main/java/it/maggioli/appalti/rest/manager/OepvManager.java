package it.maggioli.appalti.rest.manager;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eldasoft.utils.sign.DigitalSignatureChecker;
import it.maggioli.appalti.rest.dto.OepvCommissarioDto;
import it.maggioli.appalti.rest.dto.OepvConfermaDatiDto;
import it.maggioli.appalti.rest.dto.OepvCriterioDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvCriterioListaDto;
import it.maggioli.appalti.rest.dto.OepvCriterioPartecipanteCoefficienteDto;
import it.maggioli.appalti.rest.dto.OepvCriterioPartecipanteCoppieValoreDto;
import it.maggioli.appalti.rest.dto.OepvCriterioPartecipanteDto;
import it.maggioli.appalti.rest.dto.OepvCriterioTabellareDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoLottoDownloadDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoPartecipanteDto;
import it.maggioli.appalti.rest.dto.OepvExportEsitoDto;
import it.maggioli.appalti.rest.dto.OepvGarPesiDto;
import it.maggioli.appalti.rest.dto.OepvInserisciCoefficientiEsitoDto;
import it.maggioli.appalti.rest.dto.OepvLottoDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteListaDto;
import it.maggioli.appalti.rest.dto.Tuple;
import it.maggioli.appalti.rest.dto.appalti.CgResponse;
import it.maggioli.appalti.rest.dto.appalti.Coefficienti;
import it.maggioli.appalti.rest.dto.appalti.PunteggiMassimi;
import it.maggioli.appalti.rest.dto.appalti.PunteggiTecniciImprese;
import it.maggioli.appalti.rest.entities.G1cridef;
import it.maggioli.appalti.rest.entities.G1crival;
import it.maggioli.appalti.rest.entities.G1crivalCg;
import it.maggioli.appalti.rest.entities.G1crivalcom;
import it.maggioli.appalti.rest.entities.G1crivalcomCg;
import it.maggioli.appalti.rest.entities.GareOepv;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.exceptions.OepvException;
import it.maggioli.appalti.rest.manager.appalti.AppaltiRestClientManager;
import it.maggioli.appalti.rest.repositories.G1crivalCgRepository;
import it.maggioli.appalti.rest.repositories.G1crivalRepository;
import it.maggioli.appalti.rest.repositories.G1crivalcomCgRepository;
import it.maggioli.appalti.rest.repositories.G1crivalcomRepository;
import it.maggioli.appalti.rest.repositories.OepvRepository;

/**
 * Servizio per la gestione delle richieste per il programma OEPV
 * 
 * @author marco.pravato
 *
 */
@Service
public class OepvManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(OepvManager.class);

	private static final String DOCUMENTO_MARCATO = "tsd";
	private static final String DOCUMENTO_FIRMATO = "p7m";

	@Autowired
	private OepvRepository oepvRepository;
	@Autowired
	private G1crivalRepository crivalRepository;
	@Autowired
	private G1crivalcomRepository crivalcomRepository;
	@Autowired
	private G1crivalCgRepository crivalCgRepository;
	@Autowired
	private G1crivalcomCgRepository crivalcomCgRepository;

	@Autowired
	private AppaltiRestClientManager appaltiRestClientManager;

	@Autowired
	private WgenChiaviManager wcManager;

	@Autowired
	private WlogEventiManager wleManager;

	public Optional<GareOepv> getGaraById(String ngara) {
		GareOepv res = oepvRepository.findGaraById(ngara);
		return Optional.ofNullable(res);
	}

	public Optional<OepvLottoDettaglioDto> getDettaglioLotto(String cfein, String cftec, String ngara) {
		OepvLottoDettaglioDto res = oepvRepository.findDettaglioLottoOepv(cfein, cftec, ngara);
		return Optional.ofNullable(res);
	}

	@Transactional
	public Optional<List<OepvDocumentoDto>> getDocumentiLotto(String codiceGara, String codiceLotto) {
//		List<OepvDocumentoDto> docs = oepvRepository.findDocumentiGaraOepvAsStream(codiceGara, codiceLotto);
//		if(docs.size()==0) {
//			return Optional.of(docs);
//		}
		
		return Optional.of(oepvRepository.findDocumentiGaraOepvAsStream(codiceGara, codiceLotto).map(e->{
			if(e.getNomefile() != null && e.getNomefile().contains(".")) {
				String[] splitName = StringUtils.split(e.getNomefile(), ".");
				if(splitName.length>0)
					e.setTipoFile(splitName[splitName.length-1]); //TODO da riverificare con l'estrazione del file firmato
			}
			return e;
			}).collect(Collectors.toList()));
	}

	public Optional<OepvDocumentoLottoDownloadDto> getDocumentoLottoDownload(Long iddocdig) {
		OepvDocumentoLottoDownloadDto res = oepvRepository.findDocumentoLottoDownloadOepv(iddocdig);
		// If signed digitally, unwrap the gile
		Tuple<String,byte[]> resultDoc = estraiContenutoFile(res.getDigogg(), res.getDignomdoc());
		res.setDigogg(resultDoc._2());
		res.setDignomdoc(resultDoc._1());
		return Optional.ofNullable(res);
	}

	public Optional<List<OepvPartecipanteListaDto>> getPartecipantiGara(String ngara) {
		List<OepvPartecipanteListaDto> res = oepvRepository.findPartecipantiOepv(ngara);
		return Optional.of(res);
	}

	public Optional<OepvPartecipanteDettaglioDto> getDettaglioPartecipante(String codiceGara, String ngara, String codiceImpresa) {
		OepvPartecipanteDettaglioDto res = oepvRepository.findDettaglioPartecipanteOepv(codiceGara, ngara, codiceImpresa);
		return Optional.ofNullable(res);
	}

	public Optional<List<OepvDocumentoPartecipanteDto>> getDocumentiPartecipanteGara(String codiceGara, String ngara, String codiceImpresa) {
		//List<OepvDocumentoPartecipanteDto> res = oepvRepository.findDocumentiPartecipanteOepv(codiceGara, ngara, codiceImpresa);
		return Optional.of(oepvRepository.findDocumentiPartecipanteOepv(codiceGara, ngara, codiceImpresa).stream().map(e->{
			if(e.getDignomdoc() != null && e.getDignomdoc().contains(".")) {
				String[] splitName = StringUtils.split(e.getDignomdoc(), ".");
				if(splitName.length>0)
					e.setTipoFile(splitName[splitName.length-1]); //TODO da riverificare con l'estrazione del file firmato
			}
			return e;
			}).collect(Collectors.toList()));
//		return Optional.of(res);
	}

	public Optional<OepvDocumentoLottoDownloadDto> getDocumentoPartecipanteDownload(Long iddocdig, String idprg) {
		OepvDocumentoLottoDownloadDto res = oepvRepository.findDocumentoPartecipanteDownloadOepv(iddocdig, idprg);
		// If signed digitally, unwrap the gile
		Tuple<String,byte[]> resultDoc = estraiContenutoFile(res.getDigogg(), res.getDignomdoc());
		res.setDigogg(resultDoc._2());
		res.setDignomdoc(resultDoc._1());
		return Optional.ofNullable(res);
	}

	public Optional<List<OepvCriterioListaDto>> getCriteriGara(String ngara) {
		List<OepvCriterioListaDto> res = oepvRepository.findCriteriGaraOepv(ngara);
		return Optional.of(res);
	}

	public Optional<OepvCriterioDettaglioDto> getDettaglioCriterioGara(String ngara, Long necvan) {
		OepvCriterioDettaglioDto res = oepvRepository.findDettaglioCriteroGaraOepv(ngara, necvan);
		if (res != null) {
			if (res.getIdPadre() == null || res.getIdPadre().longValue() == res.getId()) {
				res.setPadre(true);
			}
		}
		return Optional.ofNullable(res);
	}

	public Optional<List<OepvGarPesiDto>> getCoefficienti(String codiceGara) {
		List<OepvGarPesiDto> res = oepvRepository.findCoefficientiOepv(codiceGara);
		return Optional.of(res);
	}

	public Optional<List<OepvCriterioTabellareDto>> getCriterioTabellareOepv() {
		List<OepvCriterioTabellareDto> res = oepvRepository.findCriterioTabellareOepv();
		return Optional.of(res);
	}

	public Optional<Long> getDiffCountCommissariGara(String codiceGara) {
		Long res = oepvRepository.findDiffCountCommissariGara(codiceGara);
		return Optional.of(res);
	}

	@Transactional
	public OepvInserisciCoefficientiEsitoDto inserisciCoefficienti(OepvConfermaDatiDto datiConferma, Long syscon, String sourceIP) throws Exception {

		OepvInserisciCoefficientiEsitoDto result = new OepvInserisciCoefficientiEsitoDto();

		try {
			List<OepvCriterioPartecipanteDto> criteriPartecipanti = datiConferma.getCriteriPartecipanti();
			if (criteriPartecipanti.size() > 0) {
				String ngara = datiConferma.getNgara();
				String codiceGara = datiConferma.getCodiceGara();

				// Load existing crival/crivalcom records
				List<G1crival> crivalItems = crivalRepository.findByNgara(ngara);
				List<G1crivalcom> crivalcomItems = crivalcomRepository.findByNgara(ngara);
				Hashtable<String, Long> cacheCriterioDefIds = new Hashtable<String, Long>();

				for (OepvCriterioPartecipanteDto criterioPartecipante : criteriPartecipanti) {

					// Try to find existing record
					G1crival criVal = crivalItems.stream().filter(p -> //
					p.getNgara().equals(criterioPartecipante.getNgara()) && //
							p.getDittao().equals(criterioPartecipante.getDittao()) && //
							p.getNecvan().equals(new BigDecimal(criterioPartecipante.getNecvan()))).findFirst().orElse(null);
					if (criVal == null) {
						// If not found, create new item
						criVal = new G1crival();
						Long id = wcManager.getNextId("G1CRIVAL");
						criVal.setId(id);
						criVal.setNgara(criterioPartecipante.getNgara());
						criVal.setDittao(criterioPartecipante.getDittao());
						criVal.setNecvan(new BigDecimal(criterioPartecipante.getNecvan()));

						// Use cache for performances, the same gara/necvan will be called multiple times for each partecipante
						String cacheKey = criterioPartecipante.getNgara() + "_" + criterioPartecipante.getNecvan();
						if (!cacheCriterioDefIds.contains(criterioPartecipante.getNecvan())) {
							// Find and cache G1cridef record
							G1cridef def = oepvRepository.findCriterioDefByCriterioOepv(criterioPartecipante.getNgara(), new BigDecimal(criterioPartecipante.getNecvan()));
							if (def == null)
								throw new OepvException("Definizione criterio non trovata: " + criterioPartecipante.getNecvan());
							cacheCriterioDefIds.put(cacheKey, def.getId());
						}
						criVal.setIdcridef(new BigDecimal(cacheCriterioDefIds.get(cacheKey)));
					} else {
						// Sbianca campi che devono essere ricalcolati bel backoffice
						criVal.setPunteg(null);
						criVal.setCoeffi(null);
					}

					// Insert/Update record in the database
					crivalRepository.save(criVal);

					// Process coefficienti
					for (OepvCriterioPartecipanteCoefficienteDto criterioCoefficiente : criterioPartecipante.getCoefficienti()) {

						// Find ID from GFOF using user CF (CF is encrypted, so I have to find them all and then loop to find the correct one)
						List<OepvCommissarioDto> gfofs = getCommissariGara(criterioPartecipante.getNgara(), codiceGara);
						Long idGfof = null;
						for (OepvCommissarioDto gfof : gfofs) {
							if (gfof.getCfein() != null && gfof.getCfein().length() > 0 && toSha256(gfof.getCfein()).equals(criterioCoefficiente.getCfein())) {
								idGfof = gfof.getId();
								break;
							}
						}

						if (idGfof == null)
							throw new OepvException("Utente commissario non trovato: " + criterioCoefficiente.getCfein());

						// Try to find existing record
						final BigDecimal findIdcrival = new BigDecimal(criVal.getId());
						final BigDecimal findIdcridef = criVal.getIdcridef();
						final BigDecimal findIdgfof = new BigDecimal(idGfof);
						G1crivalcom criValCom = crivalcomItems.stream().filter(p -> //
						p.getIdcrival().equals(findIdcrival) && //
								p.getIdcridef().equals(findIdcridef) && //
								p.getIdgfof().equals(findIdgfof)).findFirst().orElse(null);

						if (criValCom == null) {
							// If not found, create new item
							criValCom = new G1crivalcom();
							Long idCom = wcManager.getNextId("G1CRIVALCOM");
							criValCom.setId(idCom);
							criValCom.setIdcrival(findIdcrival);
							criValCom.setIdcridef(findIdcridef);
							criValCom.setIdgfof(findIdgfof);
						}

						// Set values
						criValCom.setCoeffi(criterioCoefficiente.getCoeffi());
						criValCom.setNote(criterioCoefficiente.getNote());

						// Insert or update record in the database
						crivalcomRepository.save(criValCom);
					}
				}

				// Update stato confermato in tabella GARE1
				oepvRepository.updateGare1SetStatoConfermato(ngara);

				// Insert wLogEventi
				Wlogeventi evento = new Wlogeventi();
				evento.setCod_profilo(null);
				evento.setCodapp("CG");
				evento.setCodevento(WlogEventiManager.COD_EVENTO_CG_CONFERMA_VALUTAZIONE);
				evento.setDescr("Inserita conferma valutazioni da app cg per la gara " + ngara);
				evento.setLivevento(1);
				evento.setOggevento(ngara);
				evento.setSyscon(syscon);
				evento.setIpevento(sourceIP);
				evento.setErrmsg("");
				wleManager.saveWlogEventi(evento);
			}

			result.setEsito(true);
		} catch (OepvException e) {
			result.setErrorData(e.getMessage());
			result.setEsito(false);
		}

		return result;
	}

	@Transactional
	public OepvInserisciCoefficientiEsitoDto inserisciCoefficientiCgTables(OepvConfermaDatiDto datiConferma, Long syscon, String sourceIP) throws Exception {

		OepvInserisciCoefficientiEsitoDto result = new OepvInserisciCoefficientiEsitoDto();

		try {
			List<OepvCriterioPartecipanteDto> criteriPartecipanti = datiConferma.getCriteriPartecipanti();
			if (criteriPartecipanti.size() > 0) {

				// Delete all data by NGARA before inserting the new data
				String ngara = datiConferma.getNgara();
				String codiceGara = datiConferma.getCodiceGara();

				crivalcomCgRepository.deleteByNgara(ngara);
				crivalCgRepository.deleteByNgara(ngara);

				Hashtable<String, Long> cacheCriterioDefIds = new Hashtable<String, Long>();

				for (OepvCriterioPartecipanteDto criterioPartecipante : criteriPartecipanti) {
					G1crivalCg criVal = new G1crivalCg();

					Long id = wcManager.getNextId("G1CRIVAL_CG");
					criVal.setId(id);
					criVal.setNgara(criterioPartecipante.getNgara());
					criVal.setDittao(criterioPartecipante.getDittao());
					criVal.setNecvan(new BigDecimal(criterioPartecipante.getNecvan()));

					// Use cache for performances, the same gara/necvan will be called multiple times for each partecipante
					String cacheKey = criterioPartecipante.getNgara() + "_" + criterioPartecipante.getNecvan();
					if (!cacheCriterioDefIds.contains(criterioPartecipante.getNecvan())) {
						// Find and cache G1cridef record
						G1cridef def = oepvRepository.findCriterioDefByCriterioOepv(criterioPartecipante.getNgara(), new BigDecimal(criterioPartecipante.getNecvan()));
						if (def == null)
							throw new OepvException("Definizione criterio non trovata: " + criterioPartecipante.getNecvan());
						cacheCriterioDefIds.put(cacheKey, def.getId());
					}
					criVal.setIdcridef(new BigDecimal(cacheCriterioDefIds.get(cacheKey)));

					// Store record in the database
					crivalCgRepository.save(criVal);

					// Process coefficienti
					for (OepvCriterioPartecipanteCoefficienteDto criterioCoefficiente : criterioPartecipante.getCoefficienti()) {
						G1crivalcomCg criValCom = new G1crivalcomCg();
						Long idCom = wcManager.getNextId("G1CRIVALCOM_CG");
						criValCom.setId(idCom);
						criValCom.setIdcrival(new BigDecimal(criVal.getId()));
						criValCom.setIdcridef(criVal.getIdcridef());

						// Find ID from GFOF using user CF (CF is encrypted, so I have to find them all and then loop to find the correct one)
						List<OepvCommissarioDto> gfofs = getCommissariGara(criterioPartecipante.getNgara(), codiceGara);
						Long idGfof = null;
						for (OepvCommissarioDto gfof : gfofs) {
							if (gfof.getCfein() != null && gfof.getCfein().length() > 0 && toSha256(gfof.getCfein()).equals(criterioCoefficiente.getCfein())) {
								idGfof = gfof.getId();
								break;
							}
						}

						if (idGfof == null)
							throw new OepvException("Utente commissario non trovato: " + criterioCoefficiente.getCfein());
						criValCom.setIdgfof(new BigDecimal(idGfof));

						// Set values
						criValCom.setCoeffi(criterioCoefficiente.getCoeffi());
						criValCom.setNote(criterioCoefficiente.getNote());

						// Store record in the database
						crivalcomCgRepository.save(criValCom);
					}
				}
			}

			result.setEsito(true);
		} catch (OepvException e) {
			result.setErrorData(e.getMessage());
			result.setEsito(false);
		}

		return result;
	}

	public OepvExportEsitoDto exportExcel(OepvConfermaDatiDto datiExport, String authorization, Long syscon, String sourceIP) throws Exception {
		OepvExportEsitoDto response = new OepvExportEsitoDto();

		try {
			// Calcolo coefficienti e insert dati in tabelle temporanee
			OepvInserisciCoefficientiEsitoDto insertResult = inserisciCoefficientiCgTables(datiExport, syscon, sourceIP);
			if (insertResult.isEsito()) {
				// Invocazione API appalti che effettua i calcoli basati sui dati appena caricati nelle tabelle temporanee
				CgResponse calcoliResponse = appaltiRestClientManager.calcoli(datiExport.getNgara(), authorization);
				if (calcoliResponse == null)
					throw new OepvException("Errore in richiamo API calcoli di appalti");

				// Caricamento di tutti i dati necessari per produrre il file Excel
				Hashtable<String, String> hashPartecipanti = new Hashtable<String, String>(); // NOTA: Questa has contiene lettera (A, B, C) per ogni partecipante - Non viene piu'
																								// usata ma la tengo in caso venga ripristinata un giorno
				List<OepvPartecipanteListaDto> partecipanti = getPartecipantiGara(datiExport.getNgara()).get();
				List<OepvCommissarioDto> commissari = getCommissariGara(datiExport.getNgara(), datiExport.getCodiceGara());
				List<OepvCriterioListaDto> criteri = getCriteriGara(datiExport.getNgara()).get();
				List<OepvGarPesiDto> garPesi = getCoefficienti(datiExport.getCodiceGara()).get();
				GareOepv gara = oepvRepository.findGaraById(datiExport.getNgara());

				// Create workbook
				Workbook wb = new XSSFWorkbook();
				exportExcelSheetAnagrafica(wb, datiExport, hashPartecipanti, partecipanti, commissari);
				exportExcelSheetConfronti(wb, datiExport, hashPartecipanti, partecipanti, commissari, criteri, garPesi);
				exportExcelSheetRiepilogo(wb, datiExport, hashPartecipanti, partecipanti, commissari, criteri, garPesi, gara, calcoliResponse);

				// Return the Excel file as Base64 string
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				try {
					wb.write(bos);
				} finally {
					bos.close();
				}
				byte[] encodedFile = Base64.getEncoder().encode(bos.toByteArray());
				response.setData(new String(encodedFile, StandardCharsets.UTF_8));
				response.setEsito(true);
			} else {
				response.setErrorData(insertResult.getErrorData());
				response.setEsito(false);
			}
		} catch (OepvException e) {
			response.setEsito(false);
			response.setErrorData(e.getMessage());
		} catch (Exception e) {
			logger.error("Errore in export file Excel", e);
			response.setEsito(false);
			response.setErrorData("Errore generico in generazione file Excel");
		}

		return response;
	}

	private void exportExcelSheetAnagrafica(Workbook wb, OepvConfermaDatiDto datiExport, Hashtable<String, String> hashPartecipanti, List<OepvPartecipanteListaDto> partecipanti,
			List<OepvCommissarioDto> commissari) {
		// SHEET 1 - ANAGRAFICA
		Sheet shAnagrafica = wb.createSheet("Anagrafica");
		int rowIdx = 0;

		Row row = shAnagrafica.createRow(rowIdx++);

		// Part 1 - Title
		Cell cell = row.createCell(0);
		cell.setCellValue("Concorrenti");

		Font fnt1 = wb.createFont();
		fnt1.setBold(true);
		fnt1.setFontHeightInPoints((short) 16);

		CellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setFont(fnt1);
		cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle1.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		cell.setCellStyle(cellStyle1);

		shAnagrafica.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));

		// Part 2 - Lista imprese partecipanti ordinata per nome
		for (int i = 0; i < partecipanti.size(); i++) {
			OepvPartecipanteListaDto partecipante = partecipanti.get(i);
			String letteraPartecipante = getCharForNumber(i);

			// Store lettera partecipante for later use
			hashPartecipanti.put(partecipante.getCodiceImpresa(), letteraPartecipante);

			Row rowPartecipante = shAnagrafica.createRow(rowIdx++);

			// CELL A - Lettera partecipante
			Font fntPartecipante = wb.createFont();
			fntPartecipante.setBold(true);
			CellStyle cellStylePartecipante1 = wb.createCellStyle();
			cellStylePartecipante1.setFont(fntPartecipante);
			cellStylePartecipante1.setBorderBottom(BorderStyle.THIN);
			cellStylePartecipante1.setBorderTop(BorderStyle.THIN);
			cellStylePartecipante1.setBorderLeft(BorderStyle.THIN);
			cellStylePartecipante1.setBorderRight(BorderStyle.THIN);

			Cell cellPartecipante1 = rowPartecipante.createCell(0);
			cellPartecipante1.setCellValue(letteraPartecipante);
			cellPartecipante1.setCellStyle(cellStylePartecipante1);

			// CELL B - Ragione sociale
			CellStyle cellStylePartecipante2 = wb.createCellStyle();
			cellStylePartecipante2.setFont(fntPartecipante);
			cellStylePartecipante2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStylePartecipante2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			cellStylePartecipante2.setBorderBottom(BorderStyle.THIN);
			cellStylePartecipante2.setBorderTop(BorderStyle.THIN);
			cellStylePartecipante2.setBorderLeft(BorderStyle.THIN);
			cellStylePartecipante2.setBorderRight(BorderStyle.THIN);

			Cell cellPartecipante2 = rowPartecipante.createCell(1);
			cellPartecipante2.setCellValue(partecipante.getRagioneSociale());
			cellPartecipante2.setCellStyle(cellStylePartecipante2);
		}

		// Part 3 - Elenco commissari
		rowIdx++;
		for (OepvCommissarioDto commissario : commissari) {
			Row rowCommissario = shAnagrafica.createRow(rowIdx++);

			// CELL A - Ruolo
			Font fntCommissario = wb.createFont();
			fntCommissario.setBold(true);
			CellStyle cellStyleCommissario1 = wb.createCellStyle();
			cellStyleCommissario1.setFont(fntCommissario);

			Cell cellCommissario1 = rowCommissario.createCell(0);
			cellCommissario1.setCellValue(commissario.getDescRuolo());
			cellCommissario1.setCellStyle(cellStyleCommissario1);

			// CELL B - Nome commissario
			Cell cellCommissario2 = rowCommissario.createCell(1);
			cellCommissario2.setCellValue(commissario.getNomfof());
			cellCommissario2.setCellStyle(cellStyleCommissario1);
		}

		shAnagrafica.autoSizeColumn(0);
		shAnagrafica.autoSizeColumn(1);
	}

	private void exportExcelSheetConfronti(Workbook wb, OepvConfermaDatiDto datiExport, Hashtable<String, String> hashPartecipanti, List<OepvPartecipanteListaDto> partecipanti,
			List<OepvCommissarioDto> commissari, List<OepvCriterioListaDto> criteri, List<OepvGarPesiDto> garPesi) {

		for (OepvCommissarioDto commissario : commissari) {
			// SHEET 2...N - Confronti
			Sheet shConfronti = wb.createSheet("Confronti " + (commissario.getNomfof() != null && commissario.getNomfof().length() > 0 ? commissario.getNomfof() : "???"));
			int maxColIdx = 2;
			int rowIdx = 0;

			Row rowNome = shConfronti.createRow(rowIdx++);

			// CELL A - Nome commissario
			Font fntCommissario = wb.createFont();
			fntCommissario.setBold(true);
			CellStyle cellStyleCommissario1 = wb.createCellStyle();
			cellStyleCommissario1.setFont(fntCommissario);

			Cell cellCommissario1 = rowNome.createCell(0);
			cellCommissario1.setCellValue(commissario.getNomfof());
			cellCommissario1.setCellStyle(cellStyleCommissario1);

			rowIdx++;

			// Ciclo criteri
			for (OepvCriterioListaDto criterio : criteri) {
				// Check if is criterio with confronto coppie
				if (partecipanti.size() >= 3 && criterio.getModpunti() != null && criterio.getModpunti().intValue() == 3) {
					boolean isPadre = false;
					for (OepvCriterioListaDto criterio2 : criteri) {
						if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
							isPadre = true;
							break;
						}
					}
					// If not criterio padre (they cannot be edited in the UI)
					if (!isPadre) {
						CellStyle cellStyleCriterio = wb.createCellStyle();
						cellStyleCriterio.setFont(fntCommissario);
						cellStyleCriterio.setBorderBottom(BorderStyle.THIN);
						cellStyleCriterio.setBorderTop(BorderStyle.THIN);
						cellStyleCriterio.setBorderLeft(BorderStyle.THIN);
						cellStyleCriterio.setBorderRight(BorderStyle.THIN);

						Row row1 = shConfronti.createRow(rowIdx++);

						// Nome criterio
						int colIdx = 0;
						Cell cellCriterio = row1.createCell(colIdx++);
						cellCriterio.setCellValue(criterio.getDescrizione());
						cellCriterio.setCellStyle(cellStyleCriterio);

						// Spazio
						Cell cellSpace = row1.createCell(colIdx++);
						cellSpace.setCellStyle(cellStyleCriterio);

						CellStyle cellStyleCriterioPartecipante = wb.createCellStyle();
						cellStyleCriterioPartecipante.cloneStyleFrom(cellStyleCriterio);
						cellStyleCriterioPartecipante.setAlignment(HorizontalAlignment.LEFT);
						cellStyleCriterioPartecipante.setWrapText(true);

						CellStyle cellStyleCriterioPartecipanteVertical = wb.createCellStyle();
						cellStyleCriterioPartecipanteVertical.cloneStyleFrom(cellStyleCriterioPartecipante);
						cellStyleCriterioPartecipanteVertical.setRotation((short) 90);

						Font fntValori = wb.createFont();
						CellStyle cellStyleValorePartecipante = wb.createCellStyle();
						cellStyleValorePartecipante.cloneStyleFrom(cellStyleCriterioPartecipante);
						cellStyleValorePartecipante.setFont(fntValori);

						CellStyle cellStyleValorePartecipanteEmpty = wb.createCellStyle();
						cellStyleValorePartecipanteEmpty.cloneStyleFrom(cellStyleValorePartecipante);
						cellStyleValorePartecipanteEmpty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
						cellStyleValorePartecipanteEmpty.setFillForegroundColor(IndexedColors.YELLOW.getIndex());

						// Colonne lettere partecipanti
						for (OepvPartecipanteListaDto partecipante : partecipanti) {
							Cell cellPartecipante = row1.createCell(colIdx++);
							cellPartecipante.setCellValue(partecipante.getRagioneSociale());
							cellPartecipante.setCellStyle(cellStyleCriterioPartecipanteVertical);
							maxColIdx = colIdx - 1;
						}

						// Set height of the row
						row1.setHeight((short) 3000);

						// Righe lettere partecipanti e valori confronto
						for (OepvPartecipanteListaDto partecipante : partecipanti) {
							Row rowPartecipante = shConfronti.createRow(rowIdx++);
							colIdx = 1;

							// Set height of the row
							rowPartecipante.setHeight((short) 600);

							Cell cellPartecipante = rowPartecipante.createCell(colIdx++);
							cellPartecipante.setCellValue(partecipante.getRagioneSociale());
							cellPartecipante.setCellStyle(cellStyleCriterioPartecipante);

							// Valori confronto coppie
							for (OepvPartecipanteListaDto partecipante2 : partecipanti) {
								String valore = "";
								if (!partecipante.getCodiceImpresa().equals(partecipante2.getCodiceImpresa())) {
									// Find valore in coppie
									List<OepvCriterioPartecipanteDto> cronfronti = datiExport.getCriteriPartecipanti();

									// Trova criterio/impresa
									for (OepvCriterioPartecipanteDto cronfronto : cronfronti) {
										if (cronfronto.getNecvan().longValue() == criterio.getId() && cronfronto.getDittao().equals(partecipante.getCodiceImpresa())) {
											// Trova coefficiente commissario
											for (OepvCriterioPartecipanteCoefficienteDto coefficiente : cronfronto.getCoefficienti()) {
												if (commissario.getCfein() != null && commissario.getCfein().length() > 0
														&& toSha256(commissario.getCfein()).equals(coefficiente.getCfein())) {
													// Cerca partecipante 2
													if (coefficiente.getCoppie() != null) {
														for (OepvCriterioPartecipanteCoppieValoreDto coppia : coefficiente.getCoppie()) {
															if (coppia.getCodiceImpresa().equals(partecipante2.getCodiceImpresa())) {
																// Trova valore in tabella GarPesi
																OepvGarPesiDto garPeso = garPesi.stream().filter(p -> p.getNumpesi().equals(coppia.getGarpesiNumpesi())).findFirst()
																		.orElse(null);
																if (garPeso != null) {
																	valore = garPeso.getDescexcel();
																	if (valore == null || valore.length() == 0) {
																		valore = garPeso.getValore();
																	}
																}
																break;
															}
														}
														break;
													}
												}
											}
											break;
										}
									}
								} else {
									// Confronto con se' stesso
									valore = "1";
								}

								// Scrivi valore in Excel
								Cell cellValore = rowPartecipante.createCell(colIdx++);
								cellValore.setCellValue(valore);
								cellValore.setCellStyle((valore != null && valore.length() > 0) ? cellStyleValorePartecipante : cellStyleValorePartecipanteEmpty);
							}
						}

					}
				}

				// Empty line between criteri
				rowIdx++;
			}

			// Size columns
			shConfronti.setColumnWidth(0, 30 * 256);
			shConfronti.setColumnWidth(1, 30 * 256);
			for (int i = 2; i <= maxColIdx; i++) {
				shConfronti.setColumnWidth(i, 6 * 256 + 80);
			}
		}
	}

	private void exportExcelSheetRiepilogo(Workbook wb, OepvConfermaDatiDto datiExport, Hashtable<String, String> hashPartecipanti, List<OepvPartecipanteListaDto> partecipanti,
			List<OepvCommissarioDto> commissari, List<OepvCriterioListaDto> criteri, List<OepvGarPesiDto> garPesi, GareOepv gara, CgResponse datiAppalti) {

		Sheet shRiepilogo = wb.createSheet("Riepilogo");

		int rowIdx = 0;
		int maxColIdx = 1;
		Row row = shRiepilogo.createRow(rowIdx++);

		Font fntBold = wb.createFont();
		fntBold.setBold(true);
		Font fntNormal = wb.createFont();
		Font fntBoldLarge = wb.createFont();
		fntBoldLarge.setBold(true);
		fntBoldLarge.setFontHeightInPoints((short) 14);

		CellStyle cellStyleBold = wb.createCellStyle();
		cellStyleBold.setFont(fntBold);
		CellStyle cellStyleNormal = wb.createCellStyle();
		cellStyleNormal.setFont(fntNormal);

		CellStyle cellStyleBoldLargeFont = wb.createCellStyle();
		cellStyleBoldLargeFont.cloneStyleFrom(cellStyleBold);
		cellStyleBoldLargeFont.setFont(fntBoldLarge);

		CellStyle cellStyleNormalBorders = wb.createCellStyle();
		cellStyleNormalBorders.cloneStyleFrom(cellStyleNormal);
		cellStyleNormalBorders.setBorderBottom(BorderStyle.THIN);
		cellStyleNormalBorders.setBorderTop(BorderStyle.THIN);
		cellStyleNormalBorders.setBorderLeft(BorderStyle.THIN);
		cellStyleNormalBorders.setBorderRight(BorderStyle.THIN);

		CellStyle cellStyleNormalBordersCenter = wb.createCellStyle();
		cellStyleNormalBordersCenter.cloneStyleFrom(cellStyleNormalBorders);
		cellStyleNormalBordersCenter.setAlignment(HorizontalAlignment.CENTER);

		CellStyle cellStyleNormalBordersEmpty = wb.createCellStyle();
		cellStyleNormalBordersEmpty.cloneStyleFrom(cellStyleNormalBorders);
		cellStyleNormalBordersEmpty.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyleNormalBordersEmpty.setFillForegroundColor(IndexedColors.YELLOW.getIndex());

		CellStyle cellStyleBoldBorders = wb.createCellStyle();
		cellStyleBoldBorders.cloneStyleFrom(cellStyleNormalBorders);
		cellStyleBoldBorders.setFont(fntBold);

		CellStyle cellStyleBoldBordersWrapText = wb.createCellStyle();
		cellStyleBoldBordersWrapText.cloneStyleFrom(cellStyleBoldBorders);
		cellStyleBoldBordersWrapText.setWrapText(true);

		// Part 1 - Title rows
		createCell(row, 0, cellStyleBold, "Codice gara");
		String codiceGara = datiExport.getCodiceGara();
		if (codiceGara != null && codiceGara.startsWith("$"))
			codiceGara = codiceGara.substring(1);
		createCell(row, 1, cellStyleNormal, codiceGara);

		row = shRiepilogo.createRow(rowIdx++);
		createCell(row, 0, cellStyleBold, "Lotto");
		createCell(row, 1, cellStyleNormal, gara.getCodiga());

		row = shRiepilogo.createRow(rowIdx++);
		createCell(row, 0, cellStyleBold, "CIG");
		createCell(row, 1, cellStyleNormal, gara.getCodcig());

		row = shRiepilogo.createRow(rowIdx++);
		createCell(row, 0, cellStyleBold, "Importo gara");
		createCell(row, 1, cellStyleNormal, gara.getImpapp());

		// Empty line
		rowIdx++;

		// Loop commissari
		for (OepvCommissarioDto commissario : commissari) {

			// Riga commissario
			Row rowCommissario = shRiepilogo.createRow(rowIdx++);
			createCell(rowCommissario, 0, cellStyleBold, commissario.getDescRuolo() + " " + commissario.getNomfof());

			// Riga criteri padre
			Row rowCriteriPadre = shRiepilogo.createRow(rowIdx++);

			// Riga criteri
			Row rowCriteri = shRiepilogo.createRow(rowIdx++);
			createCell(rowCriteri, 0, cellStyleBoldBorders, "Concorrente");

			int colIdx = 1;
			for (OepvCriterioListaDto criterio : criteri) {
				boolean isPadre = false;
				for (OepvCriterioListaDto criterio2 : criteri) {
					if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
						isPadre = true;
						break;
					}
				}
				if (!isPadre) {
					// Find padre and fill
					if (criterio.getIdPadre() != null && criterio.getIdPadre().longValue() != criterio.getId()) {
						for (OepvCriterioListaDto criterio2 : criteri) {
							if (criterio2.getId() == criterio.getIdPadre().longValue()) {
								// Found padre
								createCell(rowCriteriPadre, colIdx, cellStyleNormalBordersCenter, criterio2.getDescrizione());
								break;
							}
						}
					}

					// Fill criterio figlio
					createCell(rowCriteri, colIdx++, cellStyleBoldBorders, criterio.getDescrizione());

					maxColIdx = colIdx - 1;
				}
			}

			// Merge celle criteri padre
			mergeCellsSameValue(1, maxColIdx, shRiepilogo, rowCriteriPadre);

			// Righe partecipanti
			for (OepvPartecipanteListaDto partecipante : partecipanti) {
				colIdx = 0;
				Row rowPartecipante = shRiepilogo.createRow(rowIdx++);
				createCell(rowPartecipante, colIdx++, cellStyleBoldBordersWrapText, partecipante.getRagioneSociale());

				// Coefficienti per ciascun criterio
				for (OepvCriterioListaDto criterio : criteri) {
					boolean isPadre = false;
					for (OepvCriterioListaDto criterio2 : criteri) {
						if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
							isPadre = true;
							break;
						}
					}

					if (!isPadre) {
						// Find valore coefficiente per commissario/partecipante/criterio
						Object valore = null;
						List<OepvCriterioPartecipanteDto> cronfronti = datiExport.getCriteriPartecipanti();
						for (OepvCriterioPartecipanteDto cronfronto : cronfronti) {
							if (cronfronto.getNecvan().longValue() == criterio.getId() && cronfronto.getDittao().equals(partecipante.getCodiceImpresa())) {
								// Trova coefficiente commissario
								for (OepvCriterioPartecipanteCoefficienteDto coefficiente : cronfronto.getCoefficienti()) {
									if (commissario.getCfein() != null && commissario.getCfein().length() > 0 && toSha256(commissario.getCfein()).equals(coefficiente.getCfein())) {
										valore = coefficiente.getCoeffi();
										break;
									}
								}
								break;
							}
						}

						createCell(rowPartecipante, colIdx++, valore != null ? cellStyleNormalBorders : cellStyleNormalBordersEmpty, valore);
					}

				}
			}

			// 2 Empty rows between commissari
			rowIdx++;
			rowIdx++;
		}

		// Set double border around area
		if (rowIdx >= 8) {
			CellRangeAddress region = new CellRangeAddress(5, rowIdx - 3, 0, maxColIdx);
			RegionUtil.setBorderBottom(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderLeft(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderRight(BorderStyle.DOUBLE, region, shRiepilogo);
		}

		// Extra empty row after this section
		rowIdx++;

		// AREA DATI APPALTI - COEFFICIENTI
		int rowIdxAppaltiStart = rowIdx;
		// Riga commissario
		Row rowTitle = shRiepilogo.createRow(rowIdx++);
		createCell(rowTitle, 0, cellStyleBoldLargeFont, "Media dei coefficienti");

		// Riga criteri padre
		Row rowCriteriPadre = shRiepilogo.createRow(rowIdx++);

		// Riga criteri
		Row rowCriteri = shRiepilogo.createRow(rowIdx++);
		createCell(rowCriteri, 0, cellStyleBoldBorders, "Concorrente");

		int colIdx = 1;
		for (OepvCriterioListaDto criterio : criteri) {
			boolean isPadre = false;
			for (OepvCriterioListaDto criterio2 : criteri) {
				if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
					isPadre = true;
					break;
				}
			}
			if (!isPadre) {
				// Find padre and fill
				if (criterio.getIdPadre() != null && criterio.getIdPadre().longValue() != criterio.getId()) {
					for (OepvCriterioListaDto criterio2 : criteri) {
						if (criterio2.getId() == criterio.getIdPadre().longValue()) {
							// Found padre
							createCell(rowCriteriPadre, colIdx, cellStyleNormalBordersCenter, criterio2.getDescrizione());
							break;
						}
					}
				}

				// Fill criterio figlio
				createCell(rowCriteri, colIdx++, cellStyleBoldBorders, criterio.getDescrizione());

				maxColIdx = colIdx - 1;
			}
		}

		// Merge celle criteri padre
		mergeCellsSameValue(1, maxColIdx, shRiepilogo, rowCriteriPadre);

		// Righe partecipanti
		for (OepvPartecipanteListaDto partecipante : partecipanti) {
			colIdx = 0;
			Row rowPartecipante = shRiepilogo.createRow(rowIdx++);
			createCell(rowPartecipante, colIdx++, cellStyleBoldBordersWrapText, partecipante.getRagioneSociale());

			// Coefficienti per ciascun criterio
			for (OepvCriterioListaDto criterio : criteri) {
				boolean isPadre = false;
				for (OepvCriterioListaDto criterio2 : criteri) {
					if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
						isPadre = true;
						break;
					}
				}

				if (!isPadre) {
					// Find valore coefficiente per partecipante/criterio
					Object valore = null;

					List<Coefficienti> coefficientiAppalti = datiAppalti.getCoefficienti();
					for (Coefficienti coefficienteAppalti : coefficientiAppalti) {
						if (coefficienteAppalti.getCodimp() != null && coefficienteAppalti.getCodimp().equals(partecipante.getCodiceImpresa())
								&& coefficienteAppalti.getNecvan() != null && coefficienteAppalti.getNecvan().longValue() == criterio.getId()) {
							valore = new BigDecimal(Math.round(coefficienteAppalti.getCoefficiente() * 100000) / 100000D);
							break;
						}
					}

					createCell(rowPartecipante, colIdx++, valore != null ? cellStyleNormalBorders : cellStyleNormalBordersEmpty, valore);
				}
			}
		}

		// AREA DATI APPALTI - PUNTEGGI MASSIMI/TOTALI
		rowIdx++;
		// Riga commissario
		rowTitle = shRiepilogo.createRow(rowIdx++);
		createCell(rowTitle, 0, cellStyleBoldLargeFont, "Punteggio totale offerta tecnica");

		// Riga criteri padre
		rowCriteriPadre = shRiepilogo.createRow(rowIdx++);

		// Riga criteri
		rowCriteri = shRiepilogo.createRow(rowIdx++);

		colIdx = 1;
		for (OepvCriterioListaDto criterio : criteri) {
			boolean isPadre = false;
			for (OepvCriterioListaDto criterio2 : criteri) {
				if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
					isPadre = true;
					break;
				}
			}
			if (!isPadre) {
				// Find padre and fill
				if (criterio.getIdPadre() != null && criterio.getIdPadre().longValue() != criterio.getId()) {
					for (OepvCriterioListaDto criterio2 : criteri) {
						if (criterio2.getId() == criterio.getIdPadre().longValue()) {
							// Found padre
							createCell(rowCriteriPadre, colIdx, cellStyleNormalBordersCenter, criterio2.getDescrizione());
							break;
						}
					}
				}

				// Fill criterio figlio
				createCell(rowCriteri, colIdx++, cellStyleBoldBorders, criterio.getDescrizione());

				maxColIdx = colIdx - 1;
			}
		}

		// Merge celle criteri padre
		mergeCellsSameValue(1, maxColIdx, shRiepilogo, rowCriteriPadre);

		// Riga punteggi massimi
		Row rowPunteggiMassimi = shRiepilogo.createRow(rowIdx++);
		createCell(rowPunteggiMassimi, 0, cellStyleBoldBorders, "Punteggio massimo");

		colIdx = 1;
		for (OepvCriterioListaDto criterio : criteri) {
			boolean isPadre = false;
			for (OepvCriterioListaDto criterio2 : criteri) {
				if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
					isPadre = true;
					break;
				}
			}
			if (!isPadre) {
				// Find valore punteggio massimo per criterio
				Object valore = null;

				List<PunteggiMassimi> punteggiAppalti = datiAppalti.getPunteggiMassimi();
				for (PunteggiMassimi punteggioAppalti : punteggiAppalti) {
					if (punteggioAppalti.getNecvan() != null && punteggioAppalti.getNecvan().longValue() == criterio.getId()) {
						valore = punteggioAppalti.getPunteggioMassimo();
						break;
					}
				}

				createCell(rowPunteggiMassimi, colIdx++, valore != null ? cellStyleNormalBorders : cellStyleNormalBordersEmpty, valore);
			}
		}

		// Add empty row
		rowIdx++;

		// Riga titolo "Concorrente"
		Row rowTitleConcorrente = shRiepilogo.createRow(rowIdx++);
		createCell(rowTitleConcorrente, 0, cellStyleBoldBorders, "Concorrente");

		// Righe partecipanti
		for (OepvPartecipanteListaDto partecipante : partecipanti) {
			colIdx = 0;
			Row rowPartecipante = shRiepilogo.createRow(rowIdx++);
			createCell(rowPartecipante, colIdx++, cellStyleBoldBordersWrapText, partecipante.getRagioneSociale());

			// Coefficienti per ciascun criterio
			for (OepvCriterioListaDto criterio : criteri) {
				boolean isPadre = false;
				for (OepvCriterioListaDto criterio2 : criteri) {
					if (criterio2.getIdPadre() != null && criterio2.getId() != criterio.getId() && criterio2.getIdPadre().longValue() == criterio.getId()) {
						isPadre = true;
						break;
					}
				}

				if (!isPadre) {
					// Find valore punteggio per criterio/partecipante
					Object valore = "?";

					List<Coefficienti> coefficientiAppalti = datiAppalti.getCoefficienti();
					for (Coefficienti coefficienteAppalti : coefficientiAppalti) {
						if (coefficienteAppalti.getCodimp() != null && coefficienteAppalti.getCodimp().equals(partecipante.getCodiceImpresa())
								&& coefficienteAppalti.getNecvan() != null && coefficienteAppalti.getNecvan().longValue() == criterio.getId()) {
							valore = new BigDecimal(coefficienteAppalti.getPunteggio());
							break;
						}
					}

					createCell(rowPartecipante, colIdx++, cellStyleNormalBorders, valore);
				}
			}
		}

		// AREA DATI APPALTI - PUNTEGGI TECNICI
		rowIdx++;
		// Riga titolo
		rowTitle = shRiepilogo.createRow(rowIdx++);
		createCell(rowTitle, 0, cellStyleBold, "Concorrente");
		createCell(rowTitle, 1, cellStyleBold, "Punteggio totale");

		// Righe concorrenti
		for (OepvPartecipanteListaDto partecipante : partecipanti) {
			colIdx = 0;
			Row rowPartecipante = shRiepilogo.createRow(rowIdx++);
			createCell(rowPartecipante, colIdx++, cellStyleBoldBordersWrapText, partecipante.getRagioneSociale());

			// Find punteggio tecnico per partecipante
			Object valore = "?";

			List<PunteggiTecniciImprese> punteggiAppalti = datiAppalti.getPunteggiTecniciImprese();
			for (PunteggiTecniciImprese punteggioAppalti : punteggiAppalti) {
				if (punteggioAppalti.getCodimp() != null && punteggioAppalti.getCodimp().equals(partecipante.getCodiceImpresa())) {
					valore = new BigDecimal(punteggioAppalti.getPunteggio());
					break;
				}
			}

			createCell(rowPartecipante, colIdx++, cellStyleNormalBorders, valore);
		}

		// Set double border around area appalti
		if (rowIdx > rowIdxAppaltiStart) {
			CellRangeAddress region = new CellRangeAddress(rowIdxAppaltiStart, rowIdx - 1, 0, maxColIdx);
			RegionUtil.setBorderBottom(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderLeft(BorderStyle.DOUBLE, region, shRiepilogo);
			RegionUtil.setBorderRight(BorderStyle.DOUBLE, region, shRiepilogo);
		}

		// Size columns
		shRiepilogo.setColumnWidth(0, 60 * 256);
		for (int i = 1; i <= maxColIdx; i++) {
			shRiepilogo.setColumnWidth(i, 20 * 256);
		}
	}

	private void mergeCellsSameValue(int startCol, int maxColIdx, Sheet sheet, Row row) {
		String currentValue = null;
		int mergeColStart = 0;
		for (int i = startCol; i <= maxColIdx; i++) {
			String val = "";
			if (row.getCell(i) != null && row.getCell(i).getStringCellValue() != null) {
				val = row.getCell(i).getStringCellValue();
			}

			if (!val.equals(currentValue)) {
				if (currentValue != null && currentValue.length() > 0 && ((i - 1) > mergeColStart)) {
					// Merge previous range
					sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), mergeColStart, i - 1));
				}
				currentValue = val;
				mergeColStart = i;
			}
		}
		// Merge last group
		if (currentValue != null && currentValue.length() > 0 && maxColIdx > mergeColStart) {
			sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), mergeColStart, maxColIdx));
		}
	}

	private void createCell(Row row, int colIdx, CellStyle cellStyle, Object value) {
		Cell cell1 = row.createCell(colIdx);
		if (value == null) {
			cell1.setCellValue("");
		} else if (value instanceof String) {
			cell1.setCellValue((String) value);
		} else if (value instanceof BigDecimal) {
			cell1.setCellValue(((BigDecimal) value).doubleValue());
		} else if (value instanceof Double) {
			cell1.setCellValue(((Double) value).doubleValue());
		} else if (value instanceof Integer) {
			cell1.setCellValue(((Integer) value).intValue());
		}
		cell1.setCellStyle(cellStyle);
	}

	private String getCharForNumber(int i) {
		return i >= 0 && i <= 25 ? String.valueOf((char) (i + 65)) : "?";
	}

	protected String toSha256(String value) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
			// return new String(encodedhash, StandardCharsets.UTF_8);
			final StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < encodedhash.length; i++) {
				final String hex = Integer.toHexString(0xff & encodedhash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error("Errore in encoding SHA-256", e);
		}
		return null;
	}

	private List<OepvCommissarioDto> getCommissariGara(String codiceLotto, String codiceGara) {
		// Prima ricerca per codice lotto
		List<OepvCommissarioDto> items = oepvRepository.findCommissariGaraOepv(codiceLotto);
		if (items.size() == 0 && codiceGara != null) {
			if (codiceGara.startsWith("$")) {
				codiceGara = codiceGara.substring(1);
			}
			// Se non trovato, allora cerca per codice gara senza $
			items = oepvRepository.findCommissariGaraOepv(codiceGara);
		}
		return items;
	}

	/**
	 * Estrae il contenuto del file firmato o marcato utilizzando {@link DigitalSignatureChecker}
	 * 
	 * @param doc      il documento
	 * @param fileName il nome del documento
	 * @return {@link Tuple} con nome del file sbustato e contenuto, altrimenti ultima operazione effettuata sul file 
	 */
	public Tuple<String,byte[]> estraiContenutoFile(byte[] doc, String fileName) {

		// TODO GABRIELE VERIFICA POM PER DIGITALSIGN
		//TODO da sistemare in seconda battuta con gestione accurata della maschera e della estensione del file
//		try {
//			if (doc != null && fileName != null) {
//				logger.info("fileName: {}",fileName);
//				String[] fileNameSplit = fileName.split("\\.");
//				int totalBundles = fileNameSplit.length - 1;
//				String ext = fileNameSplit[totalBundles--].toLowerCase();
//				if(DOCUMENTO_FIRMATO.equals(ext) || DOCUMENTO_MARCATO.equals(ext)) {
//					DigitalSignatureChecker digitalSignatureChecker = new DigitalSignatureChecker();
//					while (totalBundles>0) {// ciclo infinito
//						logger.info("fileExt: {}[{}]",ext,totalBundles);
//						if (DOCUMENTO_MARCATO.equals(ext)) {
//							doc = digitalSignatureChecker.getContentTimeStamp(doc);
//							if(totalBundles>0)
//								ext = fileNameSplit[totalBundles--].toLowerCase();
//						} else {
//							doc = digitalSignatureChecker.getContent(doc);
//							if(totalBundles>0)
//								ext = fileNameSplit[totalBundles--].toLowerCase();
//						}
////						if(totalBundles==0) break; //elegant exit
//					}
//				}
//				logger.info("ext: {}",ext);
//				logger.info("New-fileName: {}",fileNameSplit[0].concat(".").concat(ext));
//				return new Tuple<String,byte[]>(fileNameSplit[0].concat(".").concat(ext), doc);
//			}
//		} catch (Exception e) {
//			logger.warn("Errore nello sbustamento, restituisco ultima operazione elaborata sul file. [" + e.getMessage() + "]");
//			if (logger.isDebugEnabled()) {
//				logger.debug("Trace full error.", e);
//			}
//		}

		return new Tuple<String,byte[]>(fileName,doc);
	}

}
