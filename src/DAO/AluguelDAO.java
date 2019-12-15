package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Aluguel;


public class AluguelDAO extends ExecuteSQL{

    public AluguelDAO(Connection con) {
        super(con);
    }
 public String Inserir_Aluguel(Aluguel a) throws SQLException{
       String sql = "insert into aluguel values(0,?,?,?,?,?)";
       try{
           PreparedStatement ps = getCon().prepareStatement(sql);        
           ps.setInt(1, a.getCoddvd());
           ps.setInt(2, a.getCodcliente());
           ps.setString(3, a.getData_aluguel());
           ps.setString(4, a.getHorario());
           ps.setString(5, a.getData_devolucao());
          
           
           
           if (ps.executeUpdate() > 0){
               return "inserido com sucesso";
           } else {
               return "Erro ao inserir";
           }
       } catch (SQLException e){
           return e.getMessage();
       }
   } 
 public List<Aluguel> ListarAluguel(){ 
     String sql = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
           
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCoddvd(rs.getInt(1));
                    a.setCodcliente(rs.getInt(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setHorario(rs.getString(4));
                    a.setData_devolucao(rs.getString(5));
                    
                    lista.add(a);
                }
                return lista;
            }else{
            return null;
            }
            
        }catch(SQLException e) {
            return null;
        }    
 }
 
  public List<Aluguel> Pesquisar_Cod_Aluguel(int cod){
      String sql
              = "select idaluguel, iddvd , idcliente, hora_aluguel, data_aluguel, data_devolucao"+" from cliente where idcliente = '"+cod+"'";
        return null;
  }
  
  public boolean Testar_Aluguel(int cod){
      boolean Resultado = false;
      try{
      
      String sql = "select * from aluguel where idaluguel ="+cod+"";
      PreparedStatement ps = getCon().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      if(rs != null){
          while(rs.next()){
              Resultado = true;
          }
          
      }
      
      }catch(SQLException ex){
          ex.getMessage();
      }
      
        return Resultado;
      
  }
  
  public List<Aluguel> CapturarAluguel(int cod){
      String sql = "select * from aluguel where idaluguel ="+ cod +"";
      List<Aluguel> lista = new ArrayList();
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs != null){
              while(rs.next()){
                  Aluguel a = new Aluguel();
                    a.setCoddvd(rs.getInt(1));
                    a.setCodcliente(rs.getInt(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setHorario(rs.getString(4));
                    a.setData_devolucao(rs.getString(5));
                    
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
  public String Alterar_Aluguel(Aluguel a){
      String sql = "update aluguel set hora_aluguel = ? ,data_aluguel = ? "+",data_devolucao = ? where idaluguel = ?";
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCoddvd());
          ps.setInt(2, a.getCodcliente());
          ps.setString(3, a.getData_aluguel());
          ps.setString(4, a.getHorario());
          ps.setString(5, a.getData_devolucao());
         
          if (ps.executeUpdate() > 0){
              return "Atualizado com sucesso.";
          }else{
              return "Erro ao atualizar";
          }
      }catch (SQLException e){
          return e.getMessage();
      }
  }
  

  public List<Aluguel> ListarComboAluguel(){
      
      
      String sql = "select idaluguel from cliente order by idaluguel";
      List<Aluguel> lista = new ArrayList<>();
      try{
          PreparedStatement ps =  getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  
                  Aluguel a = new Aluguel();
                  a.setCoddvd(rs.getInt(1));
                  lista.add(a);
              }
              return lista;
          }else{
              return null;
          }
      }catch(Exception e){
          return null;
      }
  }
  
  
  public List<Aluguel> ConsultaCodigoAluguel(String aluguel){
      
      String sql = "select idaluguel from aluguel where idaluguel = '"+aluguel+"'";
      List<Aluguel> lista = new ArrayList<>();
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while(rs.next()){
              
                  Aluguel a = new Aluguel();
                  a.setCod(rs.getInt(1));
                  lista.add(a);
              }
              return lista;
          }else{
              return null;
          }
      } catch(Exception e){
          return null;
  
      }
  }
  
  public String Excluir_Cliente(Aluguel a){
      String sql = "delete from aluguel where idaluguel = ? ";
      
      try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCod());
          if (ps.executeUpdate() > 0){
              return "Excluido com Sucesso.";
          }else{
              return "Erro ao excluir.";
          }
      }catch (SQLException e){
          return e.getMessage();
      }
  }

    public void Atualizar_Situacao(String situacao, int coddvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}