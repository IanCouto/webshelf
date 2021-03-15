package com.control;

import com.model.LivroModel;
import com.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacoesControl {

    @Autowired
    private LivrosRepository rlul;

    @GetMapping("/buscar")
    public List<LivroModel> buscar(HttpServletRequest request){
        List<LivroModel> livros = rlul.allLivrosDesaprovados();
        return livros;
    }

    @PostMapping("/aprovarLivro")
    public Object aprovarLivro(HttpServletRequest request, @RequestParam("id_livro") Long id_livro) throws IOException {
        LivroModel livro =  rlul.getOne(id_livro);
        livro.setIs_aprovado(true);
        rlul.save(livro);
        return  ResponseEntity.ok("Livro Aprovado");
    }

    @PostMapping("/removerLivro")
    public Object removerLivro(@RequestParam("id_livro") String id_livro) {
        rlul.deleteById(Long.valueOf(id_livro));
        return ResponseEntity.ok("Livro rejeitado");
    }

}
