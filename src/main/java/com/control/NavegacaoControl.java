package com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NavegacaoControl {

    @GetMapping("/")
    public String login(){
        return "/pages/login";
    }

    @GetMapping("/prateleira")
    public String prateleira(){
        return "/index";
    }

    @GetMapping("/descobrir")
    public String descobrir(){
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

    @GetMapping("/sair")
    public String sair(HttpServletRequest request){
        request.getSession().invalidate();
        return "/pages/login";
    }
}
