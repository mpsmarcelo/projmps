package com.project.mps.projmps.repository;

import com.project.mps.projmps.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Marcelo on 29/08/2019.
 */
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
}
