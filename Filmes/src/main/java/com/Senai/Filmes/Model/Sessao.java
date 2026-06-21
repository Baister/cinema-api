package com.Senai.Filmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
<<<<<<< HEAD
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
=======
import lombok.Data;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

<<<<<<< HEAD
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "sessoes")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotNull(message = "O filme é obrigatório")
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @NotNull(message = "A sala é obrigatória")
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @NotNull(message = "O horário de início é obrigatório")
    private LocalDateTime inicio;

    @NotNull(message = "O horário de fim é obrigatório")
    private LocalDateTime fim;

=======

@Data
@Entity
@Table(name = "sessoes")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    @NotNull
    private Filme filme; //É da tabela de onde você vai pegar


    @ManyToOne
    @JoinColumn(name = "sala_id")
    @NotNull
    private Sala sala;

    @NotNull(message =  "O horário do início é obrigatório")
    private LocalDateTime inicio;

    @NotNull(message = "O horário do fim é obrigatório")
    private LocalDateTime fim;


>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    @NotNull(message = "O preço é obrigatório")
    private BigDecimal preco;
}
