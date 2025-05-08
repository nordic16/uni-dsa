package ex1;

import org.junit.Test;

public class TestCadeiaCarateresVetor {
    @Test
    public void testConcat() {
        CadeiaCarateres c = new CadeiaCarateresVetor('a').concat(new CadeiaCarateresVetor('b'));
        System.out.println(c);
        assert(c.toString().equals("ab"));
    }

    @Test
    public void testSubcadeia() {
        CadeiaCarateres c = new CadeiaCarateresVetor('a').concat(new CadeiaCarateresVetor('b')).concat(new CadeiaCarateresVetor('c'));
        assert(c.subcadeia(1, 2).toString().equals("b"));
    }
}
