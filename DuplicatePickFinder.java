public class DuplicatePickFinder {

    /**
     * Checks a submitted lineup for repeated player names using plain nested loops.
     * Reports the first duplicate found or "No Duplicates Found".
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1));
        // Expected: Duplicate Found: Kohli

        // Test case 2
        System.out.println("Test 2:");
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2));
        // Expected: No Duplicates Found
    }
}
