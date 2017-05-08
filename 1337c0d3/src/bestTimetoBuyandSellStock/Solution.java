/**
Say you have an array for which the ith 
element is the price of a given stock on day i.

If you were only permitted to complete at most 
one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling 
price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.


Kadane's Algorithm
 * 
 */
package bestTimetoBuyandSellStock;

/**
 * @author han.chen
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int diff_cur = 0, diff_res = 0;;
        for(int i = 1; i<n;i++){
            diff_cur = Math.max(0, diff_cur += prices[i]-prices[i-1]);
            diff_res = Math.max(diff_cur, diff_res);
        }
        return diff_res;
    }
}
