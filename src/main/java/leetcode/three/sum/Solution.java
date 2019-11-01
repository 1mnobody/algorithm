package leetcode.three.sum;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 当前数字与前一个数字相同，说明已经查过一次，不再计算
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 跳过重复数字
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    // 找到满足条件的一对数字，right-- 必然会导致总和减少，所以left++来增加总和
                    right--;
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> lists = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
