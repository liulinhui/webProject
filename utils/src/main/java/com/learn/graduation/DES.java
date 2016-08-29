package com.learn.graduation;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

//参考文献： http://blog.csdn.net/uikoo9/article/details/27982575
public class DES  {
	protected final static Logger logger = Logger.getLogger(DES.class);
	private final static int ITERATIONS = 20;
	base64 des=new base64();
	
	class base64{
		// base64 编码
		public  byte[] encode(byte[] b) throws Exception {
			ByteArrayOutputStream baos = null;
			OutputStream b64os = null;
			try {
				baos = new ByteArrayOutputStream();
				b64os = MimeUtility.encode(baos, "base64");
				b64os.write(b);
				b64os.close();
				return baos.toByteArray();
			} catch (Exception e) {
				throw new Exception(e);
			} finally {
				try {
					if (baos != null) {
						baos.close();
						baos = null;
					}
				} catch (Exception e) {
				}
				try {
					if (b64os != null) {
						b64os.close();
						b64os = null;
					}
				} catch (Exception e) {
				}
			}
		}

		// base64解码
		public  byte[] decode(byte[] b) throws Exception {
			ByteArrayInputStream bais = null;
			InputStream b64is = null;
			try {
				bais = new ByteArrayInputStream(b);
				b64is = MimeUtility.decode(bais, "base64");
				byte[] tmp = new byte[b.length];
				int n = b64is.read(tmp);
				byte[] res = new byte[n];
				System.arraycopy(tmp, 0, res, 0, n);
				return res;
			} catch (Exception e) {
				throw new Exception(e);
			} finally {
				try {
					if (bais != null) {
						bais.close();
						bais = null;
					}
				} catch (Exception e) {
				}
				try {
					if (b64is != null) {
						b64is.close();
						b64is = null;
					}
				} catch (Exception e) {
				}
			}
		}

	}
	
	
	//加密算法
	 public  String encrypt(String key, String plainText) throws Exception {  
	        // String encryptTxt = "";  
	        try {  
	            byte[] salt = new byte[8];  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            md.update(key.getBytes());  
	            byte[] digest = md.digest();  
	            for (int i = 0; i < 8; i++) {  
	                salt[i] = digest[i];  
	            }  
	            PBEKeySpec pbeKeySpec = new PBEKeySpec(key.toCharArray());  
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");  
	            SecretKey skey = keyFactory.generateSecret(pbeKeySpec);  
	            PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATIONS);  
	            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");  
	            cipher.init(Cipher.ENCRYPT_MODE, skey, paramSpec);  
	            byte[] cipherText = cipher.doFinal(plainText.getBytes());  
	            String saltString = new String(des.encode(salt));  
	            String ciphertextString = new String(des.encode(cipherText));  
	            return saltString + ciphertextString;  
	        } catch (Exception e) {  
	            throw new Exception("Encrypt Text Error:" + e.getMessage(), e);  
	        }  
	    }  
	 
	 //解密算法
	 public  String decrypt(String key, String encryptTxt) throws Exception {  
	        int saltLength = 12;  
	        try {  
	            String salt = encryptTxt.substring(0, saltLength);  
	            String ciphertext = encryptTxt.substring(saltLength, encryptTxt.length());  
	            byte[] saltarray = des.decode(salt.getBytes());  
	            byte[] ciphertextArray = des.decode(ciphertext.getBytes());  
	            PBEKeySpec keySpec = new PBEKeySpec(key.toCharArray());  
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");  
	            SecretKey skey = keyFactory.generateSecret(keySpec);  
	            PBEParameterSpec paramSpec = new PBEParameterSpec(saltarray, ITERATIONS);  
	            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");  
	            cipher.init(Cipher.DECRYPT_MODE, skey, paramSpec);  
	            byte[] plaintextArray = cipher.doFinal(ciphertextArray);  
	            return new String(plaintextArray);  
	        } catch (Exception e) {  
	            throw new Exception(e);  
	        }  
	    }  
}