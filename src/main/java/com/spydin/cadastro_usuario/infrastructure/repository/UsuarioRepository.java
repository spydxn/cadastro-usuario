package com.spydin.cadastro_usuario.infrastructure.repository;

import com.spydin.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email); //é obrigado a criar uma exceção ou uma alternativa caso o email não exista

    @Transactional //caso dê algum erro, ele não pode deletar
    void deleteByEmail(String email);
}
