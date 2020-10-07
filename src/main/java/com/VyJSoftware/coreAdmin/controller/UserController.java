package com.VyJSoftware.coreAdmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VyJSoftware.coreAdmin.exception.ResourceNotFoundException;
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
	@GetMapping("/users/{id}")
	public ResponseEntity<User> traerUnUsuario(@PathVariable Long idUsuario){
		
		User user = service.findById(idUsuario)
						.orElseThrow(() -> new ResourceNotFoundException("No existe este usuario"));
		
		return ResponseEntity.ok(user);
		
	}
	
	//Crear un usuario nuevo
	
	@PostMapping("/users")
	public User crearUsuario(@RequestBody User usuario) {
		return service.save(usuario);
	}
	
	
	//Actualizar Datos
	@PutMapping("/users/{id}")
	public ResponseEntity<User> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody User usuario){
		
		User user = service.findById(idUsuario)
						.orElseThrow(() -> new ResourceNotFoundException("No existe este usuario con el ID ==>> " +idUsuario));
		
		user.setFirstName(usuario.getFirstName());
		user.setLastName(usuario.getLastName());
		user.setCorreoElectronico(usuario.getCorreoElectronico());
		
		User usuarioActual = service.save(user);
		return ResponseEntity.ok(usuarioActual);
	}
	
	
	//Borrar usuario con API Rest
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> borrarUsuario(@PathVariable Long idUsuario){
		
		User usuario = service.findById(idUsuario)
						.orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ID ====>>>  "+idUsuario));
		
		service.delete(usuario);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Borrado", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}

}
