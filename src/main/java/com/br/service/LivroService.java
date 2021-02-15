package com.br.service;

import com.br.dao.LivroDao;
import com.br.model.LivroModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private LivroDao dao;

    public List<LivroModel> recuperarTodos() {
        return dao.findAll();
    }
}
