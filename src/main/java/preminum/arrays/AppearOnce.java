package preminum.arrays;

import java.util.HashMap;
import java.util.Map;

public class AppearOnce {
    public int singleNumber(int[] nums) {
        //题目中规定，除一个数之外，所有的其他数都出现了两次
        //故这里可以使用异或来进行计算
        //异或运算遵循交换律
        int result = 0;
        for (int i : nums){
            result ^= i;
        }
        return result;
    }
}
