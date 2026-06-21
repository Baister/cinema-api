package com.Senai.Filmes.DTO.Request;

import com.Senai.Filmes.Model.Enums.GeneroFilme;

<<<<<<< HEAD
public record FilmeRequest(
        String titulo,
        String descricao,
        GeneroFilme genero,
        Integer duracaoMinutos
) {}
=======
import java.util.UUID;

public record FilmeRequest(
        UUID uuid,
        String titulo,
        String descricao,
        String urlPoster,
        GeneroFilme genero,
        Integer duracaoMinutos
) { }
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
