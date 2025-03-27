package types;

public class Disk {
    private final int size;

    /**
     * @param size: tamanho do disco
     * @requires: size > 0
     */
    public Disk(int size) {
        this.size = size;
    }

    /**
     *
     * @return tamanho do disco
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param other o disco a ser comparado
     * @return
     */
    public boolean isLargerThan(Disk other) {
        return size > other.size;
    }

    @Override
    public String toString() {
        return Character.toString(64 + size);
    }
}
