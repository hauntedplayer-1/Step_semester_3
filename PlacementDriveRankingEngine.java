import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveRankingEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = (cgpa * 10.0) + (codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Sort by composite score descending
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    /**
     * Overloaded eligibility check 1: CGPA-only filter.
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    /**
     * Overloaded eligibility check 2: Combined CGPA and coding score filter for borderline cases.
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Filters eligible candidates, sorts them using Arrays.sort, and returns ranked display string.
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlistedList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlistedList.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlistedList.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ")
              .append(shortlistedArray[i].getName())
              .append(" (")
              .append(String.format("%.1f", shortlistedArray[i].getCompositeScore()))
              .append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(batch));
        // Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
