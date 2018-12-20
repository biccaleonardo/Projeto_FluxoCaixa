
package dao;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Setor;


public class SetorDAO {
    
    public static List<Setor> getSetor(){
        
        String sql = "SELECT codigo, nome FROM setor ORDER BY nome ";
        ResultSet rs = Conexao.consultar(sql);
        List<Setor> lista = new ArrayList<>();
        
        if( rs !=null ){
            
            try{
                while(rs.next()){
                    Setor set = new Setor();
                    set.setCodigo(rs.getInt("codigo"));
                    set.setNome(rs.getString("nome"));
                    lista.add(set);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
       return lista; 
    }
    
    
    
    public static void inserir(Setor setor){
        String sql = "INSERT INTO setor ( nome, codigo ) "
                + " VALUES ( '" + setor.getNome() + "' , "
                        + "   " + setor.getCodigo() +" ) ";
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao inserir setor");
        }
    
    
}

