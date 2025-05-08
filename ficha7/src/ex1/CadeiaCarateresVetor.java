package ex1;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CadeiaCarateresVetor implements CadeiaCarateres {
    private final char[] cadeia;

    public CadeiaCarateresVetor() {
        this(0);
    }

    private CadeiaCarateresVetor(int n) {
        this.cadeia = new char[n];
    }

    // alinea a
    public CadeiaCarateresVetor(char ch) {
        this(1);
        cadeia[0] = ch;
    }

    @Override
    public int comprimento() {
        return cadeia.length;
    }

    @Override
    public CadeiaCarateres concat(CadeiaCarateres outra) {
        int newLen = comprimento() + outra.comprimento();
        CadeiaCarateresVetor cadeia = new CadeiaCarateresVetor(newLen);
        Iterator<Character> iter = iterator();

        int i;
        for (i = 0; iter.hasNext(); i++) {
            cadeia.cadeia[i] = iter.next();
        }

        iter = cadeia.iterator();
        for (; iter.hasNext(); i++) {
            cadeia.cadeia[i] = iter.next();
        }


        return cadeia;
    }

    @Override
    public CadeiaCarateres subcadeia(int primeiro, int ultimo) {
        CadeiaCarateresVetor cadeia = new CadeiaCarateresVetor(ultimo - primeiro);
        System.arraycopy(this.cadeia, primeiro, cadeia.cadeia, 0, ultimo - primeiro);

        return cadeia;
    }

    @Override
    public Iterator<Character> iterator() {
        return new CadeiaCarateresVetorIterator();
    }

    @Override
    public String toString() {
        return new String(cadeia);
    }

    private class CadeiaCarateresVetorIterator implements Iterator<Character> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < comprimento();
        }

        @Override
        public Character next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return cadeia[pos++];
        }
    }


}
