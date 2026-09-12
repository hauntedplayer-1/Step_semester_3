public class WordReversalEncoder {

    /**
     * Reverses each word in the sentence individually while keeping word order the same.
     * e.g., "hello club" becomes "olleh bulc"
     */
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            reversed.reverse();
            if (i > 0) {
                result.append(" ");
            }
            result.append(reversed);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases from the problem
        System.out.println("Test 1:");
        System.out.println(reverseEachWord("hello club"));
        // Expected: olleh bulc

        System.out.println("Test 2:");
        System.out.println(reverseEachWord("Java is fun"));
        // Expected: avaJ si nuf

        System.out.println("Test 3:");
        System.out.println(reverseEachWord("a"));
        // Expected: a
    }
}
