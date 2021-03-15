package com.control;

import com.model.RelLivrosUsuariosModel;
import com.repository.LivrosRepository;
import com.repository.RelLivrosUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/prateleira")
public class PrateleiraControl {
    @Autowired
    private RelLivrosUsuariosRepository rlur;
    @Autowired
    private LivrosRepository lr;

    @GetMapping("/all")
    public List<Object> buscar(HttpServletRequest request){
        Integer id_user = Integer.parseInt(String.valueOf(request.getSession().getAttribute("id_user")));
        List<Object> livros = lr.allLivrosDoUsuario(id_user);

        return livros;
    }

    @GetMapping("/maisInformacoes")
    public Object maisInformacoes(HttpServletRequest request, @RequestParam("id_rel") Integer id_rel) {

        Object livro = rlur.livroVinculadoRelacionamento(id_rel);

        return livro;
    }

    @GetMapping("/mudarEstado")
    public Object mudarEstado(@RequestParam("id_rel") Long id_rel, @RequestParam("estado") String estado) {
        RelLivrosUsuariosModel rlum = rlur.getOne(id_rel);
        rlum.setEstado(estado);
        rlur.save(rlum);

        return ResponseEntity.ok("Estado atualizado");
    }

    @PostMapping("/removerLivro")
    public Object removerLivro(@RequestParam("id_rel") String id_rel) {

        rlur.deleteById(Long.valueOf(id_rel));

        return ResponseEntity.ok("Sucesso ao remover");
    }
}
