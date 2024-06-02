package com.ucsal.reservalami.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

@Service
public class ReservaService {

	public Boolean verificarDisponibilidadeHoraEDataReserva(Timestamp horaEData) {
		return true;
	}
}
