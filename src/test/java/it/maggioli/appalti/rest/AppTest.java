package it.maggioli.appalti.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.utils.sicurezza.FactoryCriptazioneByte;
import it.eldasoft.utils.sicurezza.ICriptazioneByte;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void decipherData() throws CriptazioneException {
      String pwd = "!imNxblf";
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance("LEG", 
          pwd.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
      System.out.println(new String(decriptatorePsw.getDatoCifrato()) + " - " + new String(decriptatorePsw.getDatoNonCifrato()));
      assertTrue( true );
    }
    @Test
    public void cipherData() throws CriptazioneException {
      String pwd = "gabriele";
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance("LEG", 
          pwd.getBytes(), ICriptazioneByte.FORMATO_DATO_NON_CIFRATO);
//      System.out.println(new String(decriptatorePsw.getDatoCifrato()) + " - " + new String(decriptatorePsw.getDatoNonCifrato()));
      assertTrue( true );
    }
    @Test
    public void byteToHex() throws NoSuchAlgorithmException {
      /*
       * CREATE TABLE W_APPLICATION_KEYS (
CLIENTID VARCHAR(255) NOT NULL,
    CHIAVE VARCHAR(255),
    NOTE VARCHAR(2000),
    PRIMARY KEY (CLIENTID)
);

select * from W_APPLICATION_KEYS;

INSERT INTO w_application_keys (clientid, chiave, note) VALUES('TASK', 'ed0402756a25e2ca1ee0d74bad3dec03ee81c72b74eefaf38c484b140b10d4b0', 'Utente Tecnico TASK per ws-appalti-rest');
INSERT INTO w_application_keys (clientid, chiave, note) VALUES('TASK', '8ab19b56f5d4b42aba9c2053ada32287ab25f51695aa85b4fdcec6d722db5dcb', 'Utente Tecnico TASK per ws-appalti-rest');

update w_application_keys set chiave='ed0402756a25e2ca1ee0d74bad3dec03ee81c72b74eefaf38c484b140b10d4b0' where clientid='TASK';
       */
//      String pwd = "vk+RLs,6)'G`9U{s";
      //String pwd = "olgjhws98";
//      String pwd = "p^Y?q4NC+=tKWLJD";
      String pwd = "";
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(pwd.getBytes());
      byte byteData[] = md.digest();
      System.out.println(byteData);
      long start = System.currentTimeMillis();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < byteData.length; i++) {
          sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
      }
      System.out.println(sb.toString());
      long t1 = System.currentTimeMillis()-start;
      assertEquals("8bfbfb80f8b2a3127af3c655983e590e9a37de36aeb61bee9de866f9a38ab351", sb.toString());
      start = System.currentTimeMillis();
      sb = new StringBuffer();
      Formatter form = new Formatter();
      for (int i = 0; i < byteData.length; i++) {
        form.format("%02x", byteData[i]);
//          sb.append(form.format("%02x", b).toString());
      }
      System.out.println(form.toString());
      long t2 = System.currentTimeMillis()-start;
      assertEquals("8bfbfb80f8b2a3127af3c655983e590e9a37de36aeb61bee9de866f9a38ab351", form.toString());
      System.out.println(t1+" : "+t2);
      
    }
    
    @Test
    public void dateTest() throws ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
      String date = "14:00";
      System.out.println(sdf.parse(date));
      assertTrue( true );
    }
}
