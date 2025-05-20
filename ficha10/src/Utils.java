import java.util.Random;

public class Utils {
    private static final Random random = new Random(System.currentTimeMillis());

    public static int[] getRandomArr(int len) {
        int[] nums = new int[len];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(0, 101);
        }

        return nums;
    }
}
