package medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs){
            char[] key = new char[str.length()];
            str.getChars(0, str.length(), key, 0);
            Arrays.sort(key);
            String keyStr = new String(key);
            result.computeIfAbsent(keyStr, k -> new ArrayList<>());
            result.get(keyStr).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
