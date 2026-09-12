public class ATMPinValidator {

    /**
     * Checks if the given PIN is exactly 4 digits long.
     * Prints appropriate message based on the length.
     */
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Test cases from the problem
        System.out.println("Test 1:");
        checkPinLength("482");    // Expected: Invalid PIN — must be exactly 4 digits.

        System.out.println("Test 2:");
        checkPinLength("4820");   // Expected: PIN length OK.

        System.out.println("Test 3:");
        checkPinLength("12345");  // Expected: Invalid PIN — must be exactly 4 digits.

        System.out.println("Test 4:");
        checkPinLength("");       // Expected: Invalid PIN — must be exactly 4 digits.
    }
}
