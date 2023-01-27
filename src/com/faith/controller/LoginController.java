package com.faith.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faith.entity.User;
import com.faith.service.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ILoginService loginServiceImplementation;
	
	@GetMapping()
	public String loginPage(Model _model) {
		User user = new User();
		_model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/mapUser")
	public String mapUser(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session,Model _model) {

		Integer role = loginServiceImplementation.getRoleFromLogin(username, password);
		if(role == 3) {
			System.out.println("ROle is 3");
			session.setAttribute("username", username);
			session.setAttribute("roleId", role);
			return "redirect:/receptionist-home";
		}
		return "page-not-found";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("roleId");
		return "redirect:/login";
	}

}
