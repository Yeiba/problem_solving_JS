import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // O(1) — Time complexity
        // O(n) — Space complexity
        Map<Integer, Integer> map = new HashMap<>();
        // O(n)
        for (int i = 0; i < nums.length; i++){
            // O(1)
            int complement = target - nums[i];
            // O(1)
            if (map.containsKey(complement)) {
                // O(1)
                return new int[] { map.get(complement), i };
            }
            // O(1)
            map.put(nums[i], i);
        }
        // O(1)
        return new int[] {};
    }
}
// O(1) + (for loop -> O(n) * O(1)) + O(1) = O(n)
// Time Complexity: O(n)
// Space Complexity: O(1)

