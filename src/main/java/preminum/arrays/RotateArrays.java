package preminum.arrays;

public class RotateArrays {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1){
            return;
        }

        k = k % nums.length;

        //先整体逆序，然后将前k个数  和 剩余的部分分别逆序
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end){
        if (end - start < 1){
            return;
        }

        int length = end - start + 1;

        for (int i = 0; start + i < end - i; i++){
            int tmp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = tmp;
        }

    }
}
