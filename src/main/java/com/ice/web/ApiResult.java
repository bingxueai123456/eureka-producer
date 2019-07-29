package com.ice.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;

/**
 * Created by xiaoweilin on 17-3-20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {
	static private Gson gson = new GsonBuilder().create();

	@JsonIgnore
	transient private Locale locale;

	private boolean success = true;
	private String errCode;
	private String errMsg;
	private String callbackSequence;
	private Long sysTime;
	private T data;

	public ApiResult() {
		this(Locale.getDefault());
	}

	public ApiResult(Locale locale) {
		this.locale = locale;
		this.sysTime = System.currentTimeMillis();
	}

	public static <T> ApiResult<T> succ() {
		return succ(null);
	}

	public static <T> ApiResult<T> succ(T data) {
		ApiResult<T> r = new ApiResult<>();
		r.setSuccess(true);
		r.setData(data);
		return r;
	}

	public static <T> String succStr(T data) {
		return gson.toJson(succ(data));
	}

	public static String succStr() {
		return succStr(null);
	}


	public static <T> ApiResult<T> error(String errCode) {
		return error(errCode, null, null);
	}

	public static <T> ApiResult<T> error(String errCode, String errMsg) {
		return error(errCode, errMsg, null);
	}

	public static <T> ApiResult<T> error(String errCode, String errMsg, T data) {
		ApiResult<T> r = new ApiResult<>();
		r.setSuccess(false);
		r.setErrCode(errCode);
		r.setErrMsg(errMsg);
		r.setData(data);
		return r;
	}


	public static String errorStr(String errCode) {
		return errorStr(errCode, null, null);
	}

	public static String errorStr(String errCode, String errMsg) {
		return errorStr(errCode, errMsg, null);
	}

	public static String errorStr(String errCode, String errMsg, Object data) {
		return gson.toJson(error(errCode, errMsg, data));
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setLocale(String lang, String country) {
		this.locale = new Locale(lang, country);
	}


	public String toSuccJson(T data) {
		this.setSuccess(true);
		this.setData(data);
		return gson.toJson(this);
	}

	public String toSuccJson() {
		return toSuccJson(null);
	}



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getCallbackSequence() {
		return callbackSequence;
	}

	public void setCallbackSequence(String callbackSequence) {
		this.callbackSequence = callbackSequence;
	}

	public Long getSysTime() {
		return sysTime;
	}

	public void setSysTime(Long sysTime) {
		this.sysTime = sysTime;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
