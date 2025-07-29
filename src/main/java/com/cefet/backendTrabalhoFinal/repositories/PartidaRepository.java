package com.cefet.backendTrabalhoFinal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    
}

