import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Finds total number of contiguous subarrays whose sum equals k.
     * Uses prefix sums and frequency hash map.
     * Time: O(n), Space: O(n).
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // Base case: prefix sum 0 occurs once before traversal
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in map, add its frequency
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1));
        // Expected: 2

        // Test case 2
        System.out.println("Test 2:");
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2));
        // Expected: 3
    }
}
