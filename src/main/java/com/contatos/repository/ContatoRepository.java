package com.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.contatos.models.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
