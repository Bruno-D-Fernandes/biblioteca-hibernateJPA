package edu.hibernate.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;


@Entity
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //FK
    @Column(name = "exemplar_id")
    private int exemplar;

    //FK
    @Column(name = "usuario_id")
    private int usuario;

    @Column(name = "data_emprestimo")
    private OffsetDateTime dataEmprestimo;

    @Column(name = "data_devolucao_prevista")
    private OffsetDateTime dataDevolucaoPrevista;

    @Column(name = "data_devolucao_real")
    private OffsetDateTime dataDevolucaoReal;

}
