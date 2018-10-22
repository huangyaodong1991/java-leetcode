package preminum.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0){
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }

        int lastIndex = -1;
        boolean shouldContinue = true;

        while (shouldContinue){
            int current = lastIndex + 1;
            for (int i = 1; i < strs.length; i++){
                if (strs[i].length() <= current || strs[i-1].length() <= current){
                    shouldContinue = false;
                    break;
                }
                if (strs[i].charAt(current) != strs[i-1].charAt(current)){
                    shouldContinue = false;
                    break;
                }
            }
            if (shouldContinue) {
                lastIndex = current;
            }
        }

        if (lastIndex < 0){
            return "";
        }

        return strs[0].substring(0, lastIndex+1);
    }
}
