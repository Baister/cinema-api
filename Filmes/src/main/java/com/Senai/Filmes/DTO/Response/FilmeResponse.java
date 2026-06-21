package com.Senai.Filmes.DTO.Response;

<<<<<<< HEAD
import com.Senai.Filmes.Model.Enums.GeneroFilme;

=======
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
import java.util.UUID;

public record FilmeResponse(
        UUID id,
        String titulo,
        String descricao,
        String urlPoster,
<<<<<<< HEAD
        GeneroFilme genero,
        Integer duracaoMinutos
) {}
=======
        com.Senai.Filmes.Model.Enums.@jakarta.validation.constraints.NotNull(message = "O campo genero é obrigatório!") GeneroFilme genero,
        Integer duracaoMinutos
) {
}
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
