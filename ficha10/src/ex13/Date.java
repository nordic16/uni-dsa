package ex13;

public class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Date o) {
        if (this.year != o.year) { // para anos diferentes...
            return this.year - o.year;
        }
        else if (this.month != o.month) { // para anos iguais, meses diferentes...
            return this.month - o.month;
        }
        else { // para anos iguais, meses iguais, dias diferentes.
            return this.day - o.day;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }
}
