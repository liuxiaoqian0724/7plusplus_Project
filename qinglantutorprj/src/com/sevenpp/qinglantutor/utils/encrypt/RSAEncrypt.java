package com.sevenpp.qinglantutor.utils.encrypt;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
/**
 * 
		* @ClassName: RSAEncrypt 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月3日 下午3:32:09 
		* @version V1.0 
 */
public class RSAEncrypt {
		private String publickey;
		private String privatekey;
		public String getPublickey() {
			return publickey;
		}
		public void setPublickey(String publickey) {
			this.publickey = publickey;
		}
		public String getPrivatekey() {
			return privatekey;
		}
		public void setPrivatekey(String privatekey) {
			this.privatekey = privatekey;
		}
	/**
	 * 
			* @Title: genKeyPair 
			* @Description: 获取密钥
			* @param @throws NoSuchAlgorithmException    入参
			* @return void    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月3日 下午3:40:53 
			* @version V1.0   
	 */
	public void genKeyPair() throws NoSuchAlgorithmException {  
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
		// 初始化密钥对生成器，密钥大小为96-1024位  
		keyPairGen.initialize(512,new SecureRandom());  
		// 生成一个密钥对，保存在keyPair中  
		KeyPair keyPair = keyPairGen.generateKeyPair();  
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥  
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥  
		String publicKeyString = new String(Base64.getEncoder().encodeToString(publicKey.getEncoded()));  
		// 得到私钥字符串  
		String privateKeyString = new String(Base64.getEncoder().encodeToString((privateKey.getEncoded())));  
		// 将公钥和私钥保存到Map
		setPrivatekey(privateKeyString);  //0表示公钥
		setPublickey(publicKeyString);  //1表示私钥
	}  
	public RSAEncrypt() {
		try {
			genKeyPair();
		} catch (NoSuchAlgorithmException e) {
				
		}
	}
	/** 
	 * RSA公钥加密 
	 *  
	 * @param str 
	 *            加密字符串
	 * @param publicKey 
	 *            公钥 
	 * @return 密文 
	 * @throws Exception 
	 *             加密过程中的异常信息 
	 */  
	public static String encrypt( String str, String publicKey ) throws Exception{
		//base64编码的公钥
		byte[] decoded = Base64.getDecoder().decode(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}

	/** 
	 * RSA私钥解密
	 *  
	 * @param str 
	 *            加密字符串
	 * @param privateKey 
	 *            私钥 
	 * @return 铭文
	 * @throws Exception 
	 *             解密过程中的异常信息 
	 */  
	public static String decrypt(String str, String privateKey) throws Exception{
		//64位解码加密后的字符串
		byte[] inputByte = Base64.getDecoder().decode(str.getBytes("UTF-8"));
		//base64编码的私钥
		byte[] decoded = Base64.getDecoder().decode(privateKey);  
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));  
		//RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}

}