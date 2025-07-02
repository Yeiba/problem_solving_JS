
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // O(1)
        if (nums == null || nums.length == 0) {
            return false;
        }
        // O(1) — Time complexity
        // O(n) — Space complexity
        HashSet<Integer> seenNumbers = new HashSet<>();

        // O(n)
        for (int num : nums) {
            // O(1)
            if (seenNumbers.contains(num)) {
                return true;
            }
            // O(1)
            seenNumbers.add(num);
        }
        // O(1)
        return false;
    }
}
// O(1) + O(1) + (for loop -> O(n) * O(1)) + O(1) = O(n)
// Time Complexity: O(n)
// Space Complexity: O(n)