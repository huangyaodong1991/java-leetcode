package medium;

/**
 * 解题法见 https://www.cnblogs.com/grandyang/p/5194599.html
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        return false;
    }

    /**
     * 方法1，生成两个数组，一个(backward)存储每个序号从0~i的最小数，另一个(forward)存储从i~n-1的最大数
     * 然后比较nums[i] 、 backward[i]和forward[i]的大小即可找到是否有递增三元子序列
     */
    public boolean increasingTripletLow(int[] nums) {
        if (nums == null || nums.length < 3){
            return false;
        }
        int[] backward = new int[nums.length];
        int[] forward = new int[nums.length];
        backward[0] = nums[0];
        forward[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++){
            backward[i] = Math.min(backward[i-1], nums[i]);
        }

        for (int i = nums.length - 2; i>=0; i--){
            forward[i] = Math.max(forward[i+1], nums[i]);
        }

        for (int i = 0; i<nums.length; i++){
            if (backward[i] < nums[i] && nums[i] < forward[i]){
                return true;
            }
        }
        return false;
    }

}
