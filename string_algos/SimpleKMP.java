//i go forward as long as i found matchs, it not found match instead of starting from page 1 i start from last valid point 

public class KMPAlgorithm {
    // Function to preprocess the pattern and create the LPS array
    private static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Use the previous LPS value
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to perform the KMP search
    public static void search(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();

        // Create the LPS array for the pattern
        int[] lps = computeLPSArray(pattern);
        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1]; // Reset j using the LPS array
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS value
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        search(text, pattern); // Call the search function
    }
}
