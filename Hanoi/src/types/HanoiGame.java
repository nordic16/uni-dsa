package types;

public class HanoiGame {

    public static final String EOL = System.lineSeparator();

    private final int numberOfRods;
    private final int numberOfDisks;
    private Tower[] towers;
    private int moves = 0;

    // used to check if game is finished.
    private Tower latest = null;

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
        Tower f = towers[from];
        latest = towers[to];
        Disk d = f.viewTopDisk();

        if (latest.isValidMove(d)) {
            f.removeFromTower();
            latest.addToTower(d);
        }
        moves++;
    }

    /**
     * 
     * @return se o puzzle foi resolvido.
     */
    public boolean isTerminated() {
        return latest != null && latest.isFull();
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
        StringBuilder sb = new StringBuilder("Moves: " + numberOfMoves() + EOL);

        // this is probably not the best solution.
        String[][] towersString = new String[numberOfRods][numberOfDisks];

        for (int i = 0; i < towersString.length; i++) {
            towersString[i] = towers[i].toString().split("\n");
        }

        // print one row at a time.
        for (int i = 0; i < numberOfDisks; i++) {
            sb.append("  ");
            for (int j = 0; j < numberOfRods; j++) {
                sb.append(towersString[j][i]);
                if (j < numberOfRods - 1) { // probably sucks.
                    sb.append("    ");
                }
            }
            sb.append("  " + EOL);
        }
        sb.repeat("-", 5 * numberOfRods);
        return sb.toString().trim();
    }


    private void initializeGame() {
        for (int i = 0; i < numberOfRods; i++) {
            towers[i] = new Tower(numberOfDisks);
        }

        // fills first tower with disks.
        for (int i = numberOfDisks; i > 0 ; i--) {
            towers[0].addToTower(new Disk(i));
        }
    }
}
