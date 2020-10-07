package com.VyJSoftware.coreAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VyJSoftware.coreAdmin.model.User;
import com.VyJSoftware.coreAdmin.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1.0")
public class UserController {
	
	@Autowired
	private UserRepository service;
	
	
	//traer todos los empleados
	@GetMapping("/users")
	public List<User> traerTodos(){
		return this.service.findAll();
	}
	
	//traer UN empleado usando el ID
	

}
