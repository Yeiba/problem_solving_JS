import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // O(1) — Time complexity
        // O(1) — Space complexity
        if (strs.length == 0) {
            return new ArrayList();
        }
        // O(1) — Time complexity
        // O(n * k) — Space complexity
        Map<String, List<String>> ansMap = new HashMap<>();
        
        // O(n)
        for(String s:strs){
            // O(1) — Time complexity
            // O(1) — Space complexity
            int[] count = new int[26];
            // O(1)    
            Arrays.fill(count, 0);
            // O(k)
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // O(1) — Time complexity
            // O(1) — Space complexity (fixed size string)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // O(1)
                sb.append('#');
                // O(1)
                sb.append(count[i]);
            }
            // O(1)
            String key = sb.toString();
            if(!ansMap.containsKey(key)) {
                // O(1)
                ansMap.put(key, new ArrayList());
            }
            // O(1)
            ansMap.get(key).add(s);
        }
        // O(n)
        return new ArrayList(ansMap.values());
    }
}
// O(1) + (for loop -> O(n) * O(k)) + O(n) = O(n * k)
// Time Complexity: O(n * k)
// Space Complexity: O(n * k)

