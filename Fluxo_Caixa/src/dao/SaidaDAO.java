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
import javax.swing.JOptionPane;
import model.Saida;

/**
 *
 * @author 181301765
 */
public class SaidaDAO {
        public static List<Saida> getSaida(){
        
        String sql = "SELECT codigo, nome FROM saida ORDER BY nome ";
            ResultSet rs = Conexao.consultar(sql);
            List<Saida> lista = new ArrayList<>();
        
        if( rs !=null ){
            
            try{
                while(rs.next()){
                    Saida set = new Saida();
                    set.setValor(rs.getInt("valor"));
                    set.setDescricao(rs.getString("descricao"));
                    
                    lista.add(set);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
       return lista; 
    }
    public static Saida getSaidaByCodigo(int codigo){
            String sql = "SELECT valor, descricao, data "
                    + " FROM saida "
                    + " WHERE codigo = " + codigo
                    + " ORDER BY nome "; 
            
            
            ResultSet rs = Conexao.consultar(sql);
            
            if(rs != null){
                
                try {
                     
                    rs.next();
                                              
                        Saida saida  = new Saida();
                        saida.setValor(rs.getInt( 1 )); 
                        saida.setDescricao(rs.getString( 2 )); 
                        
                        
                        
                        return saida;
                        
                    
                } catch (Exception e) {
                }
             
                
            }
            
            
            return null;
            
            
            
        }
    
     public static void inserir(Saida saida) {
         String data =  + saida.getData().get(Calendar.YEAR)
                 + "-"  +(saida.getData().get(Calendar.MONTH )+ 1)
                 + "-"  + saida.getData().get(Calendar.DAY_OF_MONTH);
         
         

        
        String sql = "INSERT  INTO saida "
                + "(codigo, data, descricao, valor) VALUES ( "
                + "  " + saida.getCodigo()      + ", "
                + " '" + saida.getData()        +"',  " 
                + " '" + saida.getDescricao()   +"',  " 
                + "  " + saida.getValor()       +"  " 
                + " )";
        Conexao.executar(sql);
    }

    public static void editar(Saida saida) {
        String sql = "INSERT  INTO saida "
                + "(valor, descricao, data) VALUES ( "
                + " '" + saida.getValor()+ "', "
                + " '" + saida.getDescricao()+"'  " 
                + " '" + saida.getData()+"'  " 
                + " )";
        Conexao.executar(sql);
    }
    
}
