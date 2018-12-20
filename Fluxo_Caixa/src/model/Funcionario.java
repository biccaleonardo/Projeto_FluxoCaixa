
package model;



public class Funcionario {
 
    private int codigo;
    private String nome;
    private Setor setor;

    public Funcionario() {
    }

    public Funcionario(int codigo, String nome, Setor setor) {
        this.codigo = codigo;
        this.nome = nome;
        this.setor = setor;
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    
        
    
}
