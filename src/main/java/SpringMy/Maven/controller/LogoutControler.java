package SpringMy.Maven.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.model.UserDTO;

@Controller 
@EnableWebMvc
public class LogoutControler {
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@ModelAttribute("userForm") UserDTO userDTO,ModelMap model, HttpSession session) {		
		model.clear();
		session.invalidate();
		return "login";
	}
}
