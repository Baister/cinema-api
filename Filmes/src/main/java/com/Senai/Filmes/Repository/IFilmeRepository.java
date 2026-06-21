package com.Senai.Filmes.Repository;
<<<<<<< HEAD
=======
//Sempre se começa pelo repositório
//Muito semelhante a DAO
//JPA precisa de Objeto UUID
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

import com.Senai.Filmes.Model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

<<<<<<< HEAD
@Repository
public interface IFilmeRepository extends JpaRepository<Filme, UUID> {
=======
@Repository //Precisa de uma notation chamada repository
public interface IFilmeRepository extends JpaRepository<Filme, UUID> {

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
