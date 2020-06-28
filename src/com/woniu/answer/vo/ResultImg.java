package com.woniu.answer.vo;

public class ResultImg {
	private String code;//返回上传图片代码
	private String result;//返回上传图片结果
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ResultImg(String code, String result) {
		super();
		this.code = code;
		this.result = result;
	}
	public ResultImg() {
		super();
		// TODO Auto-generated constructor stub
	}
}
