package com.Senai.Filmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome da sala é obrigatório")
    private String nome;

    @Min(value = 1L, message = "A sala deve ter pelo menos 1 assento") // É o padrão de números de assentos, o mínimo, no caso.
    private Integer totalAssentos;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true) // Se a sala for alterada ou excluída, todos os assentos serão excluídos. Isso é a conexão com a sala. O ORPHANREMOVAL fala que os assentos estão órfao, sem o pai, então remova eles.
    private List<Assento> assentos = new ArrayList<>();

}
