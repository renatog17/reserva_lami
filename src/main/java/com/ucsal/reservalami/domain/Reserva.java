package com.ucsal.reservalami.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp horaEDiaInicio;
	private Timestamp horaEDiaTermino;
	@ManyToOne
	@JoinColumn(name = "reservante_id")
	private Reservante reservante;
	@ManyToOne
	@JoinColumn(name = "lami_id")
	private Lami lami;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(LocalDateTime horaEDia, Reservante reservante, Lami lami) {
		super();
		this.horaEDiaInicio = Timestamp.valueOf(horaEDia);
		this.reservante = reservante;
		this.lami = lami;
	}

	public Long getId() {
		return id;
	}

	public Timestamp getHoraEDiaInicio() {
		return horaEDiaInicio;
	}

	public Timestamp getHoraEDiaTermino() {
		return horaEDiaTermino;
	}

	public Reservante getReservante() {
		return reservante;
	}

	public Lami getLami() {
		return lami;
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
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

}
