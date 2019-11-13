package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，求该数组的子集
 * 如：[1,2,3]
 * 输出
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subs(res, null, nums, 0);
        return res;
    }

    // 遍历数组，每个数都有两种情况，1.放入subset中, 2.不放入subset中，
    // 以此思想可以形成一个二叉树结构，叶子结点就是所有的subset
    public void subs(List<List<Integer>> res, List<Integer> list, int[] nums, int i) {
        if (i == nums.length) {
            if (list == null) list = new ArrayList<>();
            res.add(list);
            return;
        }
        // nums[i]不加入list，直接进入下一个数的处理
        subs(res, list, nums, i + 1);
        // nums[i]加入list后，再处理下一个数（注意要换个实例，不同的subset不能是同一个实例）
        List<Integer> addToList = new ArrayList<>();
        if (list != null) {
            addToList.addAll(list);
        }
        addToList.add(nums[i]);
        subs(res, addToList, nums, i + 1);
    }
}
