package com.johncorp.vmperuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.johncorp.vmperuser.dao.UsuarioDAO;
import com.johncorp.vmperuser.model.usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	@PostMapping("/login")
	public ResponseEntity<usuario> loginPorEmail(@RequestBody usuario incompleto){
		// {email = "johnatan@johnatan.com", "senha": 1234} é o que ele recebe
		usuario logado = dao.findByEmailAndSenha(incompleto.getEmail(), incompleto.getSenha());
		if(logado != null) {
			return ResponseEntity.ok(logado);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
