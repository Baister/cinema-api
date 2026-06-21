package com.Senai.Filmes.Repository;

<<<<<<< HEAD
import com.Senai.Filmes.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, UUID> {
    List<Reserva> findByUsuarioId(UUID usuarioId);
=======
import com.Senai.Filmes.Model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.UUID;

@Repository
public interface IReservaRepository extends JpaRepository<Reservas, UUID> {
    List<Reservas> findByUsuarioId(UUID usuarioId);
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
