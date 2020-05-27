package com.johncorp.vmperuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.johncorp.vmperuser.dao.MaquinaDAO;
import com.johncorp.vmperuser.model.Maquina;

@RestController
@CrossOrigin("*")
public class MaquinaController {
	
	@Autowired 
	MaquinaDAO mdao;
	
	@PostMapping("/solicitacoes/nova/maquina")
	public ResponseEntity<Maquina> adicionarMaquina(@RequestBody Maquina nova){
		Maquina quantidade =new  Maquina();
		try {
			quantidade.setProcessador(nova.getProcessador());
			quantidade.setMemoriaGB(nova.getMemoriaGB());
			quantidade.setCapacidadeHD(nova.getCapacidadeHD());
			quantidade.setTransferencia(nova.getTransferencia());
			quantidade.setValor(nova.getCalcularValor(nova.getProcessador(), nova.getMemoriaGB(),nova.getCapacidadeHD(), nova.getTransferencia()));
			mdao.save(quantidade);
			
			return ResponseEntity.ok(quantidade);
		}
		catch(Exception ex) {
		return ResponseEntity.status(400).build();
		}
	}
}

	
	


