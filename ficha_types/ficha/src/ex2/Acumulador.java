package ex2;

public class Acumulador {
    private int n = 0;
    private double currentValue = 0;

    /**
     * @return n
     * */
    public int getN() {
        return n;
    }

    /**
     * @return currentValue.
     * */
    public double getCurrentValue() {
        return currentValue;
    }

    /**
     * @param val: value to add.
     *
     * */
    public void adicionar(double val) {
        this.n++;
        this.currentValue += val;
    }

    /**
     * @return average (currentValue / n).
     * */
    public double media() {
        return this.currentValue / this.n;
    }

    /**
     * @return string representation.
     * */
    @Override
    public String toString() {
        return "Current Value = " + this.currentValue;
    }
}
