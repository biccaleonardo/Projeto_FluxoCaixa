/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Entrada;

/**
 *
 * @author 181301765
 */
public class EntradaDAO {

    public static void inserir(Entrada entrada) {
        String data = "" + entrada.getData().get(Calendar.YEAR)
                + "-" + (entrada.getData().get(Calendar.MONTH) + 1)
                + "-" + entrada.getData().get(Calendar.DAY_OF_MONTH);

        String sql = " INSERT INTO entrada"
                + "( codigo, data, descricao, valor) VALUES ( "
                + "" + entrada.getCodigo() + " , "
                + "'" + data + "' , "
                + "'" + entrada.getDescricao() + "',"
                + "" + entrada.getValor() + ")";

        Conexao.executar(sql);
    }

    public static void editar(Entrada entrada) {
        String data = "" + entrada.getData().get(Calendar.YEAR)
                + "-" + (entrada.getData().get(Calendar.MONTH) + 1)
                + "-" + entrada.getData().get(Calendar.DAY_OF_MONTH);

        String sql = " UPDATE entrada SET"
                + "( codigo, data, descricao, valor) VALUES ( "
                + "" + entrada.getCodigo() + " , "
                + "'" + data + "' , "
                + "'" + entrada.getDescricao() + "',"
                + "" + entrada.getValor() + ")";

        Conexao.executar(sql);
    }

    public static void excluir(Entrada entrada) {
        String sql = " DELETE FROM entrada "
                + " WHERE codigo = " + entrada.getCodigo();
        Conexao.executar(sql);
    }

    public static List<Entrada> getEntradas() {
        List<Entrada> lista = new ArrayList<>();
        
        String sql = "SELECT e.codigo, e.descricao, e.valor, "
                + " DATE_FORMAT( e.data , '%d' ) , "
                + " DATE_FORMAT( e.data , '%m' ) , "
                + " DATE_FORMAT( e.data , '%Y' )  "
                + " FROM entrada e "
                + " ORDER BY e.codigo ";
        
        ResultSet rs = Conexao.consultar(sql);
        if (rs !=null){
            try {
                while (rs.next()) {
                    
                    Entrada entrada = new Entrada();
                    entrada.setCodigo(rs.getInt(1));
                    entrada.setDescricao(rs.getString(2));
                    entrada.setValor(rs.getDouble(3));
                    
                    
                    
                    //codigo, data, descricao, valor
                    
                }
                
                
            } catch (Exception e) {
            }
        }
        
        
                
        
        
           
        
    }


