package leetcode.subsets.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定的数组中可能包含相同的数字
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        res.add(emptyList);
        Arrays.sort(nums);
        sub(res, emptyList, nums, 0);
        return res;
    }

    public void sub(List<List<Integer>> res, List<Integer> preNums, int[] nums, int idx) {
        if (idx >= nums.length) {
            return;
        }
        // 取i从 idx 到 nums.length，先选择第i个数组成组合数，再选 i 后面的数字与当前的集合组成新的组合数
        for (int i = idx; i < nums.length; i++) {
            // nums已排序，如果在当前层次中找到上一次循环一样的数字，直接跳过找更后面的数字
            if (i - 1 >= idx && nums[i] == nums[i - 1]) {
                continue;
            }
            preNums.add(nums[i]);
            res.add(new ArrayList<>(preNums));
            sub(res, new ArrayList<>(preNums), nums, i + 1);
            preNums.remove(preNums.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2, 2}));
    }
}
