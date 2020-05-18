package com.johncorp.vmperuser.dao;

import org.springframework.data.repository.CrudRepository;

import com.johncorp.vmperuser.model.usuario;

public interface UsuarioDAO extends CrudRepository<usuario, Integer>{
	
	//definir o nome do metodo e ele cria o sql pra você, where email e senha (é isso que é criado)
	public usuario findByEmailAndSenha(String email, String senha);
	public usuario findByRacfAndSenha(String racf, String senha);
	

}
