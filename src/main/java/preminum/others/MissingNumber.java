package preminum.others;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int left = n * (n+1) / 2;

        for (int i = 0; i < n; i++){
            left -= nums[i];
        }

        return left;
    }
}
