package com.faith.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receptionist-home")
public class ReceptionistController {

	@GetMapping()
	public String receptionistHome(HttpSession session) {
		try {

			Integer role = (Integer) session.getAttribute("roleId");
			if (role == 3) {
				return "receptionist-home";
			}
		} catch (Exception e) {
			return "page-not-found";

		}
		return "page-not-found";
	}
}
