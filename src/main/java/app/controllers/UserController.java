package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.models.User;
import app.models.UserRepository;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String password){
		User user = null;
		try{
			user = new User();
			userRepository.save(user);
		} catch (Exception e){
			return "Erro ao criar usuário " + e.toString();
		}
		return "Usuário criado com sucesso! (id= "+"user.getId()"+")";
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
