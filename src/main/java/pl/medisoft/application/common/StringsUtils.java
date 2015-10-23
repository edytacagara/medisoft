/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.common;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz Batyra
 */
public class StringsUtils {

    private static final Logger LOG = Logger.getLogger(StringsUtils.class.getName());

    private static final String SHA256 = "SHA-256";

    public static String generateSHA256(final String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(SHA256);
            md.update(password.getBytes());
            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Problem with generating SHA256 {0}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
