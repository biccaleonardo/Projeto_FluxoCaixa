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
import model.Funcionario;
import model.Setor;



public class FuncionarioDAO {
    
    public static void inserir(Funcionario funcionario) {
        
        String sql = "INSERT  INTO funcionario "
                + "(nome, setor) VALUES ( "
                + " '" + funcionario.getNome() + "', "
                + " '" + funcionario.getSetor() +"'  " 
                + " )";
        Conexao.executar(sql);
    }

    public static void editar(Funcionario funcionario) {
        String sql = "INSERT  INTO funcionario "
                + "(nome, setor) VALUES ( "
                + " '" + funcionario.getNome() + "', "
                + " '" + funcionario.getSetor() +"'  " 
                + " )";
        Conexao.executar(sql);
    }

    public static void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM  funcionario "
                + " WHERE codigo = " + funcionario.getCodigo();

        Conexao.executar(sql);
    }

    public static List<Funcionario> getFuncionario() {
        List<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT f.nome, f.codSetor "
                + " FROM funcionario f"
                + " INNER JOIN setor s ON f.codSetor = s.codigo "
                + " ORDER BY nome";

        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    
                    Setor setor = new Setor();
                    setor.setNome(rs.getString(2));

                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(rs.getString(1));
                    
                    
                    

                    lista.add(funcionario);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());

            }
        }

        return lista;
    }

    public static Funcionario getFuncionarioByCodigo(int codigo) {

        String sql = "SELECT f.nome, f.codSetor "
                + " FROM funcionario f"
                + " INNER JOIN setor s ON f.codSetor = s.codigo "
                + " WHERE f.codigo = " + codigo;

        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                rs.next();
                

                    Setor setor = new Setor();
                    setor.setNome(rs.getString(2));

                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(rs.getString(1));
                    

                return funcionario;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }

        } else {
            return null;
        }
    }
    
}
