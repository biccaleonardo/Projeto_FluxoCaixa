
package model;



public class Setor {
    
private int codigo;
private String nome;
private Funcionario lider;

    public Setor() {
    }

    public Setor(int codigo, String nome, Setor setor) {
        this.codigo = codigo;
        this.nome = nome;
        this.lider = lider;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario lider) {
        this.lider = lider;
    }

    

    
}


