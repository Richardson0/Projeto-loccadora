/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author richa
 */
public class ClassificacaoDAO extends ExecuteSQL{

    public ClassificacaoDAO(Connection con) {
        super(con);
    }
     public String Inserir_Classificacao(Classificacao a){
   String sql = "insert into classificacao values(0,?,?)";
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setDouble(2, a.getPreco());
        
        
        if (ps.executeUpdate() > 0){return"iserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
    
    public List<Classificacao>ListaPrecoClassificacao(int cod){
    String sql = "Select preco from classificacao where idclassificacao = "+ cod +"";
    List<Classificacao> lista = new ArrayList<>();
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()){
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
                
            }else{
                return null;  
            }
        }catch(SQLException e){
            return null;
        }
      
        
       

   }
     public List<Cliente>  Pesquisar_Nome_Classificacao(String nome){
    
        String sql = "Select id_classificacao,nome,preco from classificacao where nome Like'" + nome + "%'";
            return null;
    }public List<Classificacao> Pesquisar_Cod_Classificacao(int cod){
        String sql = "Select idclassificacao,nome,preco from Classificacao where id_classificacao = '" + cod + "'";
            return null; }
    
    public boolean Testar_Classificacao(int cod){
        boolean Resultado = false;
        try{
            String sql = "select * from classificacao where id_classificacao = " + cod +"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while(rs.next()){
                    Resultado = true;
                }
            }
        } catch (SQLException ex){
            ex.getMessage();
        }
        return Resultado;
    }
     public List<Classificacao> CapturarClassificacao(int cod){
        String sql = " from classificacao where idclassificacao =" + cod + " ";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                Classificacao a = new Classificacao();
                a.setCodigo(rs.getInt(1));
                a.setNome(rs.getString(2));
                
                lista.add(a);
                }
                return lista;
            }else{
            return null;
            }
        }catch (SQLException e){
            return null;
        }
    } 
    public String Alterar_Classificacao(Classificacao a){
    String sql = "update classificacao set nome = ?, id_classificacao = ? , preco = ?";        
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setInt(2, a.getCodigo());
        if (ps.executeUpdate() > 0){
        return "Atuaalizado com sucesso.";
        }else{
            return "Erro ao Atualizar";
        }
    }catch(SQLException e){
        return e.getMessage();
    }
    }
    
    
public List<Classificacao> ListarComboClassificacao(){
	String sql = "select * from classificacao order by nome";
	List<Classificacao> lista = new ArrayList<>();
	try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while (rs.next()){
	Classificacao a = new Classificacao();
	a.setNome(rs.getString(1));
        
	lista.add(a);
	}
	return lista;
	} else{
	return null;
	}
} catch (Exception e){
	return null;
	}
}
public List<Classificacao> ConsultarCodigoClassificacao(String nome){
	String sql = "select id_classificacao from classificacao where nome '" + nome + "'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()){
                    
                    Classificacao a = new Classificacao();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            
            }else{
            return null;
           }
        
        }catch (Exception e){
            
        }
        return null;

}
    public String Excluir_Classificacao(Classificacao a){
        String sql = "delete from classificacao where id_classificacao = ? and nome = ? ";
        
        try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1,a.getCodigo());
         ps.setString(2,a.getNome());
         if(ps.executeUpdate() > 0){
         return "Excluido com sucesso.";
            
         }else{
         return"Erro ao excluir";
         }
         
        
        }catch(SQLException e){
            return e.getMessage();
        }







}
}






