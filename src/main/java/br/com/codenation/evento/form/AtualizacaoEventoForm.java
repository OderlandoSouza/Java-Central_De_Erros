package br.com.codenation.evento.form;

import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.repository.EventoRepository;


public class AtualizacaoEventoForm {

    private String descricao;
    private String log;
    private String origem;
    private ErrorLevel errorLevel;


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


    public Evento atualizar(Long id, EventoRepository eventoRepository) {
        Evento evento = eventoRepository.getOne(id);

        evento.setDescricao(this.descricao);
        evento.setLog(this.log);
        evento.setOrigem(this.origem);
        evento.setErrorLevel(this.errorLevel);

        return evento;
    }
}


