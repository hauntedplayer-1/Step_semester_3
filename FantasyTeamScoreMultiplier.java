import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    /**
     * Applies score multipliers in-place:
     * Captain receives a 2x multiplier (2.0 * score).
     * Vice-captain receives a 1.5x multiplier (1.5 * score).
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        double[] scores1 = {45.0, 82.0, 79.0, 90.0, 33.0};
        applyMultipliers(scores1, 3, 1);
        System.out.println(Arrays.toString(scores1));
        // Expected: [45.0, 123.0, 79.0, 180.0, 33.0]
    }
}
