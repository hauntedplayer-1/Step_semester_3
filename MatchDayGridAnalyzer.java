public class MatchDayGridAnalyzer {

    /**
     * Helper method to calculate the average runs per over for a single match row.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies matches as "Power Surge" (>= threshold) or "Normal" (< threshold).
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(status);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[][] runs1 = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold1 = 8;
        System.out.println(classifyMatches(runs1, threshold1));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
