package preminum.sorting;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if(n <= 1){
            return isBadVersion(n) ?  n : 0;
        }

        //TODO:high + low 可能会超过int范围，需谨慎考虑 ！！！！！
        //二分用加，需防越界
        long low = 1, high = n;
        while(low <= high){
            int mid = (int)((low + high) / 2);
            if (isBadVersion(mid)){
                if (!isBadVersion(mid - 1)){
                    return mid;
                }
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return 0;
    }


    boolean isBadVersion(int n ){
        return n >= 1702766719;
    }

    public static void main(String[] args){
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
