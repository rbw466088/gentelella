package cn.appsys.tools;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;




import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;


public class DES3LEncrypt {
	private static Logger log = Logger.getLogger(DES3LEncrypt.class);
	/**绠楁硶*/
	private static final String Algorithm = "DESede";
	/**key瀛楄妭*/
	protected static final byte[] keyBytes = { 0x11,0x22,0x4F,0x58,(byte)0x88,0x19,0x34,0x45,
		0x55,0x55,0x58,(byte)0x88,(byte)0x85,0x55,0x55,0x58,
		(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x88,(byte)0x80,0x40,0x36,(byte)0xE2}; // 24瀛楄妭鐨勫瘑閽�
	/**鍔犲瘑绫诲璞�*/
	private static DES3LEncrypt encrypt = new DES3LEncrypt();
	
	public static DES3LEncrypt getInstance()
	{
		return encrypt;
	}
	
	/**
	 * 
	 *  DESede algorithm to enc the src(24瀛楄妭鐨勫瘑閽�)
	 */
	public static  byte[] encryptMode(byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
			SecureRandom r=new SecureRandom();
			Cipher c1 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			c1.init(Cipher.ENCRYPT_MODE, deskey,r);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.warn(e1.getMessage(), e1);
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.warn(e2.getMessage(), e2);
		} catch (java.lang.Exception e3) {
			log.warn(e3.getMessage(), e3);
		}
		return null;
	}

	

	/**
	 * 
	 * @Description: 瑙ｅ瘑
	 */
	public static String decrypt(String src)
	{
		byte[] srcBytes = decryptMode(decode(src));
		try {
			return new String(srcBytes,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.warn(e.getMessage(), e);
		}
		return null;
	}
	/**
	 * 
	 * @Description: 鍔犲瘑
	 */
	public static byte[] encrypt(String src) throws Exception
	{
		String srcString = encode(encryptMode(src.getBytes("UTF-8")));
		return srcString.getBytes("UTF-8");
	}
	
	/**
	 * 
	 * @Description: DESede algorithm to dec the src
	 */
	public static byte[] decryptMode(byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
			byte[] ints=new byte[8];
			IvParameterSpec iv=new IvParameterSpec(ints);
			SecureRandom rs=new SecureRandom();
			Cipher c1 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			c1.init(Cipher.DECRYPT_MODE, deskey,iv,rs);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.warn(e1.getMessage(), e1);
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.warn(e2.getMessage(), e2);
		} catch (java.lang.Exception e3) {
			log.warn(e3.getMessage(), e3);
		}
		return null;
	}

	/**
	 * 
	 * @Description: 缂栫爜
	 * @return
	 */
	public static String encode(byte[] bstr) {
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 
	 * @Description: 瑙ｇ爜
	 */
	public static byte[] decode(String str) {
		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
		}
		return bt;
	}

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String szSrc = "12345678:jdbc:mysql://127.0.0.1:3306/appinfodb?useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf-8";
		DES3LEncrypt.getInstance();
		try {
			//鍔犲瘑瀛楃涓�
			byte[] encrypt2 = DES3LEncrypt.encrypt(szSrc);
			String encodedString =new String(encrypt2,"utf-8");
			System.out.println(encodedString);
			String decrypt = DES3LEncrypt.decrypt(encodedString);
			System.out.println(decrypt);
			decrypt =  decrypt.substring(decrypt.indexOf(':')+1);
			System.out.println(decrypt);
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
	}
	
}



