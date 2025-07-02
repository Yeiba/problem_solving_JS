

public class Main {
    public static void main(String[] args) {
        ValidAnagram checker = new ValidAnagram();
        String s = "anagram"; // test string s
        String t = "nagaram"; // test string t
        boolean result = checker.validAnagram(s, t);
        System.out.println("Is valid anagram: " + result);
    }
}