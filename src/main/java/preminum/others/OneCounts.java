package preminum.others;

public class OneCounts {
    public int hammingWeight(int n) {
        long nn = 0 ^ n;
        int result = 0;
        while (nn != 0){
            result += 1 & nn;
            nn = nn >> 1;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(new OneCounts().hammingWeight((int)(2147483648L)));
    }
}
