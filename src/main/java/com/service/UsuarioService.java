package com.service;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuarioModel findByNome(String nome){
        UsuarioModel usuario = usuariosRepository.findByNome(nome);
        return usuario;
    }

    public Collection<UsuarioModel> findAllActiveUsersNative(){
        return usuariosRepository.findAllActiveUsersNative();
    }
}
