package com.Senai.Filmes.Repository;
//Sempre se começa pelo repositório
//Muito semelhante a DAO
//JPA precisa de Objeto UUID

import com.Senai.Filmes.Model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //Precisa de uma notation chamada repository
public interface IFilmeRepository extends JpaRepository<Filme, UUID> {

}
