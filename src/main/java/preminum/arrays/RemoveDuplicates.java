package preminum.arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
            return 1;
        }

        int moveSteps = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                moveSteps ++;
            }else{
                nums[i - moveSteps] = nums[i];
            }
        }
        return nums.length - moveSteps;
    }
}
