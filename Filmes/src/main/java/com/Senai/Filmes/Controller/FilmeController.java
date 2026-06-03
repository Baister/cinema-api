package com.Senai.Filmes.Controller;


import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.Service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import java.util.List;

@RestController
@CrossOrigin("*") // É o acesso do externo, do pessoal de outras redes que vai acessar essa API. No momento você tá permitindo todo mundo acessar
@RequestMapping("/api/filmes") //Porque isso vai ser uma rota que os dados vão acessar a partir desse controller
public class FilmeController {

    @Autowired // Injeção de dependência
    private FilmeService filmeService;

    @GetMapping // A ROTA DELE SERÁ DE GET
    public ResponseEntity<List<FilmeResponse>> listarTodos(){ // isso já é um método acessível no swagger
        List<FilmeResponse> filmes = filmeService.listarTodos();
        if(filmes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmes, HttpStatus.OK);

    }

    @GetMapping("/{id}") // Esse é para ter outro get que precisa de id
    public ResponseEntity<FilmeResponse> buscarPorId(PathVariable UUID){
        return new ResponseEntity<>(UUID, HttpStatus.OK);
    } 
}
