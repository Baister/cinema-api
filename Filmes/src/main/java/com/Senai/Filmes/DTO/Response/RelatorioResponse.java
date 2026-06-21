package com.Senai.Filmes.DTO.Response;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.List;
=======
import java.util.List;
import java.math.BigDecimal;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

public record RelatorioResponse(
        long totalReservas,
        BigDecimal totalReceita,
        List<FilmeTotais> filmes
<<<<<<< HEAD
) {
    public record FilmeTotais(String nomeFilme, long totalReservas) {}
=======

) {
    public record FilmeTotais(String nomeFilme, long totalReservas){}
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
