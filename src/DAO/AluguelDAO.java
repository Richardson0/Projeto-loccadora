package DAO;

import Modelo.Aluguel;
import java.sql.*;
import DAO.*;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a){
        String sql = "insert into aluguel values(0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement (sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e){
            return e.getMessage();
        }
    }
    
    
    public List<Aluguel> ListarAluguel() {
        String sql = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel";
        List<Aluguel> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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
    

       
    
    
    public List<Aluguel> Pesquisar_Aluguel_Cod(int cod) {
    String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel, data_devolucao "
            + "from aluguel where idaluguel like '" + cod + "%'";
    List<Aluguel> lista = new ArrayList();
    try{
        PreparedStatement ps = getCon().prepareStatement (sql);
        ResultSet rs = ps.executeQuery();
            
        if (rs != null) {
            while (rs.next()) {
                Aluguel a = new Aluguel();
                a.setCod(rs.getInt(1));
                a.setCoddvd(rs.getInt(2));
                a.setCodcliente(rs.getInt(3));
                a.setHorario(rs.getString(4));
                a.setData_aluguel(rs.getString(5));
                a.setData_devolucao(rs.getString(6));
                    
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
    public List<Aluguel> Pesquisar_Aluguel_DVD(int cod) {
    String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel, data_devolucao "
            + "from aluguel where iddvd like '" + cod + "%'";
    List<Aluguel> lista = new ArrayList();
    try{
        PreparedStatement ps = getCon().prepareStatement (sql);
        ResultSet rs = ps.executeQuery();
            
        if (rs != null) {
            while (rs.next()) {
                Aluguel a = new Aluguel();
                a.setCod(rs.getInt(1));
                a.setCoddvd(rs.getInt(2));
                a.setCodcliente(rs.getInt(3));
                a.setHorario(rs.getString(4));
                a.setData_aluguel(rs.getString(5));
                a.setData_devolucao(rs.getString(6));
                    
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
    public List<Aluguel> Pesquisar_Aluguel_Cliente(int cod) {
    String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel, data_devolucao "
            + "from aluguel where idcliente like '" + cod + "%'";
    List<Aluguel> lista = new ArrayList();
    try{
        PreparedStatement ps = getCon().prepareStatement (sql);
        ResultSet rs = ps.executeQuery();
            
        if (rs != null) {
            while (rs.next()) {
                Aluguel a = new Aluguel();
                a.setCod(rs.getInt(1));
                a.setCoddvd(rs.getInt(2));
                a.setCodcliente(rs.getInt(3));
                a.setHorario(rs.getString(4));
                a.setData_aluguel(rs.getString(5));
                a.setData_devolucao(rs.getString(6));
                    
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
    
        public List<Cliente> ConsultaCodigoCliente(String nome) {
        
        String sql = "select idcliente from cliente where nome = '" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
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

         public List<Aluguel> Pesquisar_Nome_Cliente(String nome) {
        String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel, data_devolucao "
                + "from aluguel where nome like '" + nome + "%'";
        List<Aluguel> lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCodcliente(rs.getInt(2));
                    a.setCoddvd(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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
    public boolean Testar_Aluguel(int cod) {
        boolean Resultado = false;
        try {
            
            String sql = "select * from aluguel where idaluguel = " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }
    public List<Aluguel> CapturarAluguel(int cod) {
        String sql = "select idaluguel, iddvd, idcliente, hora_aluguel, data_aluguel, data_devolucao from aluguel where idaluguel =" + cod + " ";
        List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null) {
                while (rs.next()){
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
    
        public String Excluir_Aluguel(Aluguel a) {
        String sql = "delete from aluguel where idaluguel = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}