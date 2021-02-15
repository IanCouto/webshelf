package com.br.app.service;

import com.br.app.repository.LivroRepository;
import com.br.app.model.LivroModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroRepository dao;

    public List<LivroModel> recuperarTodos() {
        return dao.findAll();
    }
}
