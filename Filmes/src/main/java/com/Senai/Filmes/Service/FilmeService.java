package com.Senai.Filmes.Service;

<<<<<<< HEAD
=======
//Parte dois do Repository

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.Model.Filme;
import com.Senai.Filmes.Repository.IFilmeRepository;
import jakarta.persistence.EntityNotFoundException;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
=======
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

import java.util.List;
import java.util.UUID;

<<<<<<< HEAD
@Service
public class FilmeService {

    @Autowired
    private IFilmeRepository filmeRepository;

    @Autowired
    private S3Service s3Service;

    public List<FilmeResponse> listarTodos() {
        return filmeRepository.findAll().stream().map(this::toResponse).toList();
    }

    public FilmeResponse buscarPorId(UUID id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
        return toResponse(filme);
    }

    public FilmeResponse criar(FilmeRequest request) {
        Filme filme = new Filme();
        filme.setTitulo(request.titulo());
        filme.setDescricao(request.descricao());
        filme.setGenero(request.genero());
        filme.setDuracaoMinutos(request.duracaoMinutos());
        return toResponse(filmeRepository.save(filme));
    }

    public FilmeResponse atualizar(UUID id, FilmeRequest request) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

        filme.setTitulo(request.titulo());
        filme.setDescricao(request.descricao());
=======

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
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
        filme.setGenero(request.genero());
        filme.setDuracaoMinutos(request.duracaoMinutos());

        return toResponse(filmeRepository.save(filme));
    }

<<<<<<< HEAD
    public FilmeResponse uploadImagem(UUID id, MultipartFile imagem) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

        s3Service.deletar(filme.getUrlPoster());
        filme.setUrlPoster(s3Service.upload(imagem));

        return toResponse(filmeRepository.save(filme));
    }

    public FilmeResponse removerImagem(UUID id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));

        s3Service.deletar(filme.getUrlPoster());
        filme.setUrlPoster(null);

        return toResponse(filmeRepository.save(filme));
    }

    public void deletar(UUID id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado"));
        s3Service.deletar(filme.getUrlPoster());
        filmeRepository.delete(filme);
    }

    private FilmeResponse toResponse(Filme filme) {
=======

    private FilmeResponse toResponse(Filme filme){
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
        return new FilmeResponse(
                filme.getId(),
                filme.getTitulo(),
                filme.getDescricao(),
                filme.getUrlPoster(),
                filme.getGenero(),
                filme.getDuracaoMinutos()
        );
    }
<<<<<<< HEAD
=======

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


>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
