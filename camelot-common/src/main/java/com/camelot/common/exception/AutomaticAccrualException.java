package com.camelot.common.exception;


import com.camelot.common.constant.CommonConstant;

/**
 * 自定义异常类(默认500错误)
 * @author sunshaobo
 */
public class AutomaticAccrualException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Integer code;

	public AutomaticAccrualException(String message){
		super(message);
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
	}

	public AutomaticAccrualException(Integer code,String message){
		super(message);
		this.code = code;
	}

	public AutomaticAccrualException(Throwable cause)
	{
		super(cause);
	}

	public AutomaticAccrualException(String message, Throwable cause)
	{
		super(message,cause);
	}

	public Integer getCode() {
		return code;
	}

}
