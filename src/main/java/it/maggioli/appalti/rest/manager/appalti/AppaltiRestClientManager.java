package it.maggioli.appalti.rest.manager.appalti;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.maggioli.appalti.rest.dto.appalti.CgResponse;

@Service("appaltiRestClientManager")
public class AppaltiRestClientManager {

	private static final Logger logger = LoggerFactory.getLogger(AppaltiRestClientManager.class);

	@Value("${appalti.url:${appalti.client.url:http://appalti:8080}}")
	private String urlAppalti;

	@Value("${ssl-bypass-self-signed-certificate:#{false}}")
	private boolean bypassSslSelfSignedCertificate;

	private static final String CALCOLI_ENDPOINT = "Appalti/rest/cg/calcoli/";

	@PostConstruct
	public void showConf() {
		logger.info("urlAppalti: {}",urlAppalti);
	}
	
	public CgResponse calcoli(String ngara, String authorization) {
		CgResponse risultato = null;

		try {
//			Client client = this.getClient();

			String url = CALCOLI_ENDPOINT + ngara;
//			WebTarget webTarget = client.target(buildUrl(urlAppalti, url));
//			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, authorization);
//
//			Response response = invocationBuilder.get();
//			risultato = (response.readEntity(CgResponse.class));
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CgResponse> resp =restTemplate.exchange(buildUrl(urlAppalti, url), HttpMethod.GET, new HttpEntity<T>(createHeaders(authorization)), CgResponse.class);
//			ResponseEntity<CgResponse> resp = restTemplate.h.getForEntity(buildUrl(urlAppalti, url), CgResponse.class).;
			risultato = resp.getBody();
		} catch (Exception ex) {
			logger.error("Errore in invocazione API appalti calcoli", ex);
//			risultato.setEsito(false);
//			risultato.setErrorData(BaseResponse.ERROR_UNEXPECTED);
		}

		return risultato;
	}
	
	private HttpHeaders createHeaders(final String authorization){
		   return new HttpHeaders() {
			private static final long serialVersionUID = 1L;
		{
		         set( HttpHeaders.AUTHORIZATION, authorization );
		      }};
		}

	private String buildUrl(final String baseUrl, final String endpoint) {
		String controller = baseUrl;
		if (controller == null)
			return null;
		if (!controller.endsWith("/"))
			controller += "/";
		String url = controller + endpoint;
		logger.info("URL: {}", url);
		return url;
	}

//	private Client getClient() throws Exception {
//		return bypassSslSelfSignedCertificate ? this.getSSLClient() : ClientBuilder.newClient();
//	}

//	private Client getSSLClient() throws Exception {
//		SSLContext sslcontext = SSLContext.getInstance("TLS");
//		sslcontext.init(null, new TrustManager[] { new X509TrustManager() {
//			@Override
//			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//			}
//
//			@Override
//			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//			}
//
//			@Override
//			public X509Certificate[] getAcceptedIssuers() {
//				return new X509Certificate[0];
//			}
//
//		} }, new SecureRandom());
//
//		Client client = ClientBuilder.newBuilder().sslContext(sslcontext).hostnameVerifier((s1, s2) -> true).build();
//		return client;
//	}

}