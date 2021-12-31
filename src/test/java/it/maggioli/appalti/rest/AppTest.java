package it.maggioli.appalti.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;

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
      String pwd = "!imNxb,f";
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance("LEG", 
          pwd.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
      System.out.println(new String(decriptatorePsw.getDatoCifrato()) + " - " + new String(decriptatorePsw.getDatoNonCifrato()));
    }
    @Test
    public void cipherData() throws CriptazioneException {
      String pwd = "gabriele";
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance("LEG", 
          pwd.getBytes(), ICriptazioneByte.FORMATO_DATO_NON_CIFRATO);
      System.out.println(new String(decriptatorePsw.getDatoCifrato()) + " - " + new String(decriptatorePsw.getDatoNonCifrato()));
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

INSERT INTO w_application_keys (clientid, chiave, note) VALUES('TASK', '8ab19b56f5d4b42aba9c2053ada32287ab25f51695aa85b4fdcec6d722db5dcb', 'Utente Tecnico TASK per ws-appalti-rest');

       */
      String pwd = "vk+RLs,6)'G`9U{s";
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
      assertEquals("8ab19b56f5d4b42aba9c2053ada32287ab25f51695aa85b4fdcec6d722db5dcb", sb.toString());
      start = System.currentTimeMillis();
      sb = new StringBuffer();
      Formatter form = new Formatter();
      for (int i = 0; i < byteData.length; i++) {
        form.format("%02x", byteData[i]);
//          sb.append(form.format("%02x", b).toString());
      }
      System.out.println(form.toString());
      long t2 = System.currentTimeMillis()-start;
      assertEquals("8ab19b56f5d4b42aba9c2053ada32287ab25f51695aa85b4fdcec6d722db5dcb", form.toString());
      System.out.println(t1+" : "+t2);
    }
    
    @Test
    public void dateTest() throws ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
      String date = "14:00";
      System.out.println(sdf.parse(date));
    }
}
