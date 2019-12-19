package leetcode.target.sum;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 */
public class Solution {

    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        if (nums == null || nums.length == 0) return res;
        _findTargetSumWays(nums, S, 0);
        return res;
    }

    public void _findTargetSumWays(int[] nums, int S, int idx) {
        if (S == 0 && idx == nums.length) {
            res++;
            return;
        }
        if (idx < nums.length) {
            _findTargetSumWays(nums, S - nums[idx], idx + 1);
            _findTargetSumWays(nums, S + nums[idx], idx + 1);
        }
    }
}
