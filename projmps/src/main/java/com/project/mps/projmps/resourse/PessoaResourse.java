package com.project.mps.projmps.resourse;

import com.project.mps.projmps.model.Pessoa;
import com.project.mps.projmps.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marcelo on 29/08/2019.
 */

@RestController
@RequestMapping("/pessoa")
public class PessoaResourse {
     @Autowired
     PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> buscarPessoa(){
        return pessoaRepository.findAll();
    }

    @GetMapping("{/codigo}")
    public Pessoa buscarPessoaId(@PathVariable Long codigo){
        Optional<Pessoa> buscarIdPessoa = pessoaRepository.findById(codigo);
        return buscarIdPessoa.orElseThrow(() -> new IllegalStateException("Pessoa não encontrada"));
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa, HttpServletResponse response){
         Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(pessoaSalva.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(pessoaSalva);
    }



}
