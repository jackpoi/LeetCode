package 贪心;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author beastars
 */
public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int sum = 0; // 利润
        int in = -1; // 买入的价钱
        boolean bought = false; // 是否买入了
        for (int i = 0; i < prices.length - 1; i++) {
            if (!bought && prices[i] < prices[i + 1]) {
                // 如果还没有买入，且明天的价钱比今天要贵，那就买入
                bought = true;
                in = prices[i];
            } else if (bought && prices[i] > prices[i + 1]) {
                // 如果已经买入，且明天的价钱比今天要便宜，那就卖出
                bought = false;
                sum += (prices[i] - in);
            }
            // 如果还没买入，且明天的价钱比今天要贵，那就不买，进入下一天
            // 如果已经买入，且明天的价钱比今天要贵，那就等下一天，观察后面的价钱，判断是否卖出
        }

        if (bought) {
            sum += (prices[prices.length - 1] - in);
        }

        return sum;
    }
}
