import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * Calculates the product of all elements except self for each index without using division.
     * Uses prefix (left) and suffix (right) products in O(n) time and O(1) auxiliary space (excluding output).
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: calculate left prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: multiply with right suffix products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums1)));
        // Expected: [24, 12, 8, 6]

        // Test case 2
        System.out.println("Test 2:");
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
        // Expected: [0, 0, 9, 0, 0]
    }
}
