package app.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.User;
import app.models.UserRepository;
import app.services.MockService;

@RestController
@RequestMapping(value="/user")
@RolesAllowed(value = "ADMIN")
public class UserController extends AbstractController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MockService mockService;
	
	@RequestMapping(value = "/list-error")
	public ControllerResponse list(){
		mockService.makeErrorHappen();
		return response(null);
	}
	
	@RequestMapping("/list")
	public ControllerResponse list2(){
		
		User user = new User();
		user.setUserId(0);
		user.setEmail("email");
		user.setEnabled(true);
		user.setPassword("123");
		user.setUsername("username");
		
		return response(user);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, boolean enabled, String password, String username){
		User user = null;
		try{
			user = new User();
			user.setEmail(email);
			user.setEnabled(enabled);
			user.setPassword(password);
			user.setUsername(username);
			
			userRepository.save(user);
			
		} catch (Exception e){
			return "Erro ao criar usuário " + e.toString();
		}
		return "Usuário criado com sucesso! (id= "+user.getUserId()+")";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id){
		try{
			User user = new User();
			userRepository.delete(user);
		}catch (Exception e){
			return "Erro ao deletar usuário: " + e.toString();
		}
		return "Usuário excluido com sucesso!";
	}
	
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email){
		String userId;
		try{
			User user = userRepository.findByEmail(email);
			userId = String.valueOf(user.getUserId());
		}catch (Exception e){
			return "Usuário não encontrado: " + e.toString();
		}
		return "O id do usuário é "+userId;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String password){
		try{
			User user = userRepository.findOne(id);
			user.setEmail(email);
			user.setPassword(password);
			userRepository.save(user);
		}catch (Exception e){
			return "Erro ao alterar usuário: " + e.toString();
		}
		return "Usuário alterado com sucesso !";
	}
	
	
}
