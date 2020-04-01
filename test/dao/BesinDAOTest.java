/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Besin;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BesinDAOTest {

    public BesinDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class BesinDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Besin besin = new Besin();
        BesinDAO instance = new BesinDAO();
        instance.insert(besin);

    }

    /**
     * Test of delete method, of class BesinDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Besin besin = new Besin();
        BesinDAO instance = new BesinDAO();
        instance.delete(besin);

    }

    /**
     * Test of read method, of class BesinDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        BesinDAO instance = new BesinDAO();
        List<Besin> expResult = null;
        List<Besin> result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ara method, of class BesinDAO.
     */
    @Test
    public void testAra() {
        System.out.println("ara");
        String deger = "";
        BesinDAO instance = new BesinDAO();
        List<Besin> expResult = null;
        List<Besin> result = instance.ara(deger);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class BesinDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Besin besin = new Besin();
        BesinDAO instance = new BesinDAO();
        instance.update(besin);

    }

    /**
     * Test of find method, of class BesinDAO.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 0;
        BesinDAO instance = new BesinDAO();
        Besin expResult = null;
        Besin result = instance.find(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of getTuketilenBesinler method, of class BesinDAO.
     */
    @Test
    public void testGetTuketilenBesinler() {
        System.out.println("getTuketilenBesinler");
        int musteri_id = 0;
        BesinDAO instance = new BesinDAO();
        List<Besin> expResult = null;
        List<Besin> result = instance.getTuketilenBesinler(musteri_id);
        assertEquals(expResult, result);

    }

    /**
     * Test of getBkdao method, of class BesinDAO.
     */
    @Test
    public void testGetBkdao() {
        System.out.println("getBkdao");
        BesinDAO instance = new BesinDAO();
        BesinkategoriDAO expResult = null;
        BesinkategoriDAO result = instance.getBkdao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setBkdao method, of class BesinDAO.
     */
    @Test
    public void testSetBkdao() {
        System.out.println("setBkdao");
        BesinkategoriDAO bkdao = null;
        BesinDAO instance = new BesinDAO();
        instance.setBkdao(bkdao);

    }

}
