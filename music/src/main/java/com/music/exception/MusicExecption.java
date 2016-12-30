package com.music.exception;

public class MusicExecption extends RuntimeException {

	private static final long serialVersionUID = 4025415977432942735L;

	public MusicExecption() {
		super();
	}

	public MusicExecption(String message) {
		super(message);
	}

	public MusicExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public MusicExecption(Throwable cause) {
		super(cause);
	}

}
