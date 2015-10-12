package app.controllers;

import java.io.Serializable;
import java.util.List;

public class ControllerResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> successMessages;
	private List<String> warningMessages;
	private List<String> errorMessages;

	private UserInfo user;
	private Object data;
	
	public List<String> getSuccessMessages() {
		return successMessages;
	}
	
	public void setSuccessMessages(List<String> successMessages) {
		this.successMessages = successMessages;
	}
	
	public List<String> getWarningMessages() {
		return warningMessages;
	}
	
	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public UserInfo getUser() {
		return user;
	}
	
	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
