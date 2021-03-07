package com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoControl {
    @GetMapping("/")
    public String prateleira(){
        return "/index";
    }

    @GetMapping("/livros/cadastrar")
    public String cadastrarLivro(){
        return "/pages/cadastroLivros";
    }
}
