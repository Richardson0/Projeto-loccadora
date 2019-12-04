
package DAO;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexao extends ExecuteSQL{
   public static Connection AbrirConexao(){
    Connection con = null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/locadora";
    con = DriverManager.getConnection(url,"root","");
    } catch (Exception e){
    JOptionPane.showMessageDialog(null,"Erro na Conexão com o Banco","Video Locadora", JOptionPane.ERROR_MESSAGE);
    e.getMessage();
    }
       return con;
   }
    public static void FecharConexao(Connection con){
        try{
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
