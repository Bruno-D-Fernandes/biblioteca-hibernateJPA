package edu.hibernate.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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

    @JoinColumn(name = "livro_id")
    @ManyToOne
    private Livro livro;

    @OneToMany(mappedBy = "exemplar")
    private List<Emprestimo> empretimos;


    public Exemplar(int id, String codigoPatrimonio, boolean disponivel, Livro livro, List<Emprestimo> empretimos) {
        this.id = id;
        this.codigoPatrimonio = codigoPatrimonio;
        this.disponivel = disponivel;
        this.livro = livro;
        this.empretimos = empretimos;
    }

    public Exemplar() {
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", codigoPatrimonio='" + codigoPatrimonio + '\'' +
                ", disponivel=" + disponivel +
                ", livro=" + livro +
                ", empretimos=" + empretimos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return id == exemplar.id && disponivel == exemplar.disponivel && Objects.equals(codigoPatrimonio, exemplar.codigoPatrimonio) && Objects.equals(livro, exemplar.livro) && Objects.equals(empretimos, exemplar.empretimos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoPatrimonio, disponivel, livro, empretimos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoPatrimonio() {
        return codigoPatrimonio;
    }

    public void setCodigoPatrimonio(String codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Emprestimo> getEmpretimos() {
        return empretimos;
    }

    public void setEmpretimos(List<Emprestimo> empretimos) {
        this.empretimos = empretimos;
    }
}
