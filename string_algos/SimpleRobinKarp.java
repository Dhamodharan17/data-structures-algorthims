//sliding window
public class RobinKarp {
    // Function to calculate hash value of a string
    private static int computeHash(String str, int end) {
        int hashValue = 0;
        for (int i = 0; i < end; i++) {
            hashValue += str.charAt(i); // Sum of ASCII values
        }
        return hashValue;
    }

    // Function to perform the Robin-Karp search
    public static void search(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int patternHash = computeHash(pattern, patternLength);
        int textHash = computeHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            // Check for hash match
            if (patternHash == textHash) {
                // Check actual strings to handle hash collision
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index: " + i);
                }
            }
            // Update the hash value for the next window
            if (i < textLength - patternLength) {
                textHash = textHash - text.charAt(i) + text.charAt(i + patternLength);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcababcabc";
        String pattern = "abc";
        
        search(text, pattern); // Call the search function
    }
}
