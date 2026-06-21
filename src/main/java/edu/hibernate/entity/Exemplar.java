package edu.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo_patrimonio", unique = true)
    private String codigoPatrimonio;

    @Column(name = "disponivel")
    private boolean disponivel;

    // FK
    @Column(name = "livro_id")
    private int livro;



}
