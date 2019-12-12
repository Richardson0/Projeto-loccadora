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
}






