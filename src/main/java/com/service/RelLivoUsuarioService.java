package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelLivoUsuarioService {

    @Autowired
    private RelLivoUsuarioService relLivoUsuarioService;

    public List<RelLivoUsuarioService> findAll() {
        return relLivoUsuarioService.findAll();
    }
}
