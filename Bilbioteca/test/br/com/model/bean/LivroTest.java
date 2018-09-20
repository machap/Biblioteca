package br.com.model.bean;

import br.com.model.dao.LivroDao;
import java.util.Date;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LivroTest {

    public LivroTest() {
    }

    @Test
    //@Ignore
    public void testSave() {
        Livro l = new Livro("Teste", "1994", 4.5, "test test tes", new Date());
        LivroDao dao = new LivroDao();

        if (dao.save(l)) {
            System.out.println("Yes");
        } else {
            Assert.fail("falhou");
        }
    }

    @Test
    //@Ignore
    public void testFindAll() {
        LivroDao dao = new LivroDao();

        for (Livro l : dao.findAll()) {
            System.out.println("ID: " + l.getId());
            System.out.println("Nome: " + l.getNomeLivro());
            System.out.println("Ano: " + l.getAno());
            System.out.println("Nota: " + l.getNota());
            System.out.println("Resenha: " + l.getResenha());
            System.out.println("Data Registro: " + l.getDataCadastro());
            System.out.println("Imagem: " + l.getImagem());
            System.out.println("--------------------------------------");
        }
    }

    @Test
    //@Ignore
    public void testUpdate() {
        Livro l = new Livro("Teste9", "1994", 4.5, "test test tes", new Date());
        l.setId(2);
        LivroDao dao = new LivroDao();

        if (dao.update(l)) {
            System.out.println("Yes");
        } else {
            Assert.fail("falhou");
        }
    }

    @Test
    //@Ignore
    public void testDelete() {
        Livro l = new Livro();
        l.setId(8);
        LivroDao dao = new LivroDao();

        if (dao.delete(l)) {
            System.out.println("Yes");
        } else {
            Assert.fail("falhou");
        }
    }

}
