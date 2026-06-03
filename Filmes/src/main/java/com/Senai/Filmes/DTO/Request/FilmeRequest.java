package com.Senai.Filmes.DTO.Request;

import com.Senai.Filmes.Model.Enums.GeneroFilme;

import java.util.UUID;

public record FilmeRequest(
        UUID uuid,
        String titulo,
        String descricao,
        String urlPoster,
        GeneroFilme genero,
        Integer duracaoMinutos
) { }
