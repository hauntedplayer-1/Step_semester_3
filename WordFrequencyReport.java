import java.util.*;

public class WordFrequencyReport {

    /**
     * Prints word frequency report after filtering out stop words.
     * Stop words: {"the","was","and","a","is","of","in"}
     * Output is sorted by count in descending order.
     */
    static void printFilteredWordFrequency(String feedback) {
        // Define stop words
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordsArray));

        // Normalize: lowercase and strip punctuation
        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace("!", "");
        cleaned = cleaned.replace("?", "");
        cleaned = cleaned.replace(";", "");
        cleaned = cleaned.replace(":", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Count frequencies, skipping stop words
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        // Print results
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Test case from the problem
        System.out.println("Test 1:");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // Expected output:
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
        // (ties may appear in any order)

        System.out.println("\nTest 2:");
        printFilteredWordFrequency("A good day is a good day and the sun is bright.");
        // Expected: good: 2, day: 2, sun: 1, bright: 1
    }
}
