package ex11;

public class Stopwatch {
    private long initialTime;
    private long stopTime = -1;

    public Stopwatch() {
        this.initialTime = System.nanoTime();
    }


    public void stop() {
        this.stopTime = System.nanoTime();
    }

    public long getElapsedTime() {
        if (stopTime == -1) return 0;
        return (stopTime - initialTime);
    }

    public void reset() {
        this.stopTime = -1;
        this.initialTime = System.nanoTime();
    }
}
