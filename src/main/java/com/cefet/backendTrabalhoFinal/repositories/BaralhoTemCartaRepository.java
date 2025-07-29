package com.cefet.backendTrabalhoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.BaralhoTemCarta;
import com.cefet.backendTrabalhoFinal.entities.keys.BaralhoTemCartaKey;

public interface BaralhoTemCartaRepository extends JpaRepository<BaralhoTemCarta, BaralhoTemCartaKey> {
    
}
