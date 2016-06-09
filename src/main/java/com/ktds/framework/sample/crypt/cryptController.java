package com.ktds.framework.sample.crypt;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hornetq.utils.json.JSONException;
import org.hornetq.utils.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class cryptController {
	

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// RSA Key 생성 
	@RequestMapping(value = "/crypt/requestkey", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	void requestkey(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws InvalidKeySpecException, IOException, JSONException, NoSuchAlgorithmException{
	//	HttpSession session = request.getSession();

		logger.info("/crypt/requestkey Call");

		KeyPairGenerator generator;
		
		
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(1024);
			
			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			session.setAttribute("_RSA_WEB_Key_", privateKey);   //세션에 RSA 개인키를 세션에 저장한다.
			
	        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
	        String publicKeyModulus = publicSpec.getModulus().toString(16);
	        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
			
	        response.setContentType("application/json;charset=utf-8");
	        
	        
		    JSONObject json = new JSONObject();
		    
		    json.put("publicKeyModulus", publicKeyModulus);
		    json.put("publicKeyExponent",publicKeyExponent);
		    

		    response.getWriter().print(json.toString());
		    
		
	}
	
	@RequestMapping(value = "/crypt/requestmessage", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public void requestMessage(@ModelAttribute("cryptoVO") CryptVO cryptVO, HttpServletResponse response, HttpServletRequest request,HttpSession session) throws JSONException, IOException{
		
	//	HttpSession session = request.getSession();
		
		logger.info("/crypt/requestmessage Call");

		logger.info("form : {}",cryptVO.getPassword());
		
		PrivateKey privateKey = (PrivateKey) session.getAttribute("_RSA_WEB_Key_");
		
		logger.info("privateKey : {}",privateKey);
		 
		cryptVO.setEmail(decryptRsa(privateKey, cryptVO.getEmail()));
		
		cryptVO.setPassword(decryptRsa(privateKey,cryptVO.getPassword()));
         
		JSONObject json = new JSONObject();
	    
	    json.put("email",  cryptVO.getEmail());
	    
	    json.put("password",cryptVO.getPassword());
	    

	    response.getWriter().print(json.toString());
	        
	      
		
	}
	
	public String decryptRsa(PrivateKey privateKey, String securedValue) {
	     String decryptedValue = "";
	     try{
	        Cipher cipher = Cipher.getInstance("RSA");
	       /**
	        * 암호화 된 값은 byte 배열이다.
	        * 이를 문자열 폼으로 전송하기 위해 16진 문자열(hex)로 변경한다. 
	        * 서버측에서도 값을 받을 때 hex 문자열을 받아서 이를 다시 byte 배열로 바꾼 뒤에 복호화 과정을 수행한다.
	        */
	        byte[] encryptedBytes = hexToByteArray(securedValue);
	        cipher.init(Cipher.DECRYPT_MODE, privateKey);
	        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
	        decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
	     }catch(Exception e)
	     {
	         logger.info("decryptRsa Exception Error : "+e.getMessage());
	     }
	        return decryptedValue;
	} 
	
	 public static byte[] hexToByteArray(String hex) {
		    if (hex == null || hex.length() % 2 != 0) {
		        return new byte[]{};
		    }
		 
		    byte[] bytes = new byte[hex.length() / 2];
		    for (int i = 0; i < hex.length(); i += 2) {
		        byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
		        bytes[(int) Math.floor(i / 2)] = value;
		    }
		    return bytes;
		}

}
