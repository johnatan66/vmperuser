package com.johncorp.vmperuser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tbl_solicitacao")
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_solicitacao")
	private int numSolicitacao;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy") // formatando a data, tanto na entrada quanto na saida 
	private Date data;
	
	@Column(name="observacoes", length=200)
	private String observacoes;
	
	//um usuario realizando muitas solicitações
	// referencia que tem um solicitante em usuario
	// caminho de volta, varias solicitações para um usuario
	@ManyToOne
	@JsonIgnoreProperties("pedidos") // pega o dono do pedido e ignora os demais pedidos desse usuario
	private usuario solicitante;
	
	
	public usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(usuario solicitante) {
		this.solicitante = solicitante;
	}
	public int getNumSolicitacao() {
		return numSolicitacao;
	}
	public void setNumSolicitacao(int numSolicitacao) {
		this.numSolicitacao = numSolicitacao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	

}
