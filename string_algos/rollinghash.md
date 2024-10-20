### Polynomial Rolling Hash

#### 1.Intro

Magic Spell - turns each word into number

this number help you to check if 2 words are same without having to read whole word every time.

#### 2.Magic Formula (Polynomial rolling hash)

to make magic, we give each letter more and more importance depending on position of letter in a word.

- 1st letter multiply by 1
- 2nd letter multiply by p
- 3rd multiply by p^2
- and so on

#### Example
let p = 31
- Hash("abc") = 1 × 1 + 2 × 31 + 3 × 31²
            = 1 + 62 + 2883
            = 2946
- Hash("bca") = 2 × 1 + 3 × 31 + 1 × 31²
            = 2 + 93 + 961
            = 1056
- ``` hashValue = (hashValue + (charValue * pPower) % MOD) % MOD;```
#### 3.Misc
- Collisions: Use large prime numbers, double hashing, or buckets to reduce or handle them.
- Modulo Arithmetic: Keeps hash values manageable and helps avoid overflow.
- Rolling Hash: Efficiently update the hash when checking similar strings.

  ```public class PolynomialRollingHash {
    // Prime number for hash base and modulo prime
    static final int P = 31;              // Base (small prime)
    static final int MOD = 1_000_000_007; // Large prime for modulo

    // Function to calculate hash of a string
    public static long computeHash(String s) {
        long hashValue = 0;
        long pPower = 1;  // P^i where i is the index of the character

        for (int i = 0; i < s.length(); i++) {
            // Get the character's value (assuming 'a' = 1, 'b' = 2, etc.)
            int charValue = s.charAt(i) - 'a' + 1;
            
            // Update the hash value using the formula
            hashValue = (hashValue + (charValue * pPower) % MOD) % MOD;

            // Update pPower (p^i -> p^(i+1))
            pPower = (pPower * P) % MOD;
        }

        return hashValue;
    }

    // Example usage of the hash function
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";
        
        // Compute hash for both strings
        long hash1 = computeHash(word1);
        long hash2 = computeHash(word2);

        System.out.println("Hash of " + word1 + ": " + hash1);
        System.out.println("Hash of " + word2 + ": " + hash2);

        // Check if hashes are equal
        if (hash1 == hash2) {
            System.out.println("The hashes are the same! Possible collision.");
        } else {
            System.out.println("The hashes are different.");
        }
    }
  ```

  #### Problems

- Finding duplicate substrings: "Given a string, find the longest substring that appears at least twice."
- Substring search: "Check if one string is a substring of another."
- Anagram detection: "Check if two strings are anagrams."
