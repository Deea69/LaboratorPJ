package Pb1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @Test
    void test1_isItFibo() {
        PerecheNumere p = new PerecheNumere(0,4);
        assertFalse(p.isItFibo());
    }

    @Test
    void test2_isItFibo() {
        PerecheNumere p = new PerecheNumere(3,5);
        assertTrue(p.isItFibo());
    }

    @Test
    void test3_isItFibo() {
        PerecheNumere p = new PerecheNumere(0,1);
        assertTrue(p.isItFibo());
    }

    @Test
    void test1_CMMMC() {
        PerecheNumere p = new PerecheNumere(8,3);
        assertEquals(24, p.CMMMC());
    }

    @Test
    void test2_CMMMC() {
        PerecheNumere p = new PerecheNumere(5,7);
        assertFalse(p.CMMMC()!=35);
    }

    @Test
    void test3_CMMMC() {
        PerecheNumere p = new PerecheNumere(8,4);
        assertFalse(p.CMMMC()==24);
    }

    @Test
    void test1_sumaCifr() {
        PerecheNumere p = new PerecheNumere(154,361);
        assertTrue(p.sumaCifr());
    }

    @Test
    void test2_sumaCifr() {
        PerecheNumere p = new PerecheNumere(644,33);
        assertFalse(p.sumaCifr());
    }

    @Test
    void test3_sumaCifr() {
        PerecheNumere p = new PerecheNumere(53,35);
        assertTrue(p.sumaCifr());
    }

    @Test
    void test1_nrCifPare() {
        PerecheNumere p = new PerecheNumere(121,546);
        assertFalse(p.nrCifPare());
    }

    @Test
    void test2_nrCifPare() {
        PerecheNumere p = new PerecheNumere(123,765);
        assertTrue(p.nrCifPare());
    }

    @Test
    void test3_nrCifPare() {
        PerecheNumere p = new PerecheNumere(11224,88633);
        assertTrue(p.nrCifPare());
    }
}