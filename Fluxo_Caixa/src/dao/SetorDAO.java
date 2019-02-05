
package dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    public static Setor getSetorByCodigo(int codigo){
            String sql = "SELECT codigo, nome "
                    + " FROM setor "
                    + " WHERE codigo = " + codigo
                    + " ORDER BY nome "; 
            
            
            ResultSet rs = Conexao.consultar(sql);
            
            if(rs != null){
                
                try {
                     
                    rs.next();
                                              
                        Setor setor  = new Setor();
                        setor.setCodigo( rs.getInt( 1 )); 
                        setor.setNome( rs.getString( 2 )); 
                        
                        
                        
                        return setor;
                        
                    
                } catch (Exception e) {
                }
             
                
            }
            
            
            return null;
            
            
            
        }
    
    
    
    public static void inserir(Setor setor){
        String sql = "INSERT INTO setor ( nome ) "
                + " VALUES ( '" + setor.getNome() + "'  "
                        + " ) ";
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao inserir setor");
        }
    
    
    }
    public static void editar(Setor setor){
        String sql = "UPDATE setor "
                + " SET  nome =  '" + setor.getNome() + "' "
                        + "  WHERE codigo = " + setor.getCodigo() ;
        boolean retorno = Conexao.executar( sql );
        if( !retorno ){
            JOptionPane.showMessageDialog(null, "Erro ao inserir setor");
        }
    
    
    }
     public static void excluir(Setor setor){
        String sql = "DELETE FROM setor "
                + "WHERE codigo = " + setor.getCodigo();
                
        boolean retorno = Conexao.executar(sql);
        if( !retorno){
            JOptionPane.showMessageDialog(null, "Erro ao excluir setor");
        }
    
}
}
    


