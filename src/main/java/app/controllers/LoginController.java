package app.controllers;

import java.io.Serializable;

import javax.annotation.security.PermitAll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@PermitAll
public class LoginController extends AbstractController {

	@RequestMapping(method = RequestMethod.POST)
	public ControllerResponse authenticate() {
		return response(new OkResponse("Ok!"));
	}
	
	@SuppressWarnings("serial")
	public class OkResponse implements Serializable {
		
		private String message;

		public OkResponse(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		
	}
	
}
