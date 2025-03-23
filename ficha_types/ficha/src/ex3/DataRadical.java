package ex3;

public class DataRadical {
    private int dataID;

    public DataRadical(int d, int m, int y) {
        this.dataID = 512*y + 32*m + d;
    }

    public int getAno() {
        return dataID / 512;
    }

    public int getMes() {
        return (dataID % 512) / 32;
    }

    public int getDia() {
        return (dataID % 512) % 32;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAno());
    }
}
