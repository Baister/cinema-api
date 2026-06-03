package com.Senai.Filmes.DTO.Response;

import java.util.List;
import java.math.BigDecimal;

public record RelatorioResponse(
        long totalReservas,
        BigDecimal totalReceita,
        List<FilmeTotais> filmes

) {
    public record FilmeTotais(String nomeFilme, long totalReservas){}
}
