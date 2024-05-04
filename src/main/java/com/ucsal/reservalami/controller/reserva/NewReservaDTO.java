package com.ucsal.reservalami.controller.reserva;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;

public record NewReservaDTO(
		@FutureOrPresent
		LocalDateTime horaEDia,
		Long lami_id
) {

}
