package preminum.dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 2;
        }

        int p = 2, pp = 1;
        int c = 0;
        for (int i = 3; i <= n; i++){
            c = p + pp;
            pp = p;
            p = c;
        }
        return c;
    }
}
