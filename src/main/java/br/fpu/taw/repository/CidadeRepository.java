package br.fpu.taw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fpu.taw.model.Cidade;

public interface CidadeRepository extends JpaRepository <Cidade, String>{

}
