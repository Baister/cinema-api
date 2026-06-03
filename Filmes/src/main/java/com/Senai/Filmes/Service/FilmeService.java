package com.Senai.Filmes.Service;

//Parte dois do Repository

import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.Model.Filme;
import com.Senai.Filmes.Repository.IFilmeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class FilmeService {

    @Autowired // Isso é para usar de notation -> é autoinjetado!Ele que permite instanciar a classe com todos os métodos. Isso tudo já é o próprio construtor!
    private IFilmeRepository filmeRepository; // Isso é a instância da classe

    //CRUD
    //Primeiro é o listar todos
    public List<FilmeResponse> listarTodos(){
        return filmeRepository.findAll().stream().map(this::toResponse).toList();
    }



    //getByID BuscarporID
    public FilmeResponse buscarPorFilmeId(UUID id){
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

        return toResponse(filme);
    }


    //Create
    public FilmeResponse cadastrarFilme(FilmeRequest request){
        Filme filme = new Filme();
        filme.setTitulo(request.titulo());
        filme.setDescricao(request.descricao());
        filme.setUrlPoster(request.urlPoster());
        filme.setGenero(request.genero());
        filme.setDuracaoMinutos(request.duracaoMinutos());

        return toResponse(filmeRepository.save(filme));
    }


    private FilmeResponse toResponse(Filme filme){
        return new FilmeResponse(
                filme.getId(),
                filme.getTitulo(),
                filme.getDescricao(),
                filme.getUrlPoster(),
                filme.getGenero(),
                filme.getDuracaoMinutos()
        );
    }

    public FilmeResponse atualizarFilme(UUID id, FilmeRequest filmeRequest){
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum filme encontrado!"));

        filme.setTitulo(filmeRequest.titulo());
        filme.setDescricao(filmeRequest.descricao());
        filme.setUrlPoster(filmeRequest.urlPoster());
        filme.setGenero(filmeRequest.genero());
        filme.setDuracaoMinutos(filmeRequest.duracaoMinutos());

        return toResponse(filmeRepository.save(filme));
    }

    public void deletar(UUID id){
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum filme encontrado!"));

        filmeRepository.delete(filme);
    }


}
