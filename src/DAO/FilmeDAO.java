package DAO;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL{

    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a) {
    
        String sql = "insert into filme values(0,?,?,?,?,?,?)";
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        
        ps.setString(1, a.getTitulo());
        ps.setInt(2, a.getAno());
        ps.setString(3, a.getDuracao());
        ps.setInt(4, a.getCod_categoria());
        ps.setInt(5, a.getCod_classificao());
        ps.setString(6, a.getCapa());
        
        
        if (ps.executeUpdate() > 0) {
            return "Inserido com Sucesso.";
        }
        
        else{
            return "Erro ao Inserir";
            }
        }catch (SQLException e) {
         return e.getMessage();
        }
    }
        
        public List<Filme> ListarFilme(){
        
        String sql = "select id_filme,titulo,ano,duracao,id_categoria,id_classificacao,capa from filme";
        List<Filme> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()){
                   Filme a= new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
                    lista.add(a);
                  }
                return lista;
            }else{
                return null;
                }
        }catch (SQLException e) {
         return null;
        }
    }
        
        public List<Filme> Pesquisar_Nome_Filme(String titulo) {
        
        String sql = "select id_filme, titulo , ano, duracao, id_categoria, id_classificacao, capa from filme where titulo like '%" + titulo + "%'";
        List<Filme> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while (rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
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
        public List<Filme> Pesquisar_Cod_Filme(int cod) {
        
           String sql = "select id_filme, titulo , ano, duracao, id_categoria, id_classificacao, capa from filme where id_filme like '%" + cod + "%'";
           List<Filme> lista = new ArrayList<>();
       
           try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            if(rs != null) {
                while (rs.next()){
                    Filme a= new Filme();
                     a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
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
        public String Alterar_Filme(Filme a){
            
            String sql = "update filme set titulo = ? , ano = ? ,duracao = ?" + ",id_categoria =? ,id_classificacao = ?, capa = ?" + " where id_filme = ? ";
        
            try {
            
            PreparedStatement ps =  getCon().prepareStatement(sql);
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria()); 
            ps.setInt(5, a.getCod_classificao());
            ps.setString(6, a.getCapa());
            ps.setInt(7, a.getCodigo());
            if (ps.executeUpdate() > 0){
                return "Atualizado com Sucesso.";
            } else {
                return "Erro ao Atualizar";
            }
      } catch (SQLException e) {
          return e.getMessage();
      }
        }
        public boolean Testar_Filme(int cod){
            boolean Resultado = false;
            try {
            
                String sql = "select * from filme where id_filme = " + cod +"";
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
        public List<Filme> Capturar_Filme(int cod){
            String sql = "select * from filme where id_filme = " + cod + "";
            List<Filme> lista = new ArrayList<>();
            try{
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                while (rs.next()) {
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    a.setCapa(rs.getString(7));
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
      public List<Filme> ListarComboFilme() {
      
          String sql = "select titulo from filme order by titulo";
          List<Filme> lista = new ArrayList<>();
          try {
              PreparedStatement ps = getCon().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if (rs != null) {
              while (rs.next()) {
              
              Filme a = new Filme();
              a.setTitulo(rs.getString(1));
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
      public List<Filme> ConsultaCodigoFilme(String nome){
      
          String sql = "select id_filme from filme where titulo = '" + nome +"'";
          List<Filme> lista = new ArrayList<>();
          try {
              PreparedStatement ps = getCon().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if (rs != null){
              while (rs.next()) {
                  Filme a = new Filme();
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
      public String Excluir_Filme(Filme a){
          String sql = "delete from filme where id_filme = ? and titulo = ?";
          
          try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ps.setInt(1, a.getCodigo());
          ps.setString(2, a.getTitulo());
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