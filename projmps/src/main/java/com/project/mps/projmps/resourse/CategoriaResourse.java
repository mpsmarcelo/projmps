package com.project.mps.projmps.resourse;

import com.project.mps.projmps.model.Categoria;
import com.project.mps.projmps.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcelo on 07/05/2019.
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaResourse {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    List<Categoria> listar(){
     return categoriaRepository.findAll();
    }
}
