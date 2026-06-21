package com.Senai.Filmes.Model;

<<<<<<< HEAD
import com.Senai.Filmes.Model.Enums.GeneroFilme;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "filmes")
=======

import com.Senai.Filmes.Model.Enums.GeneroFilme;
import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "Filmes")
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
<<<<<<< HEAD
    @EqualsAndHashCode.Include
=======
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    private UUID id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;
<<<<<<< HEAD

    private String urlPoster;

    @NotNull(message = "O gênero é obrigatório")
    @Enumerated(EnumType.STRING)
    private GeneroFilme genero;

    @NotNull(message = "A duração é obrigatória")
    @Min(value = 1, message = "A duração deve ser maior que 0")
    private Integer duracaoMinutos;
=======
    private String urlPoster;

    @NotNull(message = "O campo genero é obrigatório!")
    @Enumerated(EnumType.STRING)
    private GeneroFilme genero;

    @NotNull(message = "")
    @Min(value = 1, message = "A duração deve ser maior que 0")
    private Integer duracaoMinutos;

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
