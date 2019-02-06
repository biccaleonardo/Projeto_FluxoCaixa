
package model;

import java.util.Calendar;


public class Caixa {
  
    private int codigo;
    private double valor;
    private Funcionario funcionario;
    private Calendar data;

    public Caixa() {
    }

    public Caixa(int codigo, double valor, Funcionario funcionario, Calendar data) {
        this.codigo = codigo;
        this.valor = valor;
        this.funcionario = funcionario;
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

}
