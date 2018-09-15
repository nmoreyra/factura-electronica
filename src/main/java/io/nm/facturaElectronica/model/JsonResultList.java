package io.nm.facturaElectronica.model;

import java.util.List;

public class JsonResultList {

	private Boolean success;
	private String msg;
	private List<Object> result;
	private int total_items;

	public int getTotal_items() {
		return total_items;
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

	public List<Object> getResult() {
		return result;
	}

	public void setResult(List<Object> result) {
		this.result = result;
	}

	public JsonResultList(Boolean success, String msg) {
		this.success = success;
		this.msg = msg;
		this.result = null;
		this.total_items = 0;
	}

	public JsonResultList(Boolean success, String msg, List<Object> result) {
		this.success = success;
		this.msg = msg;
		this.result = result;
		this.total_items = result == null ? 0 : result.size();
	}
}
