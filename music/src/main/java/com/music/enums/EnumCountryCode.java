package com.music.enums;

public enum EnumCountryCode {

	BR("BR"), US("US");

	public final String code;

	EnumCountryCode(String code) {
		this.code = code;
	}

	public String getType() {
		return this.code;
	}
}
