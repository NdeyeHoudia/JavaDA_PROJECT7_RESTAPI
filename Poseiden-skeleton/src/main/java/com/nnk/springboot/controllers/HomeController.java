package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/")
	public String home(HttpServletRequest request)
	{
		String names = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(names).orElseThrow();
		String user1 = userRepository.findByUsername(names).get().getRole();
		if(currentUser.getRole().equals("ADMIN"))
		{
			return "redirect:/user/list";
		}else
			return "redirect:/bidList/list";
	}
	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{
		return "redirect:/bidList/list";
	}
}
