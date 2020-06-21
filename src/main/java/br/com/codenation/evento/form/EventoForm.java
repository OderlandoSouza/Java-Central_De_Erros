package br.com.codenation.evento.form;

import br.com.codenation.evento.model.ErrorLevel;

public class EventoForm {

    private String descricao;
    private String log;
    private String origem;
    private Long quantidade;
    private ErrorLevel errorLevel;



    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public ErrorLevel getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(ErrorLevel errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }


}
