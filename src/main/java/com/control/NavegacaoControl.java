package com.control;

import com.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoControl {

    @Autowired
    LivrosRepository livrosRepository;

    @GetMapping("/")
    public String prateleira(){
        return "/index";
    }

    @GetMapping("/descobrir")
    public String descbrir(){
        return "/pages/descobrir";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "/pages/cadastrar";
    }

    @GetMapping("/livros/cadastrar")
    public String cadastrarLivro(){
        return "/pages/cadastroLivros";
    }
}
