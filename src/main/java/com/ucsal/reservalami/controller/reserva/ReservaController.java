package com.ucsal.reservalami.controller.reserva;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ucsal.reservalami.domain.Lami;
import com.ucsal.reservalami.domain.Reserva;
import com.ucsal.reservalami.domain.Reservante;
import com.ucsal.reservalami.repositories.LamiRepository;
import com.ucsal.reservalami.repositories.ReservaRepository;
import com.ucsal.reservalami.repositories.ReservanteRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservanteRepository reservanteRepository;
	@Autowired
	LamiRepository lamiRepository;
	@Autowired
	ReservaRepository reservaRepository;
	
	@PostMapping
	ResponseEntity<?> realizarReserva(@RequestBody NewReservaDTO newReservaDTO, UriComponentsBuilder uriComponentsBuilder){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Reservante reservante = reservanteRepository.getReferenceByCpf(authentication.getName()).get();
		Lami lami = lamiRepository.getReferenceById(newReservaDTO.lami_id());
		
		Reserva reserva = new Reserva(newReservaDTO.horaEDia(), reservante, lami);
		reservaRepository.save(reserva);
		
		URI uri = uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reserva.getId()).toUri();
		//fazer verificações de conflito.
		//conflito com outras reservas
		//horario de funcionamento
		//imprevisto (feriado, manutencao)
		return ResponseEntity.created(uri).build();
	}
}
