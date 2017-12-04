package sernanp.app.util;

import java.util.ArrayList;
import java.util.List;

public class ExtJsStrutsUtil {
	private Integer total;
	@SuppressWarnings("rawtypes")
	private List data = new ArrayList();
	private Boolean success;
	private String message;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
