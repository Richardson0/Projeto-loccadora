package DAO;

import Modelo.Aluguel;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL{
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a) {
        String sql = "insert into dvd values(0,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e){
            return e.getMessage();
        }
    }
        
    public List<DVD> ListarDVD() {
        String sql = "select iddvd,idfilme,situacao,preco_compra,data_compra from dvd";
        List<DVD> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setSituacao(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setData_compra(rs.getString(5));
                    
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
    
    public List<DVD> Pesquisar_Nome_DVD(String filme) {
        String sql = "select iddvd, idfilme, preco_compra, data_compra, situacao "
                + "from dvd where idfilme like '" + filme + "%'";
        List<DVD> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
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
    
    public List<DVD> Pesquisar_Cod_DVD(int cod) {
        String sql = "select iddvd, idfilme, preco_compra, data_compra, situacao "
                + "from dvd where iddvd = '" + cod + "'";
        List<DVD> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
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
    
    //yuupiiii
//    public boolean Testar_DVD(int cod) {
//        boolean Resultado = false;
//        try {
//            
//            String sql = "select * from dvd where iddvd = " + cod + "";
//            PreparedStatement ps = getCon().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            
//            if (rs != null) {
//                while (rs.next()) {
//                    Resultado = true;
//                }
//            }
//        } catch (SQLException ex) {
//            ex.getMessage();
//        }
//        return Resultado;
//    }
    
    public List<DVD> CapturarDVD(int cod) {
        String sql = "select * from dvd where iddvd =" + cod + " ";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null) {
                while (rs.next()){
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
    public String Alterar_DVD(DVD a) {
        String sql = "update dvd set idfilme = ? ,preco_compra = ? ,data_compra = ? "
                + ",situacao = ? where iddvd = ? ";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            ps.setInt(5, a.getCodigo());
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso.";
            } else {
                return "Erro ao Atualizar.";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    public List<DVD> ListarComboDVD() {
        
        String sql = "select iddvd from dvd order by iddvd ";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    public List<DVD> ConsultaCodigoDVD(String filme) {
        
        String sql = "select iddvd from dvd where idfilme = '" + filme + "'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    public String Excluir_DVD(DVD a) {
        String sql = "delete from dvd where iddvd = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    
    
    
    public boolean Testar_Situacao(int cod) {
        boolean teste = false;
        try{
            String sql = "select iddvd from dvd where iddvd = " + cod + ""
                    + " and situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException ex) {
        }
        return teste;
    }
    
    public boolean Testar_DVD(int cod){
        boolean teste = false;
        try{
            String sql = "select iddvd from dvd where iddvd =" + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException ex) {
        }
        return teste;
    }
    public List<DVD> ListarCodFilme(int cod) {
        String sql = "select idfilme from dvd where iddvd = " + cod + " ";
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
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Filme> Pesquisar_Cod_Filme(int cod){
    String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,"
            + "capa from filme where idfilme = '" + cod + "'";
        List<Filme> lista = new ArrayList<>();
        try {
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

    public void Atualizar_Situacao(DVD c) {
        
    String sql = "update dvd set situacao = ? where iddvd = ? ";
            try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, c.getSituacao());
            ps.setInt(2, c.getCodigo());
            if (ps.executeUpdate() > 0) {
            } else {
            }
        } catch (SQLException e) {
        }
    }
     
}