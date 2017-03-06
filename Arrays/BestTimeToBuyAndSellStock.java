import static java.lang.Math.max;

/**
 * Created by juanyan.li on 2/23/17.
 */
public class BestTimeToBuyAndSellStock {
    // At most one transaction
    public int maxProfitI(int[] prices) {
        int profit = 0;
        if (prices.length < 1) return profit;
        int buy = prices[0];
        for (int price: prices){
            if (buy < price){
                profit = max(profit, price - buy);
            } else {
                buy = price;
            }
        }
        return profit;
    }

    // Any number of transactions, one at a time
    public int maxProfitII(int[] prices){
        int profit = 0;
        if (prices.length < 1) return profit;
        for (int i=0; i<prices.length-1; i+=1){
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    // At most two transactions, one at a time
    public int maxProfitIII(int[] prices) {
        int profit = 0;
        if (prices.length < 1) return profit;
        int buy = prices[0];
        for (int i=0; i<prices.length; i+=1){
            int diff = prices[i] - buy;
            if (diff > 0){
                profit = max(profit, diff + findSubMax(i, prices));
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    public int findSubMax(int i, int[] prices){
        int profit = 0;
        if (prices.length < 1) return profit;
        int buy = prices[i];
        for (int j=i; j<prices.length; j+=1){
            int diff = prices[j] - buy;
            if (buy < prices[j]){
                profit = max(profit, diff);
            } else {
                buy = prices[j];
            }
        }
        return profit;
    }

    /*
    special DP: O(n) time; O(1) space
    NOTES:
    1. Denote the maximum profit to be: V([p_1, p_2, ..., p_N], state=sell2);
    2. State means that action is complete at time t <= N;
    3. The space is reduced to O(1) because only the most recent values are kept
    */
    public int maxProfitIIIOpt(int[] prices){
        int sell2 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy1 = Integer.MIN_VALUE;
        for (int price: prices){
            sell2 = max(sell2, buy2 + price);
            buy2 = max(buy2, sell1 - price);
            sell1 = max(sell1, buy1 + price);
            buy1 = max(buy1, -price);
        }
        return sell2;
    }

    // At most k transactions, one at a time
    /* Same DP solution: O(nk) time, O(k) space (pseudo polynomial time)*/
    public int maxProfitIV(int k, int[] prices){
        if (k >= prices.length) return maxProfitII(prices);
        int[] states = new int[2*k+1];
        for (int i=0; i<states.length; i+=2){
            states[i] = 0;
            states[(i+1) % states.length] = Integer.MIN_VALUE;
        }
        states[0] = 0;
        for (int price: prices){
            int sign = 1;
            for (int j=0; j<states.length-1; j+=1){
                states[j] = max(states[j], states[j+1] + sign * price);
                sign = -sign;
            }
        }
        return states[0];
    }

    // Any number of transactions, one at a time; one day's cool-down
    /* DP: time O(n); space(1) */
    public int maxProfitV(int[] prices){
        int cd = 0; // cool-down
        int acd = 0; // after cool-down, before buy
        int buy = Integer.MIN_VALUE; // buy
        int ab = Integer.MIN_VALUE; // after buy, before sell
        int sell = 0; // sell
        int tmp_buy;
        int tmp_ab;

        for (int price: prices){
            tmp_ab = ab;
            tmp_buy = buy;
            ab = max(ab, buy);
            buy = max(buy, max(cd, acd) - price);
            acd = max(acd, cd);
            cd = max(cd, sell);
            sell = max(sell, max(tmp_buy, tmp_ab) + price);
        }
        return max(sell, max(cd, acd));
    }

    public void printRes(int num){
        System.out.println(num);
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock bbss = new BestTimeToBuyAndSellStock();
        int[] inputs = new int[]{1,3,0,9,8,11};
        int res = bbss.maxProfitI(inputs);
        bbss.printRes(res);
        inputs = new int[]{8,9,12};
        res = bbss.maxProfitII(inputs);
        bbss.printRes(res);
        inputs = new int[]{1,15,2,16};
        res = bbss.maxProfitIII(inputs);
        bbss.printRes(res);
        res = bbss.maxProfitIIIOpt(inputs);
        bbss.printRes(res);
        res = bbss.maxProfitIV(2, new int[]{1,2});
        bbss.printRes(res);
        inputs = new int[]{1,2,3,0,2};
        res = bbss.maxProfitV(inputs);
        bbss.printRes(res);
    }
}
