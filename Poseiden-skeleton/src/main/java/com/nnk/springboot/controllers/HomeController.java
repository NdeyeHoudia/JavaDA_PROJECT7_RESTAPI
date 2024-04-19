package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController
{
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/")
	public String home(Model model, Principal principal, HttpServletRequest request,User user)
	{
		String name = principal.getName();
		String names = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(names).orElseThrow();
	//	String role = userRepository.findByUsername(names).get().getUsername();
		String user1 = userRepository.findByUsername(names).get().getRole();
		//String role1 = userRepository.findByUsername(names).get().getRole().concat(names);
		if(currentUser.getRole().equals("ADMIN"))
		{
			System.out.println(currentUser);
			return "redirect:/user/list";
		}else
			System.out.println(user1);

		return "redirect:/bidList/list";
		/*else if (role1=="USER") {
			return "redirect:/bidList/list";
		}
		else return "home";
		*/
		//	System.out.println(role1);

	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{
		return "redirect:/bidList/list";
	}


}
