package com.b2w.starwars.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "planeta")
public class PlanetaEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "uuid.hex")
	@GenericGenerator(name = "uuid.hex", strategy = "uuid.hex")
	@Id
	private String id;

	private String nome;

	private String clima;

	private String terreno;
	
	@Transient
	private long quantidadeFilmes;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public long getQuantidadeFilmes() {
		return quantidadeFilmes;
	}

	public void setQuantidadeFilmes(long quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}
	
	
}
