package com.project.mps.projmps.resourse;

import com.project.mps.projmps.event.RecursoCriadoEvent;
import com.project.mps.projmps.model.Categoria;
import com.project.mps.projmps.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marcelo on 07/05/2019.
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaResourse {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Categoria> listar(){
     return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public Categoria buscarCategoriaPeloCodigo(@PathVariable Long codigo){
       Optional<Categoria> categoria =  categoriaRepository.findById(codigo);
       return categoria.orElseThrow(() -> new IllegalStateException("Categoria não encontrada"));
    }


}
