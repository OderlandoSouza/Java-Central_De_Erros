package br.com.codenation.evento.controller;


import br.com.codenation.evento.dto.EventoDTO;
import br.com.codenation.evento.form.AtualizacaoEventoForm;
import br.com.codenation.evento.model.ErrorLevel;
import br.com.codenation.evento.model.Evento;
import br.com.codenation.evento.repository.EventoRepository;
import br.com.codenation.evento.service.EventoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;
    List<EventoDTO> eventoDTO;

    @Autowired
    private EventoRepository eventoRepository;


    @PostMapping
    @ApiOperation("Cria um novo evento de erro")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento criado com sucesso")})
    public ResponseEntity<Evento> create(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEventoForm form) {
        Optional<Evento> optional = eventoService.findById(id);
        if (optional.isPresent()) {
            Evento evento = form.atualizar(id, eventoRepository);
            return ResponseEntity.ok(new EventoDTO(evento));
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping
    @ApiOperation("Lista todos os eventos de erros")
    public List<EventoDTO> lista() {
        List<Evento> evento = eventoService.findAll();
        return EventoDTO.converter(evento);
    }


    @GetMapping("/{id}")
    @ApiOperation("Busca um evento pelo Id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "Evento localizado")})
    public ResponseEntity<Evento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Evento>(this.eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um evento")
    public void delete(@PathVariable("id") Long id) {
        this.eventoService.deleteById(id);
    }

    @GetMapping("byErrorLevel/{level}")
    @ApiOperation("Lista eventos de erros pelo nível do erro (ERROR, WARNING, INFO)")
    public List<Evento> findByErrorLevel(@PathVariable("level") ErrorLevel level, Pageable pageable) {
        return this.eventoService.findByErrorLevel(level, pageable);
    }


}