package com.cefet.backendTrabalhoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.backendTrabalhoFinal.entities.Texto;
import com.cefet.backendTrabalhoFinal.entities.keys.TextoKey;

public interface TextoRepository extends JpaRepository<Texto, TextoKey> {

}
