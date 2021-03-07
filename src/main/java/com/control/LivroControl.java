package com.control;

import com.model.LivroModel;
import com.repository.LivrosRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroControl {

    @Value("${file.path.images}")
    private String UPLOADED_FOLDER;


    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping
    public List<LivroModel> recuperarTodos() {
        return livrosRepository.findAll();
    }

    @PostMapping
    public String cadastrar(@RequestParam("file") MultipartFile file, @RequestParam("dados") JSONObject dadosLivro) throws JSONException {


        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String typeFile = "." + FilenameUtils.getExtension(file.getOriginalFilename());
            Path path = Paths.get(UPLOADED_FOLDER + dadosLivro.getString("titulo") + typeFile );
            Files.write(path, bytes);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        LivroModel livro = new LivroModel();
        livro.setTitulo(dadosLivro.getString("titulo"));
        livro.setResumo(dadosLivro.getString("resumo"));
        livro.setAutor(dadosLivro.getString("autor"));
        livro.setEditora(dadosLivro.getString("editora"));
        livro.setNumero_paginas( dadosLivro.getInt("numero_paginas"));
        livro.setGeneros(dadosLivro.getJSONObject("generos").toString());

        livrosRepository.save(livro);

        return "Requisição realizada";
    }
}
