import java.util.Arrays;

public class TwoSum {

    /**
     * Returns indices of two numbers that add up to the target.
     * Uses nested loops to check every pair.
     */
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};  // No pair found
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result1));
        // Expected: [0, 1] (2 + 7 = 9)

        // Test case 2
        System.out.println("Test 2:");
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result2));
        // Expected: [1, 2] (2 + 4 = 6)
    }
}
