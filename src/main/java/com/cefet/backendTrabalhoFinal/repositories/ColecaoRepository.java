package com.cefet.backendTrabalhoFinal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.Colecao;

public interface ColecaoRepository extends JpaRepository<Colecao, Long> {
    Optional<Colecao> findByJogoId(Long jogoId);
}
