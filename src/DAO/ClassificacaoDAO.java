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