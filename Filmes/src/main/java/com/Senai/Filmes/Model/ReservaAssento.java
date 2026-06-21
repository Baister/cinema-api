package com.Senai.Filmes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "reservas_assentos")
public class ReservaAssento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    @JsonIgnore
    private Reserva reserva;
=======
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservas_assentos")
public class ReservaAssento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @JsonIgnore //Ele faz com que ao ser chamada, essa reservaassento, ele salve só o número de assento e ignora a reserva. Porque aí impede o loop. Isso tudo acontece porque uma tabela referencia a outra, isso SEMPRE para tabelas intermediárias. Pensando na REQUISIÇÃO.
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reservas reserva;
>>>>>>> a7ee41ec06d376b84f6760720508b2462f28a491

    @ManyToOne
    @JoinColumn(name = "assento_id")
    private Assento assento;
}
