package com.certificate.signatureverification;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class SignatureServiceImpl {

	public String validateCertificate(String algorithm, String data, String publicExp, String publicKey, String base64Encode) {
		String failedVerificationStatus = "Signature Verification Failed";
		String verificationStatus = failedVerificationStatus;
		try {
			byte[] dataToSign = data.getBytes();
			BigInteger pubExp = new BigInteger(publicExp, 16);
			BigInteger modulus = new BigInteger(publicKey, 16);
			RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, pubExp);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey newPublicKey = keyFactory.generatePublic(rsaPublicKeySpec);

			//copy the response(Base64 encoded); Actual signature is in byte[] format. It is encoded to Base64 format
			String base64EncodedSignature = base64Encode;
			// Base64 decode the response to get the original signature in byte[] format
			byte[] base64DecodedSignature = Base64.getDecoder().decode(base64EncodedSignature.getBytes(StandardCharsets.UTF_8));

			Signature verifySign = Signature.getInstance(algorithm);
			//Initiate the Signature object with the public key for Signature verification
			verifySign.initVerify(newPublicKey);
			//Update the Signature object with the original data
			verifySign.update(dataToSign);
			//Verify the Signature
			verificationStatus = verifySign.verify(base64DecodedSignature) ? "Signature Verification Successful" : failedVerificationStatus;
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException | NumberFormatException e) {
			// TODO Auto-generated catch block
		}
		return verificationStatus;
	}
}
