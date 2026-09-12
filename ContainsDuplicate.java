public class ContainsDuplicate {

    /**
     * Checks if any value appears at least twice in the array.
     * Uses nested loops to compare every pair of elements.
     */
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        // Expected: true (value 1 appears at two different positions)

        // Test case 2
        System.out.println("Test 2:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        // Expected: false (every value is distinct)
    }
}
