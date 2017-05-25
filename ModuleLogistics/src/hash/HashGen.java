package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by george on 5/22/17.
 */
public class HashGen {

    public static final String getHash(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            if (sb.capacity() > 1) {
                return sb.toString();
            }
        } catch (NoSuchAlgorithmException ex) {
            return null;
            //Logger.getLogger(ReportXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
