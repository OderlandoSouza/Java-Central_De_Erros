package br.com.codenation.evento.dto;


import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class EventoDTO {

    private Long id;
    private String descricao;
    private Long quantidade;
    private ErrorLevel errorLevel;
    private LocalDateTime data;
    private String origem;

    public static List<EventoDTO> converter(List<Evento> topicos) {
        return topicos.stream().map(EventoDTO::new).collect(Collectors.toList());
    }


    public EventoDTO (Evento evento){
        this.id = evento.getId();
        this.descricao = evento.getDescricao();
        this.quantidade = evento.getQuantidade();
        this.errorLevel = evento.getErrorLevel();
        this.data = evento.getDataCriacao();
        this.origem = evento.getOrigem();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public ErrorLevel getErrorLevel() { return errorLevel; }

    public LocalDateTime getData() {
        return data;
    }

    public String getOrigem() {
        return origem;
    }
}

