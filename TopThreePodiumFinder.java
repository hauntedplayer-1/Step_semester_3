import java.util.Arrays;

public class TopThreePodiumFinder {

    /**
     * Finds top 3 scores in a single pass without sorting the array.
     * Returns the 3 scores in descending order.
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 scores");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        int[] podium1 = findTopThreeScores(scores1);
        System.out.println(Arrays.toString(podium1));
        // Expected: [90, 90, 82]
    }
}
