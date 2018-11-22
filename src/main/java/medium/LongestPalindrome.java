package medium;

public class LongestPalindrome {

    //TODO:修改代码执行结构，提高执行效率
    public String longestPalindrome(String s) {
        if (s == null || s.length() <=  1){
            return s;
        }
        int maxLength = 0;
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++){
            int left = i, right = i;
            while (left >= 0 && right < s.length()){
                if (s.charAt(left) == s.charAt(right)){
                    int currentLength = right - left + 1;
                    if (currentLength > maxLength){
                        longestPalindrome = s.substring(left, right+1);
                        maxLength = currentLength;
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            left = i; right = i+1;
            while (left >= 0 && right < s.length()){
                if (s.charAt(left) == s.charAt(right)){
                    int currentLength = right - left + 1;
                    if (currentLength > maxLength){
                        longestPalindrome = s.substring(left, right+1);
                        maxLength = currentLength;
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }
        return longestPalindrome;
    }
}

