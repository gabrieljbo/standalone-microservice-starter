package dev.gabrieljbo.project.commons.exception;

public enum SystemErrorCode implements ErrorCode {

	SAVE_CUSTOMER_ERROR_CODE(1001), 
	FIND_ALL_CUSTOMERS_ERROR_CODE(1002),
	SAVE_WEATHER_REPORT_ERROR_CODE(2001),
	
    VALIDATION_ERROR_CODE(9001),
    DATA_ACCESS_ERROR_CODE(9002),	
	UNHANDLED_ERROR_CODE(9999);

	private final int code;

	private SystemErrorCode(int code) {
	    this.code = code;
    }

	@Override
	public int getCode() {
		return code;
	}
	
}
