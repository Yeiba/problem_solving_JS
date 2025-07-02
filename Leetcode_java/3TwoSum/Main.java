
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        TwoSum checker = new TwoSum();
        int[] nums = {1,5,1,2,6,0,7}; // test string s
        int target = 9; // test string t
        int[] result = checker.twoSum(nums, target);
        System.out.println("Is valid anagram: " + Arrays.toString(result));
    }
}