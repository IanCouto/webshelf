package com.control;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import lombok.Getter;
import lombok.Setter;
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
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public String efetuaLogin() {

        if(usuariosRepository.procurarUsuario(usuario.getNome())!=null ){
            return "/index";
        }else{
            return "/pages/login";
        }


    }
}
