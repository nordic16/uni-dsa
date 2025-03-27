package types;

import java.util.Arrays;

public class HanoiGame {

    public static final String EOL = System.lineSeparator();

    private final int numberOfRods;
    private final int numberOfDisks;
    private Tower[] towers;
    private int moves = 0;

    /**
     * 
     * @param numberOfRods
     * @param numberOfDisks
     *
     * @requires: numberOfRods >= 3
     */
    public HanoiGame(int numberOfRods, int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
        this.numberOfRods = numberOfRods;

        this.towers = new Tower[numberOfRods];
        initializeGame();
    }

    /**
     * 
     * @param from
     * @param to
     */
    public void play(int from, int to) {

        moves++;
    }

    /**
     * 
     * @return se o puzzle foi resolvido.
     */
    public boolean isTerminated() {
        return false;
    }

    /**
     *
     * @return numero de jogadas
     */
    public int numberOfMoves() {
        return moves;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Tower t : towers) {
            String[] st1 = t.toString().split("\n");

            sb.append(t.toString());
        }
    }


    private void initializeGame() {
        for (int i = numberOfDisks; i > 0 ; i--) {
            towers[0].addToTower(new Disk(i));
        }
    }
}
