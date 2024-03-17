package com.miranda.proyectoaulas.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import com.miranda.proyectoaulas.model.Usuario;
import com.miranda.proyectoaulas.service.UsuarioService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asasf");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		String action = request.getParameter("action");
		
		if(action.equals("login")) {
			login(request, response);
		}
		System.out.println("valor de action: "+action);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("username");
		
		String passwordMd5 = null;
		
		if( username!=null && password !=null) {
			passwordMd5 = DigestUtils.md5Hex(password);
		}
		
		System.out.println("password Md5: "+passwordMd5);
		HttpSession session =  request.getSession();
		
		Usuario user =  UsuarioService.login(username, passwordMd5);
		System.out.println("User: "+user);
		
		
		
		
	}

}
