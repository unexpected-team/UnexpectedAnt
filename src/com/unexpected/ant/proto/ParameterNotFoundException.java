package com.unexpected.ant.proto;

public class ParameterNotFoundException extends Exception {
	private String parameterName;

	public ParameterNotFoundException(String parameterName) {
		this.parameterName = parameterName;
	}

	public ParameterNotFoundException(Object parameterName) {
		this.parameterName = String.valueOf(parameterName);
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
}
