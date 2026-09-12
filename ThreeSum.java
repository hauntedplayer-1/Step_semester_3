import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Finds all unique triplets that sum up to 0.
     * Sorts array and uses two-pointer inward scan with duplicate skipping.
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println(Arrays.deepToString(res1));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test case 2
        System.out.println("Test 2:");
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println(Arrays.deepToString(res2));
        // Expected: [[0, 0, 0]]
    }
}
