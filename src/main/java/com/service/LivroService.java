package com.service;

import com.model.LivroModel;
import com.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<LivroModel> findAll() {
        return livrosRepository.findAll();
    }
}
