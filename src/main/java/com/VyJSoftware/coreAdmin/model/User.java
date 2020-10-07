package com.VyJSoftware.coreAdmin.model;

import javax.persistence.*;

import lombok.*;

@Data @NoArgsConstructor

@Entity
@Table(name = "employees")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long idUser;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
 
	private String correoElectronico;
	
	public User(String nombre, String ape, String mail) {
		super();
		
		this.firstName = nombre;
		
		this.lastName = ape;
		
		this.correoElectronico = mail;
	}

}
