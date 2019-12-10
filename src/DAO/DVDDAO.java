
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }
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
    
    
  
}
