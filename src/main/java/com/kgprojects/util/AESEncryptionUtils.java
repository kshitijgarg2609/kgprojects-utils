package com.kgprojects.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * @author Kshitij Garg
 */
public class AESEncryptionUtils
{
    public static SecretKey generateSecretKey() throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
    public static boolean verifyKey(byte key[])
    {
    	boolean flg=false;
    	try
    	{
    		new SecretKeySpec(key, "AES");
    		flg=true;
    	}
    	catch(Exception e)
    	{
    		
    	}
    	return flg;
    }
    public static byte[] encrypt(byte arr[], byte key[]) throws Exception
    {
        return encrypt(arr, new SecretKeySpec(key,"AES"));
    }
    public static byte[] encrypt(byte arr[], SecretKey secretKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(arr);
        return encryptedBytes;
    }
    public static byte[] decrypt(byte arr[], byte key[]) throws Exception
    {
        return decrypt(arr, new SecretKeySpec(key,"AES"));
    }
    public static byte[] decrypt(byte arr[], SecretKey secretKey) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(arr);
        return decryptedBytes;
    }
}
