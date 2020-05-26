package com.johncorp.vmperuser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_maquina")
public class Maquina {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "processador", length = 4)
	private int processador;
	
	@Column(name = "memoriaGB", length = 5)
	private int memoriaGB;
	
	@Column(name = "capacidadeHD", length = 10)
	private int capacidadeHD;
	
	@Column(name = "transferencia", length = 15)
	private int transferencia;
	
	@Column(name = "valor", length = 15)
	private Float valor;
	
	
	
	public void setCalcularValor(int processador, int memoriaGB, int capacidadeHD, int transferencia) {
		final float ValProcess = 1000.0f;
		final float ValMemo = 10.0f;
		final float ValCapa = 10.0f;
		final float ValTrans = 15.0f;
		
		this.valor = processador * ValProcess + memoriaGB * ValMemo + capacidadeHD * ValCapa + transferencia * ValTrans;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProcessador() {
		return processador;
	}

	public void setProcessador(int processador) {
		this.processador = processador;
	}

	public int getMemoriaGB() {
		return memoriaGB;
	}

	public void setMemoriaGB(int memoriaGB) {
		this.memoriaGB = memoriaGB;
	}

	public int getCapacidadeHD() {
		return capacidadeHD;
	}

	public void setCapacidadeHD(int capacidadeHD) {
		this.capacidadeHD = capacidadeHD;
	}

	public int getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(int transferencia) {
		this.transferencia = transferencia;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}	

}
