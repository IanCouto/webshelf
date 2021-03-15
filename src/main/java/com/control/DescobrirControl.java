package com.control;

import com.model.RelLivrosUsuariosModel;
import com.repository.RelLivrosUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/descobrir")
public class DescobrirControl {

    @Autowired
    private RelLivrosUsuariosRepository rlur;


    @GetMapping("/buscar")
    public List<Object> buscar(HttpServletRequest request){
        Integer id_user = Integer.parseInt(String.valueOf(request.getSession().getAttribute("id_user")));
        List<Object> livros = rlur.relAllLivrosPorUsuario(id_user);

        return livros;
    }


    @PostMapping("/addLivro")
    public Object addLivro(HttpServletRequest request, @RequestParam("id_livro") String id_livro) throws IOException {
        RelLivrosUsuariosModel rlum = new RelLivrosUsuariosModel();

        rlum.setId_livro(Long.parseLong(id_livro));
        Long id_user = Long.parseLong(String.valueOf(request.getSession().getAttribute("id_user")));
        rlum.setId_usuario(id_user);
        rlum.setEstado("PARA_LER");

        rlur.save(rlum);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rlum)
                .toUri();

        return ResponseEntity.created(uri).body(rlum);
    }

    @PostMapping("/removerLivro")
    public Object removerLivro(@RequestParam("id_rel") String id_rel) {
        rlur.deleteById(Long.valueOf(id_rel));
        return ResponseEntity.ok("Sucesso ao remover");
    }

}
