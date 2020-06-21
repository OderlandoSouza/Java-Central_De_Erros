package br.com.codenation.evento.model;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank(message = "A descrição do evento não pode ser vazia")
    private String descricao;

    @NotNull
    private String log;

    @NotNull
    private String origem;

    @Min(0)
    @PositiveOrZero
    private Long quantidade;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private ErrorLevel errorLevel;



    public Evento(String descricao, String log, String origem, Long quantidade, ErrorLevel errorLevel) {
        this.descricao = descricao;
        this.log = log;
        this.origem = origem;
        this.quantidade = quantidade;
    }

    public void setErrorLevel(ErrorLevel errorLevel) {
        this.errorLevel = errorLevel;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Evento(String descricao) {
        this.descricao = descricao;
    }

    public Evento() {
        super();
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

    public ErrorLevel getErrorLevel() {
        return errorLevel;
    }

    public String getLog() {
        return log;
    }

    public String getOrigem() {
        return origem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}