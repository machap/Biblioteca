package br.com.model.bean;

import br.com.model.dao.LivroDao;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class LivroTest {
    
    public LivroTest() {
    }

    @Test
    public void testSave() {

        Livro l = new Livro("Teste", "1994", 4.5, "test test tes", new Date());        
        LivroDao dao = new LivroDao();
        
        if(dao.save(l)){
            System.out.println("Yes");
        }else{
            Assert.fail("falhou");
        }
    }
    
}
