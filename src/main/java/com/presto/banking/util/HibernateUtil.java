/* Hibernate Utility Class
Creates Hibernate Sessions 
Makes possible to access hibernate session variables.
 */
package com.presto.banking.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class HibernateUtil {
	private static final EntityManagerFactory entityManagerFactory = HibernateUtil.buildSessionFactory();

    private static EntityManagerFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Presto");
        	 return entityManagerFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return HibernateUtil.entityManagerFactory;
    }

    /* Md5 Method */
    public static String md5(String input) {
        String md5 = null;
        if (null == input)
            return null;

        try {
            // Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());
            // Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}