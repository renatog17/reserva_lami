package com.ucsal.reservalami.controller.reservante;

import jakarta.validation.constraints.NotNull;

public record NewReservanteDTO(
		String matricula,
		@NotNull
		String cpf,
		@NotNull
		String password) {

}
