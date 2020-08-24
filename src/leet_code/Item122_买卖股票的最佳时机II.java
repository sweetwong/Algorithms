package leet_code;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
class Item122_买卖股票的最佳时机II {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 解题思路: 找到一个上升区间, 直到检测到开始下降或者到顶, 做一笔买卖
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;

        int profit = 0;

        int i = 0, j = 1;
        while (i < len && j < len) {
            if (prices[i] > prices[j]) i++;
            else {
                if (j + 1 < len && prices[j] <= prices[j + 1]) j++;
                else {
                    profit += prices[j] - prices[i];
                    i = j + 1;
                    j = j + 2;
                }
            }
        }

        return profit;
    }

}
