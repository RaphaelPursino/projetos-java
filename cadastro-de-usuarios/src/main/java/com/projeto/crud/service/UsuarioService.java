package com.projeto.crud.service;

import com.projeto.crud.model.Usuario;
import com.projeto.crud.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario atualizar(Long id, Usuario novoUsuario) {
        Usuario usuario = buscarPorId(id);

        if (usuario != null) {
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            return repository.save(usuario);
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
