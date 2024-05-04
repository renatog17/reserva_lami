package com.ucsal.reservalami.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsal.reservalami.domain.Reservante;

public interface ReservanteRepository extends JpaRepository<Reservante, Long> {

	Optional<Reservante> getReferenceByCpf(String cpf);
}
