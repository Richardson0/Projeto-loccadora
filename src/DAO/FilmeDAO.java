/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import Modelo.DVD;
import Modelo.Filme;

/**
 *
 * @author richa
 */
public class FilmeDAO extends ExecuteSQL{

    public FilmeDAO(Connection con) {
        super(con);
    }
    
        public List<DVD> ListarCodFilme(int cod){
        String sql = "select idfilme from dbd where iddvd = " + cod + "";
        List<DVD> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null){
                while (rs.next()){
                    DVD a = new DVD();
                    a.setCod_filme(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else{
                return null;
            }
        }catch (SQLException e){
            return null;
        }
    }

public List<Filme> Pesquisar_Cod_Filme(int cod){
	String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao," + "capa from filme where idfilme ='"+cod+"'";
List<Filme> lista = new ArrayList<>();
try{
	PreparedStatement ps = getCon().prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	if (rs != null){
	while(rs.next()){
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
} catch (SQLException e){
	return null;
}
}

    
}
