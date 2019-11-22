package leetcode.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * note:
 * 1. All numbers (including target) will be positive integers.
 * 2. The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * Created by wuzhsh on 11/22/2019.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) return res;
        combinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void combinationSum(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int target, int idx) {
        if (target <= 0) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            combinationSum(res, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{1, 2, 3, 4, 5}, 8));
    }

    // combination sum II, 这两题跟 subsets subsets II基本是一毛一样，只是subsets会打印所有可能
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) return res;
        Arrays.sort(candidates);
        combinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void combinationSumII(List<List<Integer>> res, ArrayList<Integer> tmp, int[] candidates, int target, int idx) {
        if (target <= 0) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.add(candidates[i]);
            combinationSum(res, tmp, candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
