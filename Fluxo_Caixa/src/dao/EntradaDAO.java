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
import model.Entrada;

/**
 *
 * @author 181301765
 */
public class EntradaDAO {
        public static List<Entrada> getEntrada(){
        
        String sql = "SELECT codigo, nome FROM entrada ORDER BY nome ";
            ResultSet rs = Conexao.consultar(sql);
            List<Entrada> lista = new ArrayList<>();
        
        if( rs !=null ){
            
            try{
                while(rs.next()){
                    Entrada set = new Entrada();
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
    public static Entrada getSaidaByCodigo(int codigo){
            String sql = "SELECT valor, descricao, data "
                    + " FROM entrada "
                    + " WHERE codigo = " + codigo
                    + " ORDER BY nome "; 
            
            
            ResultSet rs = Conexao.consultar(sql);
            
            if(rs != null){
                
                try {
                     
                    rs.next();
                                              
                        Entrada entrada  = new Entrada();
                        entrada.setValor(rs.getInt( 1 )); 
                        entrada.setDescricao(rs.getString( 2 )); 
                        
                        
                        
                        return entrada;
                        
                    
                } catch (Exception e) {
                }
             
                
            }
            
            
            return null;
            
            
            
        }
    
     public static void inserir(Entrada entrada) {
         String data =  + entrada.getData().get(Calendar.YEAR)
                 + "-"  +(entrada.getData().get(Calendar.MONTH )+ 1)
                 + "-"  + entrada.getData().get(Calendar.DAY_OF_MONTH);
         
         

        
        String sql = "INSERT  INTO entrada "
                + "(codigo, data, descricao, valor) VALUES ( "
                + "  " + entrada.getCodigo()      + ", "
                + " '" + entrada.getData()        +"',  " 
                + " '" + entrada.getDescricao()   +"',  " 
                + "  " + entrada.getValor()       +"  " 
                + " )";
        Conexao.executar(sql);
    }

    public static void editar(Entrada entrada) {
        String sql = "INSERT  INTO entrada "
                + "(valor, descricao, data) VALUES ( "
                + " '" + entrada.getValor()+ "', "
                + " '" + entrada.getDescricao()+"'  " 
                + " '" + entrada.getData()+"'  " 
                + " )";
        Conexao.executar(sql);
    }
    
}
