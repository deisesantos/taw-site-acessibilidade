package br.fpu.taw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fpu.taw.model.Cadastro;

public interface CadastroRepository extends JpaRepository <Cadastro, String> {

}
