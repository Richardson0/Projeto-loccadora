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
    public List<Categoria> LitarCategoria() {
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
            return null;
    }
    public List<Categoria> Pesquisar_Cod_Categoria(int cod){
        String sql = "Select * from categoria where id_categoria    = '" + cod + "'";
            return null; }
}