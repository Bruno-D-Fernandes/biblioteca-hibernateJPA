package edu.hibernate.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;


@Entity
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //FK
    @JoinColumn(name = "exemplar_id")
    @ManyToOne
    private Exemplar exemplar;

    //FK
    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    private OffsetDateTime dataEmprestimo;

    @Column(name = "data_devolucao_prevista")
    private OffsetDateTime dataDevolucaoPrevista;

    @Column(name = "data_devolucao_real")
    private OffsetDateTime dataDevolucaoReal;

    public Emprestimo(int id, Exemplar exemplar, Usuario usuario, OffsetDateTime dataEmprestimo, OffsetDateTime dataDevolucaoPrevista, OffsetDateTime dataDevolucaoReal) {
        this.id = id;
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public Emprestimo() {
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", exemplar=" + exemplar +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoReal=" + dataDevolucaoReal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id == that.id && Objects.equals(exemplar, that.exemplar) && Objects.equals(usuario, that.usuario) && Objects.equals(dataEmprestimo, that.dataEmprestimo) && Objects.equals(dataDevolucaoPrevista, that.dataDevolucaoPrevista) && Objects.equals(dataDevolucaoReal, that.dataDevolucaoReal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exemplar, usuario, dataEmprestimo, dataDevolucaoPrevista, dataDevolucaoReal);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public OffsetDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(OffsetDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public OffsetDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(OffsetDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public OffsetDateTime getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(OffsetDateTime dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
}
