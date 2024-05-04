package com.ucsal.reservalami.domain;

import java.util.List;
import java.util.Objects;

import com.ucsal.reservalami.controller.reservante.NewReservanteDTO;
import com.ucsal.reservalami.security.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Reservante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String matricula;
	@OneToMany(mappedBy = "reservante")
	private List<Reserva> reservas;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Reservante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservante(String cpf, String matricula) {
		super();
		this.cpf = cpf;
		this.matricula = matricula;
	}

	public Reservante(NewReservanteDTO newReservanteDTO) {
		this.cpf = newReservanteDTO.cpf();
		this.matricula = newReservanteDTO.matricula();
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setUser(User user) {
		this.user = user;
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
		Reservante other = (Reservante) obj;
		return Objects.equals(id, other.id);
	}

}
