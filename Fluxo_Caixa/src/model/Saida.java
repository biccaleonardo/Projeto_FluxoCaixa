
package model;

import java.util.Calendar;


public class Saida {
    
    private int codigo;
    private  double valor;
    private String descricao;
    private Calendar data;

    public Saida() {
    }

    public Saida(int codigo, double valor, String descricao, Calendar data) {
        this.codigo = codigo;
        this.valor = valor;
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
