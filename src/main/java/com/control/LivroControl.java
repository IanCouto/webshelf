package com.control;

import com.model.LivroModel;
import com.repository.LivrosRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControl {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping
    public List<LivroModel> recuperarTodos() {
        return livrosRepository.findAll();
    }

    @GetMapping("/all")
    public Object mostrarTodos() throws IOException {
        List<LivroModel> livros = livrosRepository.findAll();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livros)
                .toUri();

        return ResponseEntity.created(uri).body(livros);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object cadastrar(@RequestParam("file") MultipartFile file, @RequestParam("dados") JSONObject dadosLivro) throws JSONException {
        LivroModel livro = new LivroModel();

        String typeFile ="";
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            byte[] encoded = Base64.getEncoder().encode(bytes);

            livro.setTitulo(dadosLivro.getString("titulo"));
            livro.setResumo(dadosLivro.getString("resumo"));
            livro.setAutor(dadosLivro.getString("autor"));
            livro.setEditora(dadosLivro.getString("editora"));
            livro.setNumero_paginas( dadosLivro.getInt("numero_paginas"));
            livro.setGeneros(dadosLivro.getJSONObject("generos").toString());
            livro.setImg_base64(new String(encoded));

            LivroModel livroCriado =  livrosRepository.save(livro);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(livroCriado.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(livroCriado);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
