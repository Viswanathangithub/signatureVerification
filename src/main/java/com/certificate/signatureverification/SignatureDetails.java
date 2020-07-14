package com.certificate.signatureverification;

public class SignatureDetails {
	
	private String algorithm;
	private String data;
	private String publicExp;
	private String publicKey;
	private String base64Encode;
	
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPublicExp() {
		return publicExp;
	}
	public void setPublicExp(String publicExp) {
		this.publicExp = publicExp;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getBase64Encode() {
		return base64Encode;
	}
	public void setBase64Encode(String base64Encode) {
		this.base64Encode = base64Encode;
	}

}
