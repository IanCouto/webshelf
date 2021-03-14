package com.control;

import com.model.UsuarioModel;
import com.repository.UsuariosRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CadastrarControl {
    private UsuarioModel usuario;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<?> cadastrarUsuario(HttpServletRequest request,@RequestParam("dados") JSONObject dados) throws JSONException {
        String id = dados.getString("id_user");
        String msg;
        //Usuário já existente
        if(!id.equals("")){
            usuario = usuariosRepository.procurarUsuarioPorID(id);
            msg = "Dados atualizados";
        }else{
            usuario = new UsuarioModel();
            usuario.set_admin(false);
            msg = "Cadastro feito";
        }

        //Caso a senha foi mudada
        if(!dados.getString("senha_user").equals(""))
            usuario.setSenha(dados.getString("senha_user"));

        usuario.setNome(dados.getString("nome_user"));
        usuario.setEmail(dados.getString("email_user"));

        String[] result = dados.getString("dt_user").split("/");
        String dataFormatada = result[2] + '-' + result[1] + '-' + result[0];
        usuario.setDt_nascimento(dataFormatada);
        usuariosRepository.save(usuario);

        Map<String, Object> resultado = new HashMap<String,Object>();
        resultado.put("msg",msg);
        return new ResponseEntity<Map<String,Object>>(resultado, HttpStatus.OK);
    }
}
