package medium;

import basements.ListNode;

import java.util.*;

public class ThreeNumSum {

    //TODO:学习更好的方法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(100);
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int c = nums[i];
            numIndexMap.putIfAbsent(c, new ArrayList<>());
            numIndexMap.get(c).add(i);
        }

        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = 0 - nums[i];
            for (int j = i+1; j < nums.length - 1; j ++){
                if (j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int p = left - nums[j];
                List<Integer> integers = numIndexMap.get(p);
                if (integers == null){
                    continue;
                }
                for(int k = integers.size() - 1; k>=0; k--){
                    if (integers.get(k) > j){
                        List<Integer> g = new ArrayList<>(3);
                        g.add(nums[i]);
                        g.add(nums[j]);
                        g.add(p);
                        result.add(g);
                        break;
                    }
                }
            }

        }

        return result;
    }

    private class IntegerWrapper {
        Integer num;
        int index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o instanceof Integer){
                return Objects.equals(this.num, o);
            }

            if (o == null || getClass() != o.getClass()) return false;
            IntegerWrapper that = (IntegerWrapper) o;
            return index == that.index &&
                    Objects.equals(num, that.num);
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, index);
        }
    }
}
