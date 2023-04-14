/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e10_javaauthenticate;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author famontecillo
 */
public class E10_JavaAuthenticate {
    private static final Logger LOGGER = System.getLogger("MD5");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String password = "www.packtpub.com";
        System.out.println("Original value: " + password);
        System.out.println("MD5 hash: " + getHashMD5(password));
        
    }
    
    
    public static String getHashMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((
                        byteData[i] & 0xFF) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException Ex) {
            LOGGER.log(Level.ERROR, "myERROR: " + Ex.getMessage());
            return null;
        }
    }
    
}
