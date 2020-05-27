package com.johncorp.vmperuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.johncorp.vmperuser.dao.MaquinaDAO;
import com.johncorp.vmperuser.dao.SolicitacaoDAO;
import com.johncorp.vmperuser.model.Item;
import com.johncorp.vmperuser.model.Maquina;
import com.johncorp.vmperuser.model.Solicitacao;

@RestController
@CrossOrigin("*")
public class SolicitacaoController {
	
	@Autowired //adiciona uma nova solicitação controlada pela maquina
	SolicitacaoDAO sdao;
	@Autowired
	MaquinaDAO mdao;
	
	@PostMapping("/solicitacoes/nova")
	public ResponseEntity<Solicitacao> adicionarSolicitacao(@RequestBody Solicitacao nova){
		try {
			
			Maquina maquina = new Maquina();
			maquina = nova.getMaquina();
			maquina.setValor(maquina.getCalcularValor(maquina.getProcessador(), maquina.getMemoriaGB(),maquina.getCapacidadeHD(), maquina.getTransferencia()));
			mdao.save(maquina);
			nova.setMaquina(maquina);
			
			// aqui eu vinculo a solicitacao de cada item
			for(Item it : nova.getItensSolicitacao()) {
				it.setSolicitacao(nova);
			}
			sdao.save(nova);
			return ResponseEntity.ok(nova);
			
		}
		catch(Exception ex) {
		return ResponseEntity.status(400).build();
	}

}
	@GetMapping("/solicitacoes/{id}")
	public ResponseEntity<Solicitacao> buscarPeloId(@PathVariable int id){
		Solicitacao solicit = sdao.findById(id).orElse(null);
		if(solicit != null) {
			solicit.getSolicitante().setSenha("*********");
			return ResponseEntity.ok(solicit);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
