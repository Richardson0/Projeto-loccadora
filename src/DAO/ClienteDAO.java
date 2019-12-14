
package DAO;

import Modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO extends ExecuteSQL{
   
    public ClienteDAO(Connection con) {
        super(con);
    }
   public String Inserir_Cliente(Cliente a){
   String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getNacimento());
        ps.setString(3, a.getRG());
        ps.setString(4, a.getCPF());
        ps.setString(5, a.getEmail());
        ps.setString(6, a.getTelefone());
        ps.setString(7, a.getBairro());
        ps.setString(8, a.getRua());
        ps.setInt(9, a.getNumero());
        ps.setString(10, a.getCEP());
        
        if (ps.executeUpdate() > 0){return"inserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
   
public List<Cliente> ListarCliente() {
    String sql = "select id_cliente,nome,rg,cpf,telefone,email, from cliente";
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

    
    public List<Cliente>  Pesquisar_Nome_Cliente(String nome){
    
        String sql = "Select idcliente,nome,RG,CPF,Telefone,Email from cliente where nome Like'" + nome + "%'";
            return null;
    }public List<Cliente> Pesquisar_Cod_Cliente(int cod){
        String sql = "Select idcliente,Nome,RG,CPF,Telefone,Email from Cliente where idcliente = '" + cod + "'";
            return null; }
    public boolean Testar_Cliente(int cod){
        boolean Resultado = false;
        try{
            String sql = "select * from cliente where idcliente = " + cod +"";
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
    public List<Cliente> CapturarCliente(int cod){
        String sql = " from cliente where idcliente =" + cod + " ";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                Cliente a = new Cliente();
                a.setCodigo(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setNascimento(rs.getString(3));
                a.setRG(rs.getString(4));
                a.setCPF(rs.getString(5));
                a.setEmail(rs.getString(6));
                a.setTelefone(rs.getString(7));
                a.setBairro(rs.getString(8));
                a.setRua(rs.getString(9));
                a.setNumero(rs.getInt(10));
                a.setCEP(rs.getString(11));
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
    public String Alterar_Cliente(Cliente a){
    String sql = "update cliente set nome = ?, data_nasc = ? , rg = ?" + ",cpf = ?,email = ?,telefone = ?, bairro = ?, rua= ?" + ",numero = ?,cep = ? where idcliente = ? ";        
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getNacimento());
        ps.setString(3, a.getRG());
        ps.setString(4, a.getCPF());
        ps.setString(5, a.getEmail());
        ps.setString(6, a.getTelefone());
        ps.setString(7, a.getBairro());
        ps.setString(8, a.getRua());
        ps.setInt(9, a.getNumero());
        ps.setString(10, a.getCEP());
        ps.setInt(11, a.getCodigo());
        if (ps.executeUpdate() > 0){
        return "Atuaalizado com sucesso.";
        }else{
            return "Erro ao Atualizar";
        }
    }catch(SQLException e){
        return e.getMessage();
    }
    }
    
    
public List<Cliente> ListarComboCliente(){
	String sql = "select nome from cliente order by nome";
	List<Cliente> lista = new ArrayList<>();
	try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while (rs.next()){
	Cliente a = new Cliente();
	a.setNome(rs.getString(1));
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
public List<Cliente> ConsultarCodigoCliente(String nome){
	String sql = "select idcliente from cliente where nome '" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()){
                    
                    Cliente a = new Cliente();
                    a.setCodigo(rs.getInt(1));
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
    public String Excluir_Cliente(Cliente a){
        String sql = "delete from cliente where idcliente = ? and nome = ? ";
        
        try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1,a.getCodigo());
         ps.setString(2,a.getNome());
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

