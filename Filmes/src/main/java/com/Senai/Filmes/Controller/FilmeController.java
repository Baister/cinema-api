package com.Senai.Filmes.Controller;


import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.FilmesApplication;
import com.Senai.Filmes.Service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import java.util.List;

@Tag(name = "Filmes", description = "Endpoint para gerenciamento dos filmes do cinema")
@RestController
@CrossOrigin("*") // É o acesso do externo, do pessoal de outras redes que vai acessar essa API. No momento você tá permitindo todo mundo acessar
@RequestMapping("/api/filmes") //Porque isso vai ser uma rota que os dados vão acessar a partir desse controller
public class FilmeController {

    @Autowired // Injeção de dependência
    private FilmeService filmeService;

    @GetMapping // A ROTA DELE SERÁ DE GET
    @Operation(summary = "Listar filmes", description = "Ele lista todos os filmes disponíveis dentro do banco")
    public ResponseEntity<List<FilmeResponse>> listarTodos(){ // isso já é um método acessível no swagger
        List<FilmeResponse> filmes = filmeService.listarTodos();
        if(filmes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmes, HttpStatus.OK);

    }

    @GetMapping("/{id}") // Esse é para ter outro get que precisa de id
    @Operation(summary = "Buscar filme por ID", description = "Retorna os detalhes de um único filme")
    public ResponseEntity<FilmeResponse> buscarPorId(@PathVariable UUID id){
//        FilmeResponse filmeResponse = filmeService.buscarPorFilmeId(id);
//
//        return ResponseEntity.ok(filmeResponse);

        return new ResponseEntity<>(filmeService.buscarPorFilmeId(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Criar filme", description = "Retorna a criação de um filme.")
    public ResponseEntity<FilmeResponse> criarFilme(@RequestBody FilmeRequest filmeRequest){//É chamar o corpo do objeto
        return new ResponseEntity<>(filmeService.cadastrarFilme(filmeRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar filme",description = "atualiza os dados de um filme")
    public ResponseEntity<FilmeResponse> atualizar(@PathVariable UUID id, @RequestBody FilmeRequest filmeRequest){
        return new ResponseEntity<>(filmeService.atualizarFilme(id, filmeRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar filme", description = "deleta os dados de um filme por completo.")
    public ResponseEntity<FilmeResponse> deletar(@PathVariable UUID id){

        filmeService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}

