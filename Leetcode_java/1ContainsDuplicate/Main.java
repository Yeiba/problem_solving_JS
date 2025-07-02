

public class Main {

    public static void main(String[] args) {
        ContainsDuplicate checker = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1}; // test array

        boolean result = checker.containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }
}