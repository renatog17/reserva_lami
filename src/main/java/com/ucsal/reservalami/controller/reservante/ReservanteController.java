package com.ucsal.reservalami.controller.reservante;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ucsal.reservalami.domain.Reservante;
import com.ucsal.reservalami.repositories.ReservanteRepository;
import com.ucsal.reservalami.security.domain.User;
import com.ucsal.reservalami.security.domain.UserRole;
import com.ucsal.reservalami.security.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/reservante")
public class ReservanteController {

	@Autowired
	ReservanteRepository reservanteRepository;
	@Autowired
	UserRepository userRepository;
	
	@PostMapping
	@Transactional
	//olhar a questão de não deixar user ou reservante duplicado
	public ResponseEntity<?> cadastrarReservante(@RequestBody NewReservanteDTO newReservanteDTO, UriComponentsBuilder uriComponentsBuilder){
		String encryptedPassword = new BCryptPasswordEncoder().encode(newReservanteDTO.password());
		User user = new User(newReservanteDTO.cpf(), encryptedPassword, UserRole.USER);
		userRepository.save(user);
		Reservante reservante = new Reservante(newReservanteDTO);
		reservante.setUser(user);
		reservanteRepository.save(reservante);
		URI uri = uriComponentsBuilder.path("/reservante/{id}").buildAndExpand(reservante.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
