package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LivroDao {
    
    private Connection con = null;
    
    public LivroDao(){        
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Livro livro){        
        String sql = "INSERT INTO tbLivros(nome_livro, ano, nota, resenha, data_cadastro, imagem) VALUES (?,?,?,?,?,?)";        
        PreparedStatement stmt = null;
        
        Date data = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatDate.format(data);       
        
        try {            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livro.getNomeLivro());
            stmt.setString(2, livro.getAno());
            stmt.setDouble(3, livro.getNotas());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, dataFormatada);
            stmt.setBytes(6, livro.getImagem());            
            stmt.executeUpdate();
            return true;            
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }
}
