package leet_code;

class Item121_买股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(1, prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    /**
     * 这个是通过188直接改过来的
     */
    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;

        int sold = 0;
        int notSold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sold = Math.max(sold, notSold + prices[i]);
            notSold = Math.max(notSold,  - prices[i]);
        }

        return sold;
    }


}
