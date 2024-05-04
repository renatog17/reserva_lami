package com.ucsal.reservalami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsal.reservalami.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
