package com.ucsal.reservalami.domain;

import java.util.List;
import java.util.Objects;

import com.ucsal.reservalami.controller.lami.NewLamiDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Lami {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String codigoSala;
	@Column(unique = true)
	private String numeroLami;
	private String descricao;
	private Integer qtdMaquinas;
	private Boolean ativo;
	@OneToMany(mappedBy = "lami") 
	private List<Reserva> reservas;
	

	public Lami() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lami(String codigoSala, String numeroLami, String descricao, Integer qtdMaquinas) {
		super();
		this.codigoSala = codigoSala;
		this.numeroLami = numeroLami;
		this.descricao = descricao;
		this.qtdMaquinas = qtdMaquinas;
		this.ativo = true;
	}

	public Lami(NewLamiDTO newLamiDTO) {
		this.codigoSala = newLamiDTO.codigoSala();
		this.numeroLami = newLamiDTO.numeroLami();
		this.descricao = newLamiDTO.descricao();
		this.qtdMaquinas = newLamiDTO.qtdMaquinas();
		this.ativo = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}

	public void setNumeroLami(String numeroLami) {
		this.numeroLami = numeroLami;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setQtdMaquinas(Integer qtdMaquinas) {
		this.qtdMaquinas = qtdMaquinas;
	}

	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lami other = (Lami) obj;
		return Objects.equals(id, other.id);
	}

}
