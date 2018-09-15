package io.nm.facturaElectronica.model;

public class JsonResult {

	private Boolean success;
	private String msg;
	private Object result;

	public JsonResult(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public JsonResult(Boolean success, String msg, Object object) {
		this.success = success;
		this.msg = msg;
		this.result = object;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object object) {
		this.result = object;
	}

}
