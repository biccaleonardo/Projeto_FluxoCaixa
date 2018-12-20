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

        String sql = "SELECT c.codigo, c.nome, c.telefone, c.cpf, "
                + "c.salario, c.filhos, c.casado,"
                + "c.sexo, m.codigo, m.nome, e.codigo, e.nome, "
                + "DATE_FORMAT( c.dataNascimento, '%d'), "
                + "DATE_FORMAT( c.dataNascimento, '%m'), "
                + "DATE_FORMAT( c.dataNascimento, '%y') "
                + " FROM clientes c "
                + " INNER JOIN cidades m ON m.codigo = c.codCidade"
                + " INNER JOIN estados e ON e.codigo = m.codEstado"
                + " ORDER BY c.nome";

        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Estado estado = new Estado();
                    estado.setCodigo(rs.getInt(11));
                    estado.setNome(rs.getString(12));

                    Cidade cidade = new Cidade();
                    cidade.setCodigo(rs.getInt(9));
                    cidade.setNome(rs.getString(10));
                    cidade.setEstado(estado);

                    Cliente cliente = new Cliente();
                    cliente.setCodigo(rs.getInt(1));
                    cliente.setNome(rs.getString(2));
                    cliente.setTelefone(rs.getString(3));
                    cliente.setCpf(rs.getString(4));
                    cliente.setSalario(rs.getDouble(5));
                    cliente.setTemfilhos(rs.getBoolean(6));
                    cliente.setCasado(rs.getBoolean(7));
                    cliente.setSexo(rs.getString(8));

                    Calendar nascimento = Calendar.getInstance();
                    nascimento.set(rs.getInt(15), (rs.getInt(14)-1), rs.getInt(13));

                    cliente.setNascimento(nascimento);
                    cliente.setCidade(cidade);

                    lista.add(cliente);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());

            }
        }

        return lista;
    }

    public static Cliente getClienteByCodigo(int codigo) {

        String sql = "SELECT c.codigo, c.nome, c.telefone, c.cpf, "
                + "c.salario, c.filhos, c.casado,"
                + "c.sexo, m.codigo, m.nome, e.codigo, e.nome, "
                + "DATE_FORMAT( c.dataNascimento, '%d'), "
                + "DATE_FORMAT( c.dataNascimento, '%m'), "
                + "DATE_FORMAT( c.dataNascimento, '%y') "
                + " FROM clientes c "
                + " INNER JOIN cidades m ON m.codigo = c.codCidade"
                + " INNER JOIN estados e ON e.codigo = m.codEstado"
                + " WHERE c.codigo = " + codigo;

        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                rs.next();
                Estado estado = new Estado();
                estado.setCodigo(rs.getInt(11));
                estado.setNome(rs.getString(12));

                Cidade cidade = new Cidade();
                cidade.setCodigo(rs.getInt(9));
                cidade.setNome(rs.getString(10));
                cidade.setEstado(estado);

                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setTelefone(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setSalario(rs.getDouble(5));
                cliente.setTemfilhos(rs.getBoolean(6));
                cliente.setCasado(rs.getBoolean(7));
                cliente.setSexo(rs.getString(8));

                Calendar nascimento = Calendar.getInstance();
                nascimento.set(rs.getInt(15), rs.getInt(14), rs.getInt(13));

                cliente.setNascimento(nascimento);
                cliente.setCidade(cidade);

                return cliente;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }

        } else {
            return null;
        }
    }
    
}
