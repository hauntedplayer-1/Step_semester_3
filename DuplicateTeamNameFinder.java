public class DuplicateTeamNameFinder {

    /**
     * Scans the list of registered team names and reports the first duplicate found.
     * Uses nested loops without any Collections framework.
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams1));
        // Expected: Duplicate Found: ByteForce

        // Test case 2
        System.out.println("Test 2:");
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams2));
        // Expected: No Duplicates Found
    }
}
