package app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import app.exception.AppException;

public class AbstractController {
	
	private ThreadLocal<List<String>> warningMessagesThread= new ThreadLocal<>();
	
	@ExceptionHandler(AppException.class)
	public ControllerResponse handleAppExceptions(AppException exception, WebRequest request, HttpServletResponse response) {
		getWarningMessages().add(exception.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return response(null);
	}
	
	protected ControllerResponse response(Object content) {
		ControllerResponse response = new ControllerResponse();
		response.setData(content);
		// Get runtime exceptions from local thread
		response.setWarningMessages(new ArrayList<>(getWarningMessages()));
		
		//Get authenticated user from security context
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserInfo user = new UserInfo();
			user.setUsername(authentication.getName());
			// Get user authorities from security context
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				user.addRole(authority.getAuthority());
			}
			response.setUser(user);
		}
		return response;
	}
	
	protected List<String> getWarningMessages() {
		if (this.warningMessagesThread.get() == null) {
			this.warningMessagesThread.set(new ArrayList<>());
		}
		return this.warningMessagesThread.get();
	}

}
