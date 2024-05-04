package com.ucsal.reservalami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsal.reservalami.domain.Lami;

public interface LamiRepository extends JpaRepository<Lami, Long> {

}
