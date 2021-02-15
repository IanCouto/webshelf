package com.br.control;

import com.br.model.LivroModel;
import com.br.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroControl {

    @Autowired
    private LivroService service;

    @GetMapping("/livros")
    public List<LivroModel> recuperarTodos() {
        return service.recuperarTodos();
    }
}
