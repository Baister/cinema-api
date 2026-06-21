package com.Senai.Filmes.Model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Table(name = "assentos")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    @JsonIgnore
    private Sala sala;

=======
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "assentos")

public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    @NotBlank(message = "A fileira é obrigatória")
    private String fileira;

    @NotNull(message = "O número do assento é obrigatório")
    private Integer numero;
<<<<<<< HEAD
=======

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
