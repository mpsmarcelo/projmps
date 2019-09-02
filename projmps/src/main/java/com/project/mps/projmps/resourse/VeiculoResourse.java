package com.project.mps.projmps.resourse;

import com.project.mps.projmps.model.Veiculo;
import com.project.mps.projmps.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marcelo on 31/08/2019.
 */
@RestController
@RequestMapping("/veiculo")
public class VeiculoResourse{

    @Autowired
    VeiculoRepository veiculoRepository;



    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }

    @GetMapping("{/codigo}")
    public Veiculo listarVeiculoId(@PathVariable Long codigo){
        Optional<Veiculo> listarVeiculo = veiculoRepository.findById(codigo);
        return listarVeiculo.orElseThrow(() -> new IllegalStateException("Veiculo não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Veiculo> salvar (@RequestBody Veiculo veiculo, HttpServletResponse response){
        Veiculo salvarVeiculo = veiculoRepository.save(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(salvarVeiculo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(salvarVeiculo);

    }
}
