
public class ValidAnagram {

    public boolean validAnagram(String s, String t) {
        // O(1)
        if (s.length() != t.length()) {
            return false;
        }
        // O(1) — Time complexity
        // O(1) — Space complexity (fixed array size of 26)
        int[] charCount = new int[26]; 
        // O(n)
        for (int i = 0; i < s.length(); i++) {
            // O(1)
            charCount[s.charAt(i) - 'a']++;
            // O(1)
            charCount[t.charAt(i) - 'a']--;
        }
        // O(1) — Loop over constant-size array (26)
        for (int count : charCount) {
            // O(1)
            if (count != 0) {
                return false; 
            }
        }
        // O(1)
        return true; 
    }
}
// O(1) + O(1) +(for loop -> O(n) * O(1)) + (for loop -> O(1) * O(1)) = O(n)
// Time Complexity: O(n)
// Space Complexity: O(1)
