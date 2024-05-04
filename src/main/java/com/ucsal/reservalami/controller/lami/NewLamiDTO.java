package com.ucsal.reservalami.controller.lami;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record NewLamiDTO(
		@NotEmpty
		String codigoSala,
		@NotEmpty
		String numeroLami,
		@NotEmpty
		String descricao,
		@Positive
		Integer qtdMaquinas
) {

}
