package com.control;

import com.model.LivroModel;
import com.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControl {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroModel> recuperarTodos() {
        return livroService.findAll();
    }
}
