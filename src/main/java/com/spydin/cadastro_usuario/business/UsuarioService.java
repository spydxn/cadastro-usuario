package com.spydin.cadastro_usuario.business;

import com.spydin.cadastro_usuario.infrastructure.entitys.Usuario;
import com.spydin.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service  //classe de serviço
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);  //Fecha a conexão com o banco de dados
    }

    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        ); //a partir do .orElse... é usado pois utilizei o optional no UsuarioRepository
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()  //procurar converted para estudar
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())  //se ele estiver presente pega do usuario.getEmail. o : é senão... então senão ele pega do usuarioEntity.getEmail() //se ele for diferente de nulo "?"
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
