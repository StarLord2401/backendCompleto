package com.cefet.backendTrabalhoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {
   
}
