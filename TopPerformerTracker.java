public class TopPerformerTracker {

    /**
     * Finds minimum, maximum, and spread in a single pass without sorting.
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 scores");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores1));
        // Expected: Min: 33 | Max: 90 | Spread: 57
    }
}
