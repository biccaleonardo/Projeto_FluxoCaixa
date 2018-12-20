/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexao {
    private static final String BANCO = "n172_Caixa";
    private static final String LOCAL = "senacinfo-db";
    private static final String URL = "jdbc:mysql://"+ LOCAL + ":3306/" + BANCO + "?zeroDateTimeBehavior=convertToNull";
    private static final String USUARIO = "n172_181301765";
    private static final String SENHA = "senacrs";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    public static  boolean executar(String sql){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());
            return false;
        }
    }
    
    public static ResultSet consultar(String sql){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            Statement st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
