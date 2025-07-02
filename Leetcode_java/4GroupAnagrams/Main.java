import java.util.List;
public class Main {
    public static void main(String[] args) {
        GroupAnagrams checker = new GroupAnagrams();
        String[] GList = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result =  checker.groupAnagrams(GList);
        System.out.println("Is valid anagram: " + result);
    }
}