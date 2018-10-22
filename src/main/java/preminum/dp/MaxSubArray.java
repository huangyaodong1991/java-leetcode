package preminum.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1;i < nums.length; i++){
            currentSum += nums[i];
            if (currentSum < nums[i]){
                currentSum = nums[i];
            }

            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
