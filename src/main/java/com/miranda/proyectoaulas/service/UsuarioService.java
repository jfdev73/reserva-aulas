package com.miranda.proyectoaulas.service;

import com.miranda.proyectoaulas.model.Usuario;
import com.miranda.proyectoaulas.repository.UsuarioRepository;

public class UsuarioService {
	
	 public static Usuario login(String username, String password) {
		UsuarioRepository repository =  new UsuarioRepository();
		
		return repository.logged(username, password);
		 
		 
		 
	 }

}
