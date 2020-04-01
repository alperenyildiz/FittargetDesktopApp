/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Besin;
import entity.Kullanici;
import entity.Musteri;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class MusteriDAOTest {

    public MusteriDAOTest() {
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
     * Test of insert method, of class MusteriDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Musteri musteri = new Musteri();
        MusteriDAO instance = new MusteriDAO();
        instance.insert(musteri);

    }

    /**
     * Test of delete method, of class MusteriDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Musteri musteri = new Musteri();
        MusteriDAO instance = new MusteriDAO();
        instance.delete(musteri);

    }

    /**
     * Test of read method, of class MusteriDAO.
     */
    // @Test
    public void testRead() {
        System.out.println("read");
        MusteriDAO instance = new MusteriDAO();
        List<Musteri> expResult = null;
        List<Musteri> result = instance.read();
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class MusteriDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Musteri musteri = new Musteri();

        MusteriDAO instance = new MusteriDAO();
        instance.update(musteri);

    }

    /**
     * Test of find method, of class MusteriDAO.
     */
    @Test
    public void testFind_Kullanici() {
        System.out.println("find");
        Kullanici k = new Kullanici();
        MusteriDAO instance = new MusteriDAO();
        Musteri expResult = null;
        Musteri result = instance.find(k);
        assertEquals(expResult, result);

    }

    /**
     * Test of find method, of class MusteriDAO.
     */
    @Test
    public void testFind_int() {
        System.out.println("find");
        int id = 0;
        MusteriDAO instance = new MusteriDAO();
        Musteri expResult = null;
        Musteri result = instance.find(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of kaloriHesapla method, of class MusteriDAO.
     */
    /*@Test
    public void testKaloriHesapla() {
        System.out.println("kaloriHesapla");
        Musteri musteri = new Musteri();
        MusteriDAO instance = new MusteriDAO();
        List<Double> expResult = null;
        List<Double> result = instance.kaloriHesapla(musteri);
        assertEquals(expResult, result);

    }

    /**
     * Test of yemekEkle method, of class MusteriDAO.
     */
  /*  @Test
    public void testYemekEkle() {
        System.out.println("yemekEkle");
        Besin besin = new Besin();
        Musteri m = new Musteri();
        MusteriDAO instance = new MusteriDAO();
        instance.yemekEkle(besin, m);

    }*/

    /**
     * Test of tuketilenMakroHesapla method, of class MusteriDAO.
     */
    /* @Test
    public void testTuketilenMakroHesapla() {
        System.out.println("tuketilenMakroHesapla");
        Musteri musteri = null;
        MusteriDAO instance = new MusteriDAO();
        List<Double> expResult = null;
        List<Double> result = instance.tuketilenMakroHesapla(musteri);
        assertEquals(expResult, result);
        
    }
     */
}
