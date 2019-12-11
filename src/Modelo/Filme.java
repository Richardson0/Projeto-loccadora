/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author richa
 */
public class Filme {
    private int codigo;
    private String titulo;
    private int ano;
    private String duracao;
    private int cod_categoria;
    private int cod_classificao;
    private String capa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_classificao() {
        return cod_classificao;
    }

    public void setCod_classificao(int cod_classificao) {
        this.cod_classificao = cod_classificao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public void setCod_classificacao(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
