package br.com.model.bean;

import java.util.Date;

public class Livro {

    private int id;
    private String nomeLivro;
    private String ano;
    private double nota;
    private String resenha;
    private Date dataCadastro;
    private byte[] imagem;

    public Livro() {
    }

    public Livro(String nomeLivro, String ano, double notas, String resenha, Date dataCadastro) {
        this.nomeLivro = nomeLivro;
        this.ano = ano;
        this.nota = notas;
        this.resenha = resenha;
        this.dataCadastro = dataCadastro;
    }

    public Livro(String nomeLivro, String ano, double notas, String resenha, Date dataCadastro, byte[] imagem) {
        this.nomeLivro = nomeLivro;
        this.ano = ano;
        this.nota = notas;
        this.resenha = resenha;
        this.dataCadastro = dataCadastro;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
