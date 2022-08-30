package com.evaluaciontecnica.servicio.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@Column(name="CodCliente",nullable=false)
	
	private String codCliente;

	@Column(name="NombreCompleto",nullable=false)
	
	private String nombreCompleto;
	
	@Column(name="NombreCorto",nullable=false)
	private String nombreCorto;
	
	@Column(name="Abreviatura",nullable=false)
	private String abreviatura;
	
	@Column(name="Ruc",nullable=false)
	private String ruc;
	
	@Column(name="Estado",nullable=false)
	private char estado;
	
	@Column(name="GrupoFacturacion",nullable=false)
	private String grupoFacturacion;
	
	@Column(name="InactivoDesde",nullable=false)
	private LocalDateTime inactivoDesde;
	
	@Column(name="CodigoSAP",nullable=false)
	private String codigoSAP;
	
	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getGrupoFacturacion() {
		return grupoFacturacion;
	}

	public void setGrupoFacturacion(String grupoFacturacion) {
		this.grupoFacturacion = grupoFacturacion;
	}

	public LocalDateTime getInactivoDesde() {
		return inactivoDesde;
	}

	public void setInactivoDesde(LocalDateTime inactivoDesde) {
		this.inactivoDesde = inactivoDesde;
	}

	public String getCodigoSAP() {
		return codigoSAP;
	}

	public void setCodigoSAP(String codigoSAP) {
		this.codigoSAP = codigoSAP;
	}
	

}
