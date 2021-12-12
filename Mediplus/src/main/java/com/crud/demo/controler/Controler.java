package com.crud.demo.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.demo.modelo.User;
import com.crud.demo.serviceInterface.IUserService;

@Controller
@RequestMapping
public class Controler {
	public String user_session = "";
	
	@Autowired
	private IUserService service;
	
	
	@GetMapping("/")
	public String listar(Model model) {
		if(!user_session.equals("")) {
			//model.addAttribute("users", service.listar());
			model.addAttribute("username", user_session);
			return "index";
		}else {
			return "redirect:/singIn";
		}
		
	}
	
	@GetMapping("/listar/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("users", service.listarId(id));
		return "index";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		model.addAttribute("persona", new User());
		return "register";
	}
	
	@GetMapping("/singIn")
	public String singIn(Model model) {
		model.addAttribute("User", new User());
		model.addAttribute("msg", null);
		return "login";
	}
	
	@GetMapping("/singUp")
	public String singUp(Model model) {
		model.addAttribute("User", new User());
		return "register";
	}
	
	@PostMapping("/login")
	public String login(@Valid User p,Model model) {
		if(service.verifyUser(p.getUsername(), p.getPassword())) {
			model.addAttribute("msg", null);
			user_session = p.getUsername();
			return "redirect:/";
		}else {
			model.addAttribute("msg", "error");
			model.addAttribute("User", new User());
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		user_session = "";
		return "redirect:/singIn";
	}
	
	@PostMapping("/saveUser")
	public String save(@Valid User p,Model model) {
		if(service.verifyRegister(p)) {
			int id=service.save(p);
			if(id==0) {
				model.addAttribute("msg", "error");
				model.addAttribute("User", new User());
				return "register";
			}
			return "redirect:/singIn";
		}else {
			model.addAttribute("User", new User());
			model.addAttribute("msg", "porfavor rellenar todos los campos.");
			return "register";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
