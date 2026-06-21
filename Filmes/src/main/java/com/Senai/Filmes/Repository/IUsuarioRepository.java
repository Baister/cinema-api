package com.Senai.Filmes.Repository;

<<<<<<< HEAD
=======

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import com.Senai.Filmes.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
<<<<<<< HEAD
=======


>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
