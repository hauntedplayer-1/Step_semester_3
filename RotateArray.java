import java.util.Arrays;

public class RotateArray {

    /**
     * Rotates array to the right by k positions using modulo arithmetic.
     * Creates a new array where each element is placed at its rotated position.
     */
    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle k larger than array length

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] result1 = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(result1));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Test case 2
        System.out.println("Test 2:");
        int[] result2 = rotateArray(new int[]{1, 2}, 3);
        System.out.println(Arrays.toString(result2));
        // Expected: [2, 1] (k % length = 3 % 2 = 1, a single rotation)
    }
}
