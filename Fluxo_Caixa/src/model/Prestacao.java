
package model;

import java.util.Calendar;




public class Prestacao {
    
    private int codigo;
    private double valor;
    private Retirada retirada;
    private String descricao;
    private Calendar data;      

    public Prestacao() {
    }

    public Prestacao(int codigo, double valor, Retirada retirada, String descricao, Calendar data) {
        this.codigo = codigo;
        this.valor = valor;
        this.retirada = retirada;
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

    public Retirada getRetirada() {
        return retirada;
    }

    public void setRetirada(Retirada retirada) {
        this.retirada = retirada;
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
