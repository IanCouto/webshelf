package com.control;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginControl {

    private UsuarioModel usuario = new UsuarioModel();

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/efetuaLogin")
    public String efetuaLogin(HttpServletRequest request,@RequestParam("form:nome") String nome,@RequestParam("form:senha") String senha) {
        UsuarioModel u = usuariosRepository.procurarUsuario(nome,senha);
        HttpSession session = request.getSession(true);
        if(u!=null){
            session.setAttribute("erro","");
            session.setAttribute("id_user",u.getId());
            session.setAttribute("nome_user",u.getNome());
            session.setAttribute("email_user",u.getEmail());
            session.setAttribute("dt_user",u.getDt_nascimento());
            session.setAttribute("is_admin",u.is_admin());
            return "redirect:/prateleira";
        }else{
            request.getSession().setAttribute("erro","Usuário ou senha incorretos");
            return "redirect:/";
        }


    }
}
