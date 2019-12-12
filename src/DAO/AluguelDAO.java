/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import DAO.*;
import java.sql.*;
import java.util.*;



public class AluguelDAO extends ExecuteSQL{

    public AluguelDAO(Connection con) {
        super(con);
    }
    public String Inserir_Aluguel(Aluguel a){
   
   try {
       String sql = "insert into aluguel values(0,?,?,?,?,?)";
       PreparedStatement ps = getCon().prepareStatement(sql);
        
        ps.setInt(1, a.getCoddvd());
        ps.setInt(2, a.getCodcliente());
        ps.setString(3, a.getHorario());
        ps.setString(4, a.getData_aluguel());
        ps.setString(5, a.getData_devolucao());
       
        if (ps.executeUpdate() > 0){return"iserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
    public List<Cliente> LitarAluguel() {
    String sql = "select * from aluguel";
    List<Cliente> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if(rs != null){
        while (rs.next()){
    Cliente a = new Cliente();
    a.setCodigo(rs.getInt(1));
    a.setNome(rs.getString(2));
    a.setRG(rs.getString(3));
    a.setCPF(rs.getString(4));
    a.setTelefone(rs.getString(5));
    a.setEmail(rs.getString(6));
    
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
            
            
    
}
