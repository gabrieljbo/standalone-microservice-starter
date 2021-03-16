package dev.gabrieljbo.project.commons.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -6095380906465929386L;

	private final transient List<ErrorCode> errorCodes = new ArrayList<>(0);

	public SystemException(Throwable cause, ErrorCode errorCode) {
		super(cause);

		this.errorCodes.add(errorCode);
	}

	public SystemException(Throwable cause, List<ErrorCode> errorCodes) {
		super(cause);
		
		this.errorCodes.addAll(errorCodes);
	}
	
}