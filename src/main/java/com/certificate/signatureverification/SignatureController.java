package com.certificate.signatureverification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignatureController {

	@Autowired
	private SignatureServiceImpl serviceImpl;

	@PostMapping(path="/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String signatureVerify(@RequestBody SignatureDetails signatureDetails) {

		return serviceImpl.validateCertificate(signatureDetails.getAlgorithm(), 
				signatureDetails.getData(), signatureDetails.getPublicExp(), signatureDetails.getPublicKey(), signatureDetails.getBase64Encode());

	}
}
