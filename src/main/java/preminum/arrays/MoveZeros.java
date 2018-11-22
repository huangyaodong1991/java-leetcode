package preminum.arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1){
            return;
        }

        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++){
            if (firstZeroIndex < 0){
                if (nums[i] == 0){
                    firstZeroIndex = i;
                }else{
                    continue;
                }
            }

            if (nums[i] == 0){
                continue;
            }

            nums[firstZeroIndex] = nums[i];
            nums[i] = 0;
            if (firstZeroIndex < nums.length - 1 && nums[firstZeroIndex+1] == 0){
                firstZeroIndex+=1;
            }else{
                firstZeroIndex = i;
            }
        }
    }
}
