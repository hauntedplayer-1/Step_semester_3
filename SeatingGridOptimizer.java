public class SeatingGridOptimizer {

    /**
     * Helper method to calculate the average score of a single seating row.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    /**
     * Classifies each row as "Quiet Zone" (< threshold) or "Buzzing Zone" (>= threshold).
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[][] grid1 = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold1 = 60;
        System.out.println(classifyRows(grid1, threshold1));
        // Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
