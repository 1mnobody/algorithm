package leetcode.two.sum;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int toBeFound = target - nums[i];
            Integer existed = container.get(toBeFound);
            if(existed != null) {
                res[0] = existed > i ? i : existed;
                res[1] = existed < i ? i : existed;
                return res;
            }
            container.put(nums[i], i);
        }
        return res;
    }

}
