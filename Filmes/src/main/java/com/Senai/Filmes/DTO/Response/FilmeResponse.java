package com.Senai.Filmes.DTO.Response;

import java.util.UUID;

public record FilmeResponse(
        UUID id,
        String titulo,
        String descricao,
        String urlPoster,
        String genero,
        Integer duracaoMinutos
) {
}
