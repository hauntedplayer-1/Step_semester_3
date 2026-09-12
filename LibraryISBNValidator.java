public class LibraryISBNValidator {

    /**
     * Normalizes a raw code: trims whitespace and uppercases the first 3 characters.
     */
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates and formats a normalized code.
     * Valid code: exactly 13 chars, first 3 are letters, remaining 10 are digits.
     * Returns formatted string or specific error reason.
     */
    static String validateAndFormat(String code) {
        // Check length
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters (got " + code.length() + ")";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be 10 digits";
            }
        }

        // Build formatted output
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year).append(" | ");
        sb.append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1: valid code with leading/trailing spaces
        System.out.println("Test 1:");
        String normalized1 = normalizeCode("  pen2026004251  ");
        System.out.println(validateAndFormat(normalized1));
        // Expected: [PEN] YEAR: 2026 | CATALOG: 004251

        // Test case 2: invalid publisher code (starts with digit)
        System.out.println("Test 2:");
        String normalized2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized2));
        // Expected: Invalid: publisher code must be 3 letters

        // Test case 3: wrong length
        System.out.println("Test 3:");
        String normalized3 = normalizeCode("AB12345");
        System.out.println(validateAndFormat(normalized3));
        // Expected: Invalid: code must be exactly 13 characters (got 7)
    }
}
