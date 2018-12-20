
package model;

import java.util.Calendar;


public class Entrada {
   
    private int codigo;
    private double valor;
    private Funcionario funcionario;
    private String descricao;
    private Calendar data;

    public Entrada() {
    }

    public Entrada(int codigo, double valor, Funcionario funcionario, String descricao, Calendar data) {
        this.codigo = codigo;
        this.valor = valor;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.data = data;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    
    
}
