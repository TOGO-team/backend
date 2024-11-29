package com.gotogether.global.apipayload.exception;

import com.gotogether.global.apipayload.code.BaseErrorCode;
import com.gotogether.global.apipayload.code.ErrorReasonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private BaseErrorCode code;

	public ErrorReasonDto getErrorReason() {
		return this.code.getReason();
	}

	public ErrorReasonDto getErrorReasonHttpStatus() {
		return this.code.getReasonHttpStatus();
	}
}
