import java.util.Arrays;

public class MergeSortedArrays {

    /**
     * Merges two sorted arrays into one sorted array using two-pointer technique.
     */
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and copy the smaller one
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        int[] result1 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(result1));
        // Expected: [1, 2, 3, 4, 5, 6]

        // Test case 2
        System.out.println("Test 2:");
        int[] result2 = mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        System.out.println(Arrays.toString(result2));
        // Expected: [1, 2, 3]
    }
}
