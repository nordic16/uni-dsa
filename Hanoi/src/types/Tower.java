package types;

import java.util.Iterator;

public class Tower {
    
    public static final String EOL = System.lineSeparator(); 
    public static final int DEFAULT_HEIGHT = 8; 

    private final int height;
    private ArrayStack<Disk> disks = new ArrayStack<>();

    /**
     * 
     */
    public Tower() {
        this.height = DEFAULT_HEIGHT;
    }

    /**
     * 
     * @param height
     * @requires: height >= 3
     */
    public Tower(int height) {
        this.height = height;
    }

    /**
     * @param d
     */
    public void addToTower(Disk d) {
        if (isValidMove(d)) {
            disks.push(d);
        }
    }

    /**
     * 
     * @return
     */
    public boolean isFull() {
        return this.height == this.numberOfDisks();
    }

    /**
     * @requires: !isEmpty()
     */
    public void removeFromTower() {
        disks.pop();
    }

    /**
     * 
     * @param d: disco a inserir
     * @requires: !isEmpty()
     * @return
     */
    public boolean isValidMove(Disk d) {
        return disks.peek().isLargerThan(d) && this.numberOfDisks() < this.height;
    }

    /**
     * 
     * @return disco no topo da torre.
     */
    public Disk viewTopDisk() {
        return disks.peek();
    }

    /**
     * 
     * @return se a torre está vazia
     */
    public boolean isEmpty() {
        return disks.isEmpty();
    }

    /**
     * 
     * @return
     */
    public int height() {
        return height;
    }

    /**
     * 
     * @return
     */
    public int numberOfDisks() {
        int i = 0;

        for (Iterator<Disk> current = disks.iterator(); current.hasNext(); i++) {
            current.next();
        }

        return i;
    }

    @Override
    public String toString() {
        return disks.toString();
    }
}