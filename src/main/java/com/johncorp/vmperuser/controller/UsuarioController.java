package com.johncorp.vmperuser.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.johncorp.vmperuser.dao.UsuarioDAO;
import com.johncorp.vmperuser.model.usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	@PostMapping("/login")
	public ResponseEntity<usuario> loginPorEmail(@RequestBody usuario incompleto){
		// {email = "johnatan@johnatan.com", "senha": 1234} é o que ele recebe
		// findBy é o codigo para encontrar os campos
		//o nome email e senha pode ter mais coisa, mas tem queser o nome dos campos que estão no usuarioDAO, do mesmo jeito que ta lá
		
		usuario logado = dao.findByEmailAndSenha(incompleto.getEmail(), incompleto.getSenha());
		if(logado != null) {
			logado.setSenha("********");
			return ResponseEntity.ok(logado);
		}
		else {
			logado = dao.findByRacfAndSenha(incompleto.getRacf(), incompleto.getSenha());
			if(logado != null) {
				logado.setSenha("********");
				return ResponseEntity.ok(logado);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		
		}
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<usuario>> buscarTodos(){
		ArrayList<usuario> lista = (ArrayList<usuario>)dao.findAll();
		return ResponseEntity.ok(lista);
	}

}
