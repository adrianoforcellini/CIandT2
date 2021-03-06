package JPA.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {

    @Id
    private int matricula;
    private String nome;
    private String curso;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}

// No JPA, as classes Java que representam os dados a serem armazenados no SGBD são
// chamadas de Entidades (Entity). Elas são classes comuns que contêm apenas atributos
// e métodos getters (que recuperam o valor dos atributos) e setters (que modificam o valor dos atributos).
