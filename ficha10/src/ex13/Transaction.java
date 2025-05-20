package ex13;

public class Transaction implements Comparable<Transaction> {
    public final Date date;
    public final double amount;

    public Transaction(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public int compareTo(Transaction o) {
         return date.compareTo(o.date);
    }


    // c
    public boolean equals(Transaction o) {
        return date.compareTo(o.date) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", date.toString(), amount);
    }
}
