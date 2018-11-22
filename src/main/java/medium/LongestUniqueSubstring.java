package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        Map<Character, Integer> charIndexMap = new HashMap<>(48);
        int startChar = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++){
            char chr = s.charAt(i);
            Integer integer = charIndexMap.get(chr);
            if (integer == null){
                charIndexMap.put(chr, i);
                int curLength = i - startChar + 1 ;
                if (curLength > length){
                    length = curLength;
                }
            }else{
                for (int k = startChar; k <= integer; k++){
                    charIndexMap.remove(s.charAt(k));
                }
                charIndexMap.put(chr, i);
                startChar = integer+1;
            }
        }

        return length;
    }

    public static void main(String[] args){
        System.out.println(new LongestUniqueSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
