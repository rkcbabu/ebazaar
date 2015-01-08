/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Chaulagai
 */
public class EncryptionUtil {

    private static SecretKeySpec skeySpec;

    static {
        try {
            ClassPathResource res = new ClassPathResource("key.key");
            if (res != null) {
                File file = res.getFile();
                FileInputStream input = new FileInputStream(file);
                byte[] in = new byte[(int) file.length()];
                input.read(in);
                skeySpec = new SecretKeySpec(in, "AES");
                input.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String input)
            throws GeneralSecurityException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
//        SecretKey skeySpec = keyGenerator.generateKey();

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(input.getBytes());

    }

    public static String decrypt(byte[] input) throws GeneralSecurityException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return new String(cipher.doFinal(input));
    }
}
