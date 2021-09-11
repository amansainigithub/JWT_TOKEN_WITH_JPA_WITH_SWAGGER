package com.test.model;

public class JwtResponse {
	
	private final String jwttoken;

	public String getJwttoken() {
		return jwttoken;
	}

	@Override
	public String toString() {
		return "JwtResponse [jwttoken=" + jwttoken + "]";
	}

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	
	
	

}
