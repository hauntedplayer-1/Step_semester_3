public class FindMinRotatedArray {

    /**
     * Finds the minimum element in a rotated sorted array of unique elements using modified binary search.
     * Time: O(log n), Space: O(1).
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in right half
                left = mid + 1;
            } else {
                // Minimum is in left half including mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1));
        // Expected: 1

        // Test case 2
        System.out.println("Test 2:");
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2));
        // Expected: 0

        // Test case 3
        System.out.println("Test 3:");
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3));
        // Expected: 11
    }
}
