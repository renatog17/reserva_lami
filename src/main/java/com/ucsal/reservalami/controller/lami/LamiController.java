package com.ucsal.reservalami.controller.lami;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ucsal.reservalami.domain.Lami;
import com.ucsal.reservalami.repositories.LamiRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("/lami")
@RestController
public class LamiController {

	@Autowired
	LamiRepository lamiRepository;
	
	@PostMapping
	ResponseEntity<?> cadastrarLami(@RequestBody @Valid NewLamiDTO newLamiDTO, UriComponentsBuilder uriComponentsBuilder){
		Lami lami = new Lami(newLamiDTO);
		lamiRepository.save(lami);
		URI uri = uriComponentsBuilder.path("/lami/{id}").buildAndExpand(lami.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PatchMapping("desativar")
	@Transactional
	ResponseEntity<?> desativarLami(@RequestParam Long id){
		Lami lami = lamiRepository.getReferenceById(id);
		lami.setAtivo(false);
		return ResponseEntity.accepted().build();
	}
	
	@PatchMapping("ativar")
	@Transactional
	ResponseEntity<?> ativarLami(@RequestParam Long id){
		Lami lami = lamiRepository.getReferenceById(id);
		lami.setAtivo(true);
		return ResponseEntity.accepted().build();
	}
}
