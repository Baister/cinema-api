package com.Senai.Filmes.Controller;

<<<<<<< HEAD
import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
=======

import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.FilmesApplication;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import com.Senai.Filmes.Service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Tag(name = "Filmes", description = "Endpoints para gerenciamento de filmes")
@RequestMapping("/api/filmes")
@RestController
@CrossOrigin("*")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    @Operation(summary = "Listar filmes", description = "Lista todos os filmes cadastrados")
    public ResponseEntity<List<FilmeResponse>> listarTodos() {
        List<FilmeResponse> filmes = filmeService.listarTodos();
        if (filmes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar filme por ID", description = "Retorna os detalhes de um filme")
    public ResponseEntity<FilmeResponse> buscarPorId(@PathVariable UUID id) {
        return new ResponseEntity<>(filmeService.buscarPorId(id), HttpStatus.OK);
=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
<<<<<<< HEAD
    @Operation(summary = "Criar filme", description = "Cadastra um novo filme — somente ADMIN")
    public ResponseEntity<FilmeResponse> criar(@RequestBody FilmeRequest request) {
        return new ResponseEntity<>(filmeService.criar(request), HttpStatus.CREATED);
=======
    @Operation(summary = "Criar filme", description = "Retorna a criação de um filme.")
    public ResponseEntity<FilmeResponse> criarFilme(@RequestBody FilmeRequest filmeRequest){//É chamar o corpo do objeto
        return new ResponseEntity<>(filmeService.cadastrarFilme(filmeRequest), HttpStatus.CREATED);
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
<<<<<<< HEAD
    @Operation(summary = "Atualizar filme", description = "Atualiza os dados de um filme — somente ADMIN")
    public ResponseEntity<FilmeResponse> atualizar(@PathVariable UUID id, @RequestBody FilmeRequest request) {
        return new ResponseEntity<>(filmeService.atualizar(id, request), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/imagem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Upload de poster", description = "Faz upload ou substitui o poster do filme no S3 — somente ADMIN")
    public ResponseEntity<FilmeResponse> uploadImagem(
            @PathVariable UUID id,
            @RequestParam("imagem") MultipartFile imagem) {
        return new ResponseEntity<>(filmeService.uploadImagem(id, imagem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/imagem")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Remover poster", description = "Remove o poster do filme do S3 — somente ADMIN")
    public ResponseEntity<FilmeResponse> removerImagem(@PathVariable UUID id) {
        return new ResponseEntity<>(filmeService.removerImagem(id), HttpStatus.OK);
=======
    @Operation(summary = "Atualizar filme",description = "atualiza os dados de um filme")
    public ResponseEntity<FilmeResponse> atualizar(@PathVariable UUID id, @RequestBody FilmeRequest filmeRequest){
        return new ResponseEntity<>(filmeService.atualizarFilme(id, filmeRequest), HttpStatus.OK);
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
<<<<<<< HEAD
    @Operation(summary = "Deletar filme", description = "Remove um filme e seu poster do S3 — somente ADMIN")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        filmeService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
=======
    @Operation(summary = "Deletar filme", description = "deleta os dados de um filme por completo.")
    public ResponseEntity<FilmeResponse> deletar(@PathVariable UUID id){

        filmeService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
