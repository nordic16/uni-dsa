package ex13;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Date[] dates = getDateArr(6);
        System.out.println("Initial array: " + Arrays.toString(dates));
        Arrays.sort(dates);

        System.out.println("Sorted array: " + Arrays.toString(dates));

    }


    private static Date[] getDateArr(int len) {
        Date[] dates = new Date[len];

        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date(random.nextInt(1, 32), random.nextInt(1, 13), random.nextInt( 10000));
        }
        return dates;
    }

}
