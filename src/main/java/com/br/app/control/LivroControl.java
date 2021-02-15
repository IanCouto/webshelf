package com.br.app.control;

import com.br.app.model.LivroModel;
import com.br.app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControl {

    @Autowired
    private LivroRepository repositorio;

    @GetMapping
    public List<LivroModel> recuperarTodos() {
        return repositorio.findAll();
    }
}
