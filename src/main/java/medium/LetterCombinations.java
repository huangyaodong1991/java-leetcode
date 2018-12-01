package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        //TODO:特殊的边界值需认真考虑
        List<String> result = new LinkedList<>();
        if (digits == null){
            return result;
        }
        Map<Character, char[]> numCharsMapping = new HashMap<>();
        numCharsMapping.put('2', new char[]{'a','b','c'});
        numCharsMapping.put('3', new char[]{'d','e','f'});
        numCharsMapping.put('4', new char[]{'g','h','i'});
        numCharsMapping.put('5', new char[]{'j','k','l'});
        numCharsMapping.put('6', new char[]{'m','n','o'});
        numCharsMapping.put('7', new char[]{'p','q','r','s'});
        numCharsMapping.put('8', new char[]{'t','u','v'});
        numCharsMapping.put('9', new char[]{'w','x','y','z'});

        getAllCandidates("",digits, 0, result, numCharsMapping);
        return result;
    }

    private void getAllCandidates(String prefix, String digits, int index, List<String> result, Map<Character, char[]> numCharsMapping) {
        if (index >= digits.length()){
            result.add(prefix);
            return;
        }

        char[] chars = numCharsMapping.get(digits.charAt(index));
        for (int i = 0, k=chars.length; i < k; i++){
            getAllCandidates(prefix + chars[i], digits, index +  1, result, numCharsMapping);
        }
    }


}
