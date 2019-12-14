
package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }
    public String Inserir_DVD(DVD a){
   String sql = "insert into dvd values(0,?,?,?,?,?,?,?,?,?,?)";
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getData_compra());
        ps.setString(2, a.getSituacao());
        ps.setInt(3, a.getCod_filme());
        ps.setInt(4, a.getCodigo());
        ps.setDouble(5, a.getPreco());
        
        
        if (ps.executeUpdate() > 0){return"iserido com Sucesso.";
        }else{return"Erro ao inserir";
        }
       } catch (SQLException e){
           return e.getMessage();
       }
   }
   
public List<DVD> ListarDVD() {
    String sql = "select id_dvd,id_filme = ? , preco_compra = ?, data_compra = ?,situacao from dvd";
    List<DVD> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if(rs != null){
        while (rs.next()){
    DVD a = new DVD();
    a.setCodigo(rs.getInt(1));
                a.setCod_filme(rs.getInt(2));
                a.setSituacao(rs.getString(3));
                a.setData_compra(rs.getString(4));
                a.setPreco(rs.getDouble(5));
    
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

    
    public List<DVD>  Pesquisar_Nome_DVD(String nome){
    
        String sql = "Select idcliente,nome,RG,CPF,Telefone,Email from cliente where nome Like'" + nome + "%'";
         List<DVD> lista = new ArrayList<>();
         
        
        
        
        
        
        return null;
    }public List<DVD> Pesquisar_Cod_DVD(int cod){
        String sql = "Select idcliente,Nome,RG,CPF,Telefone,Email from Cliente where idcliente = '" + cod + "'";
            return null; }
    
  public boolean Testar_DVD(int cod){
    boolean teste = false;
    try{
	String sql = "select iddvd from dvd where iddvd =" + cod + "";
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
		while (rs.next()){
			teste = true;
		}
	}
    } catch (SQLException ex){
}
 return teste;
}

  public boolean Testar_Situacao(int cod){
	boolean teste = false;
    try{
	String sql = "select iddvd from dvd where iddvd =" + cod + "" + "and situacao = 'Disponivel'";
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
		while (rs.next()){
			teste = true;
		}
	}
} catch (SQLException ex){
}
 return teste;
}
    
 public List<DVD> CapturarDVD(int cod){
        String sql = " from dvd where id_dvd =" + cod + " ";
        List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                DVD a = new DVD();
                a.setCodigo(rs.getInt(1));
                a.setCod_filme(rs.getInt(2));
                a.setSituacao(rs.getString(3));
                a.setData_compra(rs.getString(4));
                a.setPreco(rs.getDouble(5));
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
 
  public String Alterar_DVD(DVD a){
    String sql = "update dvd set id_dvd = ?, id_filme = ? , preco_compra = ?, data_compra = ?,situacao = ? where idcliente = ? ";        
    
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getData_compra());
        ps.setString(2, a.getSituacao());
        ps.setInt(3, a.getCod_filme());
        ps.setInt(4, a.getCodigo());
        ps.setString(5, a.getSituacao());
        ps.setDouble(6, a.getPreco());
        
        if (ps.executeUpdate() > 0){
        return "Atuaalizado com sucesso.";
        }else{
            return "Erro ao Atualizar";
        }
    }catch(SQLException e){
        return e.getMessage();
    }
    }
  
  public List<DVD> ListarComboDVD(){
	String sql = "select * from dvd order by nome";
	List<DVD> lista = new ArrayList<>();
	try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while (rs.next()){
	DVD a = new DVD();
	
        a.setCodigo(rs.getInt(1));
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
public List<DVD> ConsultarCodigoDVD(String nome){
	String sql = "select id_dvd from dvd where nome '" + nome + "'";
        List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()){
                    
                    DVD a = new DVD();
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
    public String Excluir_DVD(DVD a){
        String sql = "delete from dvd where id_dvd = ? and nome = ? ";
        
        try{
        PreparedStatement ps = getCon().prepareStatement(sql);
       ps.setString(1, a.getData_compra());
        ps.setString(2, a.getSituacao());
        ps.setInt(3, a.getCod_filme());
        ps.setInt(4, a.getCodigo());
        ps.setString(5, a.getSituacao());
        ps.setDouble(6, a.getPreco());
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
 
