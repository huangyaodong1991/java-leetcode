package preminum.dp;

public class BuyStocks {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int preProfit = 0;
        int maxProfix = 0;

        for (int i = prices.length - 2; i >= 0; i--){
            preProfit = preProfit - (prices[i] - prices[i+1]);
            if (preProfit < 0) {
                preProfit = 0;
            }

            if (preProfit > maxProfix){
                maxProfix = preProfit;
            }
        }

        return maxProfix;
    }
}
