package com.service;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<UsuarioModel> findAll() {
        return usuariosRepository.findAll();
    }
}
