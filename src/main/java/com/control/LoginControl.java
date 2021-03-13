package com.control;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@Getter @Setter
@Controller
@ViewScoped
@ManagedBean("loginControl")
public class LoginControl {

    private UsuarioModel usuario = new UsuarioModel();

    @Inject
    private UsuariosRepository usuariosRepository;

    @PostMapping("/efetuaLogin")
    public String efetuaLogin(HttpServletRequest request,@RequestParam("form:nome") String nome,@RequestParam("form:senha") String senha) {
        UsuarioModel u = usuariosRepository.procurarUsuario(nome,senha);
        if(u!=null){
            request.getSession().setAttribute("erro","");
            request.getSession().setAttribute("id_user",u.getId());
            request.getSession().setAttribute("name_user",u.getNome());
            request.getSession().setAttribute("is_admin",u.is_admin());
            return "/index";
        }else{
            request.getSession().setAttribute("erro","Usuário ou senha incorretos");
            return "/pages/login";
        }


    }
}
