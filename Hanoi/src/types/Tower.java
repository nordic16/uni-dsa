package types;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterators;

public class Tower {
    
    public static final String EOL = System.lineSeparator(); 
    public static final int DEFAULT_HEIGHT = 8; 

    private final int height;
    private ArrayStack<Disk> disks = new ArrayStack<>();
    private int numberOfDisks = 0;

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
        //if (isValidMove(d)) {
            disks.push(d);
            numberOfDisks++;
        //}
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
        if (numberOfDisks > 0) {
            numberOfDisks--;
        }

        disks.pop();
    }

    /**
     * 
     * @param d: disco a inserir
     * @requires: !isEmpty()
     * @return
     */
    public boolean isValidMove(Disk d) {
        return disks.isEmpty() || (disks.peek().isLargerThan(d) && this.numberOfDisks() < this.height);
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
     * @return numberOfDisks
     */
    public int numberOfDisks() {
        return numberOfDisks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Disk> iter = disks.iterator();

        // appends | if needed.
        sb.append("|\n".repeat(Math.max(0, height - numberOfDisks)));

        while (iter.hasNext()) {
            sb.append(iter.next()).append(EOL);
        }
        return sb.append("_").toString();
    }
}