/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author richa
 */
public class CategoriaDAO extends ExecuteSQL{
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
   public String Inserir_Categoria(Categoria a){
   String sql = "insert into categoria values(0,?)";
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());

        
        if (ps.executeUpdate() > 0){return"inserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
    public List<Categoria> ListarCategoria() {
    String sql = "select * from categoria";
    List<Categoria> lista = new ArrayList<>();
    
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if(rs != null){
        while (rs.next()){
    Categoria a = new Categoria();
    a.setNome(rs.getString(1));
    
    lista.add(a);
    }
    
        return lista;
    }
        else {
    return null;
    }
} catch (SQLException e){
    return null;
  }
}
    public List<Categoria>  Pesquisar_Nome_Categoria(String nome){
    
            String sql = "Select * from categoria where nome Like'" + nome + "%'";
            List<Categoria> lista = new ArrayList<>();
            
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
    
        if(rs != null){
        while (rs.next()){
    Categoria a = new Categoria();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
    lista.add(a);
    }
    
        return lista;
    }
        else {
    return null;
    }
}
    catch (SQLException e){
    return null;
    }
    }
    public List<Categoria> Pesquisar_Cod_Categoria(int cod){
        String sql = "Select * from categoria where id_categoria    = '" + cod + "'";
           List<Categoria> lista = new ArrayList<>();
            
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
    
        if(rs != null){
        while (rs.next()){
    Categoria a = new Categoria();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
    lista.add(a);
    }
    
        return lista;
    }
        else {
    return null;
    }
}
    catch (SQLException e){
    return null;
    }  
    
    }
    public boolean Testar_Categoria(int cod){
        boolean Resultado = false;
        try{
            String sql = "select * from categoria where id_categoria = " + cod +"";
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
 public List<Categoria> CapturarCategoria(int cod){
        String sql = " from categoria where id_categoria =" + cod + " ";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                Categoria a = new Categoria();
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
     public String Alterar_Categoria(Categoria a){
    String sql = "update categoria set id_categoria = ?, nome = ? , where id_categoria = ? ";        
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setInt(2, a.getCodigo());
        if (ps.executeUpdate() > 0){
        return "Atualizado com sucesso.";
        }else{
            return "Erro ao Atualizar";
        }
    }catch(SQLException e){
        return e.getMessage();
    }
    }
     public List<Categoria> ListarComboCategoria(){
	String sql = "select nome from categoria order by nome";
	List<Categoria> lista = new ArrayList<>();
	try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while (rs.next()){
	Categoria a = new Categoria();
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
     public List<Categoria> ConsultarCodigoCategoria(String nome){
	String sql = "select idcategoria from categoria where nome '" + nome + "'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()){
                    
                    Categoria a = new Categoria();
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
      public String Excluir_Categoria(Categoria a){
        String sql = "delete from categoria where id_categoria = ? and nome = ? ";
        
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