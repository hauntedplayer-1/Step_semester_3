public class BestTimeToBuySellStock {

    /**
     * Finds the maximum profit from a single buy-sell transaction.
     * Single pass: tracks the lowest price seen so far and the best profit.
     * Returns 0 if no profitable trade exists.
     */
    static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test 1:");
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // Expected: 5 (buy on day 2 at price 1, sell on day 5 at price 6)

        // Test case 2
        System.out.println("Test 2:");
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        // Expected: 0 (prices only fall, no profitable trade)
    }
}
