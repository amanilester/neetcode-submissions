class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        for(int sell = 1; sell < prices.length; sell++) {
            if(prices[buy] > prices[sell])
                buy = sell;
            else
                profit = Math.max(prices[sell] - prices[buy], profit);
        }
        return profit;
    }
}
