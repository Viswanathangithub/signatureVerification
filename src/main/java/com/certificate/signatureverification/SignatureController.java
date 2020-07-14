package com.certificate.signatureverification;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignatureController {

	@Autowired
	private SignatureServiceImpl serviceImpl;

	@PostMapping(path="/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signatureVerify(@RequestBody SignatureDetails signatureDetails) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {

		return serviceImpl.validateCertificate(signatureDetails.getAlgorithm(), 
				signatureDetails.getData(), signatureDetails.getPublicExp(), signatureDetails.getPublicKey(), signatureDetails.getBase64Encode());

	}
}
