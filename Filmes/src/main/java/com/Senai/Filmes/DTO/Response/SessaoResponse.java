package com.Senai.Filmes.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SessaoResponse(
<<<<<<< HEAD
        UUID id,
        FilmeResponse filme,
        SalaResponse sala,
        LocalDateTime inicio,
        LocalDateTime fim,
        BigDecimal preco
) {}
=======
        UUID salaId,
        FilmeResponse filme,
        LocalDateTime inicio,
        LocalDateTime fim,
        BigDecimal preco
) {
}
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
