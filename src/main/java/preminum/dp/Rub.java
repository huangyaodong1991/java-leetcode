package preminum.dp;

public class Rub {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        if (nums.length == 1){
            return max[0];
        }

        max[1] = Math.max(max[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            max[i] = Math.max(max[i-1], max[i-2] + nums[i]);
        }

        return max[nums.length - 1];
    }
}
