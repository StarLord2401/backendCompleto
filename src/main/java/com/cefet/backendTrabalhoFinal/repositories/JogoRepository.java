package com.cefet.backendTrabalhoFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
   Optional<Jogo> findByUsuarioId(Long id);
}
