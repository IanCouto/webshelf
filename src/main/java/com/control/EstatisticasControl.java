package com.control;

import com.repository.LivrosRepository;
import com.repository.RelLivrosUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EstatisticasControl {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping("/consultar")
    public HashMap<String, Object> consultar(HttpServletRequest request){
        HashMap<String, Object> consulta = new HashMap<>();
        consulta.put("livros", livrosRepository.countAllLivros());
        consulta.put("usuarios", livrosRepository.countAllUsuarios());
        consulta.put("relacionamentos", livrosRepository.countAllRelacionamentos());
        return consulta;
    }
}
