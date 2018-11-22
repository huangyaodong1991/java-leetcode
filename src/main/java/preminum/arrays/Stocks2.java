package preminum.arrays;

public class Stocks2 {
    //TODO: 如何处理相等项
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int buy = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++){
            if (i != prices.length - 1 && i != 0){
                if (prices[i] < prices[i-1] && prices[i] < prices[i+1]){
                    buy = prices[i];
                }else if (prices[i] > prices[i-1] && prices[i] > prices[i+1]){
                    profit += prices[i] - buy;
                }
            }

            if (i == 0 && prices[i] < prices[i+1]){
                buy = prices[i];
            }

            if (i == prices.length - 1 && prices[i] > prices[i-1]){
                profit += prices[i] - buy;
            }
        }

        return profit;
    }
}
