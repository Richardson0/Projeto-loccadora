package DAO;

import Modelo.DVD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL{

    public DVDDAO(Connection con) {
        super(con);
    }
    public String Inserir_DVD(DVD a) {
    String sql = "insert into dvd values(0,?,?,?,?)";
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        
        ps.setInt(1, a.getCod_filme());
        ps.setDouble(2, a.getPreco());
        ps.setString(3, a.getData_compra());
        ps.setString(4, a.getSituacao());
        
        if (ps.executeUpdate() > 0) {
            return "Inserido com Sucesso.";
        }
        else{
            return "Erro ao Inserir";
        }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
        public List<DVD> ListarDVD(){
        String sql = "select iddvd, idfilme, preco_compra, data_compra, situacao from dvd";
        List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()){
                    DVD a= new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));                   
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                  }
                return lista;
            }else{
                return null;
                
            }
        } catch (SQLException e) {
            return null;
        }
    }
        public List<DVD> Pesquisar_Cod_DVD(int codigo) {
        String sql = "select iddvd, idfilme, preco_compra, data_compra, situacao from dvd where iddvd like '%" + codigo + "%'";
           List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()){
                    DVD a= new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));                   
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                  }
                return lista;
            }else{
                return null;
                
            }
        } catch (SQLException e) {
            return null;
        }
   
}
        public List<DVD> Pesquisar_Cod_Filme(int cod) {
        String sql = "select iddvd, idfilme, preco_compra, data_compra, situacao from dvd where idfilme like '%" + cod + "%'";
           List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()){
                    DVD a= new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));                   
                    a.setSituacao(rs.getString(5));
                    lista.add(a);
                  }
                return lista;
            }else{
                return null;
                
            }
        } catch (SQLException e) {
            return null;
        }
   
}

    public String Alterar_DVD(DVD a) {
            String sql = "update dvd set Data = ? , preco = ? ,situacao = ?"
                    + ",idfilme =? where iddvd = ? ";
        try {
            
            PreparedStatement ps =  getCon().prepareStatement(sql);
            ps.setString(1, a.getData_compra());
            ps.setInt(2, a.getCod_filme());
            ps.setInt(3, a.getCodigo());
            ps.setDouble(4, a.getPreco());
            ps.setString(5, a.getSituacao());
           
            if (ps.executeUpdate() > 0){
                return "Atualizado com Sucesso.";
            } else {
                return "Erro ao Atualizar";
            }
      } catch (SQLException e) {
          return e.getMessage();
      }
    }

    public boolean Testar_DVD(int cod) {
         boolean Resultado = false;
            try {
            
                String sql = "select * from dvd where iddvd = " + cod +"";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                if (rs != null) {
                   while (rs.next()) {
                   Resultado = true;
                   }
                }
            }catch (SQLException ex) {
                ex.getMessage();
            }
            return Resultado;
    }

    public List<DVD> Capturar_DVD(int cod) {
         String sql = "select * from dvd where iddvd = " + cod + "";
            List<DVD> lista = new ArrayList<>();
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                lista.add(a);
                } 
                return lista;
                } else {
                return null;
                }
            } catch (SQLException e) {
            return null;
            }
    }
    public List<DVD> ListarComboDVD() {
      
          String sql = "select idfilme from filme order by nome";
          List<DVD> lista = new ArrayList<>();
          try {
              PreparedStatement ps = getCon().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if (rs != null) {
              while (rs.next()) {
              
              DVD a = new DVD();
              a.setCod_filme(rs.getInt(1));
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
      public List<DVD> ConsultaCodigoDVD(String nome){
      
          String sql = "select iddvd from dvd where idfilme = '" + nome +"'";
          List<DVD> lista = new ArrayList<>();
          try {
              PreparedStatement ps = getCon().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if (rs != null){
              while (rs.next()) {
                  DVD a = new DVD();
                  a.setCodigo(rs.getInt(1));
                  lista.add(a);
              }
              return lista;
              } else {
                  return null;
              }
          } catch (Exception e){
              return null;
          }
      }
      public String Excluir_DVD(DVD a){
          String sql = "delete from dvd where iddvd = ? and idfilme = ?";
          
          try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCodigo());
          ps.setInt(2, a.getCod_filme());
            if(ps.executeUpdate() > 0){
                return "Excluido com Sucesso.";
            } else{
                return "Erro ao Excluir.";
            }
          
          } catch (SQLException e){
              return e.getMessage();
          }
      }
}