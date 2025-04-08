package types;


/**
 * @author Diogo Domingos, 61887
 * */
public class HanoiGame {

    public static final String EOL = System.lineSeparator();

    private final int numberOfRods;
    private final int numberOfDisks;
    private final Tower[] towers;
    private int moves = 0;

    // used to check if game is finished.
    // there is another solution, but it'd require looping through every single tower
    // in search of one that is full.
    private Tower latest = null;

    /**
     *
     * @param numberOfRods: numero de torres
     * @param numberOfDisks: numero de discos
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
     * Realiza uma jogada, incrementando moves.
     *
     * @param from: torre onde disco e retirado
     * @param to: torre em que o disco sera inserido
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
            towersString[i] = towers[i].toString().split(EOL);
        }

        // print one row at a time.
        for (int i = 0; i < numberOfDisks; i++) {
            sb.append("  ");
            for (int j = 0; j < numberOfRods; j++) {
                sb.append(towersString[j][i]);
                sb.repeat(" ", j < numberOfRods - 1 ? 4 : 2);
            }
            sb.append(EOL);
        }
        sb.repeat("-", 5 * numberOfRods);
        return sb.toString();
    }

    /**
     * Utilizado para inicializar o jogo.
     * @ensures primeira torre é preencida com discos sucessivamente menores.
     * */
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
