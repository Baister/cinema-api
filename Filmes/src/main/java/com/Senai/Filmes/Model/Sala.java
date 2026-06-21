package com.Senai.Filmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
=======
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

<<<<<<< HEAD
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
=======
@Data
@NoArgsConstructor
@Entity
@Table(name = "Salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
    private UUID id;

    @NotBlank(message = "O nome da sala é obrigatório")
    private String nome;

<<<<<<< HEAD
    @NotNull(message = "O total de assentos é obrigatório")
    @Min(value = 1, message = "A sala deve ter pelo menos 1 assento")
    private Integer totalAssentos;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assento> assentos = new ArrayList<>();
=======
    @Min(value = 1L, message = "A sala deve ter pelo menos 1 assento") // É o padrão de números de assentos, o mínimo, no caso.
    private Integer totalAssentos;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true) // Se a sala for alterada ou excluída, todos os assentos serão excluídos. Isso é a conexão com a sala. O ORPHANREMOVAL fala que os assentos estão órfao, sem o pai, então remova eles.
    //o mappedBy fala quem é 1 na história.
    private List<Assento> assentos = new ArrayList<>();

>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491
}
