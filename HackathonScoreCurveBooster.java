import java.util.Arrays;

public class HackathonScoreCurveBooster {

    /**
     * Modifies the scores array in-place by adding bonus points to each score.
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus < 0) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] scores1 = {45, 82, 79, 90, 33};
        curveScores(scores1, 5);
        System.out.println(Arrays.toString(scores1));
        // Expected: [50, 87, 84, 95, 38]
    }
}
