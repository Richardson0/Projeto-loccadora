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
        ps.setInt(6, a.getCod());
       
        if (ps.executeUpdate() > 0){return"iserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
    public List<Aluguel> ListarAluguel() {
    String sql = "select * from aluguel";
    List<Aluguel> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if(rs != null){
        while (rs.next()){
    Aluguel a = new Aluguel();
    a.setCod(rs.getInt(1));
    a.setCodcliente(rs.getInt(2));
    a.setCoddvd(rs.getInt(3));
    a.setData_aluguel(rs.getString(4));
    a.setData_devolucao(rs.getString(5));
    a.setHorario(rs.getString(6));
    
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
            
            public List<Aluguel>  Pesquisar_Nome_Aluguel(String nome){
    
        String sql = "Select * from aluguel where nome Like'" + nome + "%'";
            return null;
    }
    public List<Aluguel> Pesquisar_Cod_Aluguel(int cod){
        String sql = "Select * from aluguel where id_aluguel   = '" + cod + "'";
            return null; }
    public boolean Testar_Aluguel(int cod){
        boolean Resultado = false;
        try{
            String sql = "select * from aluguel where id_aluguel = " + cod +"";
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
 public List<Aluguel> CapturarAluguel(int cod){
        String sql = " from aluguel where idaluguel =" + cod + " ";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                Aluguel a = new Aluguel();
                a.setCod(rs.getInt(1));
                a.setCodcliente(rs.getInt(2));
                a.setCoddvd(rs.getInt(3));
                a.setData_aluguel(rs.getString(4));
                a.setData_devolucao(rs.getString(5));
                a.setHorario(rs.getString(6));
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
     public String Alterar_Aluguel(Aluguel a){
    String sql = "update aluguel set id_aluguel = ?, id_dvd = ? ,id_cliente = ?,hora_aluguel = ? ,data_aluguel = ? ,hora_devolucao = ?  where idaluguel = ? ";        
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setInt(1, a.getCoddvd());
        ps.setInt(2, a.getCodcliente());
        ps.setString(3, a.getHorario());
        ps.setString(4, a.getData_aluguel());
        ps.setString(5, a.getData_devolucao());
        ps.setInt(6, a.getCod());
       
        if (ps.executeUpdate() > 0){
        return "Atualizado com sucesso.";
        }else{
            return "Erro ao Atualizar";
        }
    }catch(SQLException e){
        return e.getMessage();
    }
    }
     public List<Aluguel> ListarComboAluguel(){
	String sql = "select nome from aluguel order by nome";
	List<Aluguel> lista = new ArrayList<>();
	try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while (rs.next()){
	Aluguel a = new Aluguel();
	a.setCod(rs.getInt(1));
                a.setCodcliente(rs.getInt(2));
                a.setCoddvd(rs.getInt(3));
                a.setData_aluguel(rs.getString(4));
                a.setData_devolucao(rs.getString(5));
                a.setHorario(rs.getString(6));
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
     public List<Aluguel> ConsultarCodigoAluguel(String nome){
	String sql = "select id_aluguel from aluguel where nome '" + nome + "'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()){
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                a.setCodcliente(rs.getInt(2));
                a.setCoddvd(rs.getInt(3));
                a.setData_aluguel(rs.getString(4));
                a.setData_devolucao(rs.getString(5));
                a.setHorario(rs.getString(6));
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
      public String Excluir_Aluguel(Aluguel a){
        String sql = "delete from aluguel where idaluguel = ? and nome = ? ";
        
        try{
        PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setInt(1, a.getCoddvd());
        ps.setInt(2, a.getCodcliente());
        ps.setString(3, a.getHorario());
        ps.setString(4, a.getData_aluguel());
        ps.setString(5, a.getData_devolucao());
         ps.setInt(6, a.getCod());
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