package br.com.codenation.evento.repository;


import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);

    List<Evento> findAll();

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    List<Evento> findByErrorLevel(ErrorLevel errorLevel, Pageable pageable);



}