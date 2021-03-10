package com.control;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.ManagedBean;
import java.text.ParseException;

@Getter
@Setter
@ManagedBean("cadastrarControl")
public class CadastrarControl {
    private UsuarioModel usuario = new UsuarioModel();

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public String cadastrarUsuario() throws ParseException {
        String[] result = usuario.getDt_nascimento().split("/");
        String dataFormatada = result[2] + '-' + result[1] + '-' + result[0];
        usuario.setDt_nascimento(dataFormatada);
        usuario.set_admin(false);
        usuariosRepository.save(usuario);

        return "Usuário cadastrado";
    }
}
