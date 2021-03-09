package com.control;

import com.model.UsuarioModel;
import com.service.UsuarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@Getter @Setter
@ViewScoped
@ManagedBean("loginControl")
public class LoginControl {

    private UsuarioModel usuario = new UsuarioModel();

    @Inject
    private UsuarioService usuarioService;

    @GetMapping
    public String efetuaLogin() {
        System.out.println("teste");
        if(usuarioService.findByNome(usuario.getNome()) != null){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        return "index";
    }
}
