package preminum.sorting;

import java.util.Arrays;

public class MergeNums {

    //TODO:可反其道而行之，从后往前插入
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        int[] ints = Arrays.copyOfRange(nums1, 0, m);

        int nums1Index = 0, i=0, j=0;
        for (; i<m && j<n; nums1Index++){
            if (ints[i] < nums2[j]){
                nums1[nums1Index] = ints[i];
                i++;
            }else{
                nums1[nums1Index] = nums2[j];
                j++;
            }
        }

        if (i < m){
            for (; i<m; i++){
                nums1[nums1Index++] = ints[i];
            }
        }

        if (j < n){
            for (; j < n; j++){
                nums1[nums1Index++] = nums2[j];
            }
        }
    }
}
