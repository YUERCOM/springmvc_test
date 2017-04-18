package com.yuer.test.model;

public class LogModel {
	private Long beginTime;
	private Long endTime;
	private Long interval;
	private String requestUrl;
	private String requestParam;
	private String responseCode;
	private String responseValue;
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getInterval() {
		return interval;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getRequestParam() {
		return requestParam;
	}
	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseValue() {
		return responseValue;
	}
	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}
	
	public String toString(){
		return "beginTime:" + beginTime + ";endTime:" + endTime + ";interval:" + 
				interval + ";requestUrl:" + requestUrl + ";requestParam:" + requestParam + ";responseCode:" + 
				responseCode + ";responseValue:" + responseValue;
	}
	
}
