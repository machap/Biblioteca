package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LivroDao {

    private Connection con = null;

    public LivroDao() {
        con = ConnectionFactory.getConnection();
    }

    private String dataFormat() {
        Date data = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatDate.format(data);
        return dataFormatada;
    }

    public boolean save(Livro livro) {
        String sql = "INSERT INTO tbLivros(nome_livro, ano, nota, resenha, data_cadastro, imagem) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        Date data = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatDate.format(data);

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livro.getNomeLivro());
            stmt.setString(2, livro.getAno());
            stmt.setDouble(3, livro.getNota());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, dataFormat());
            stmt.setBytes(6, livro.getImagem());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Livro> findAll() {
        String sql = "SELECT * FROM tbLivros";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<Livro>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setAno(rs.getString("ano"));
                livro.setNota(rs.getInt("nota"));
                livro.setResenha(rs.getString("resenha"));
                livro.setDataCadastro(rs.getDate("data_cadastro"));
                livro.setImagem(rs.getBytes("imagem"));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return livros;
    }

    public Livro findId(int id){
        String sql = "SELECT * FROM tbLivros WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Livro livro = new Livro();
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
            livro.setId(rs.getInt("id"));
            livro.setNomeLivro(rs.getString("nome_livro"));
            livro.setAno(rs.getString("ano"));
            livro.setNota(rs.getInt("nota"));
            livro.setResenha(rs.getString("resenha"));
            livro.setDataCadastro(rs.getDate("data_cadastro"));
            livro.setImagem(rs.getBytes("imagem"));
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }        
        return livro;        
    }
    
    public boolean update(Livro livro) {
        String sql = "UPDATE tbLivros SET nome_livro = ?, ano = ?, nota = ?, resenha = ?, data_cadastro = ?, imagem = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livro.getNomeLivro());
            stmt.setString(2, livro.getAno());
            stmt.setDouble(3, livro.getNota());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, dataFormat());
            stmt.setBytes(6, livro.getImagem());
            stmt.setInt(7, livro.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Livro livro) {

        String sql = "DELETE FROM tbLivros WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, livro.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
