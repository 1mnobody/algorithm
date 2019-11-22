package leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 子集的产生，包含以下规律：
    // [1,2,3] 首先要包含空集[]，再取出第一个元素1,加到已有的子集中得到[1]，与之前空集组成新的结果：[ [],[1] ]
    // 再取出元素2，在已有结果的所有子集中加入2，得到两个子集[2],[1,2]，生成新的结果[ [],[1],[2],[1,2] ]
    // 再取3，得到[ [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3] ]
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> tmp = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.stream(nums).forEach(i -> {
            res.forEach(list -> {
                List<Integer> toAdded = new ArrayList<>(list);
                toAdded.add(i);
                tmp.add(toAdded);
            });
            res.addAll(tmp);
            tmp.clear();
        });
        return res;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        res.add(emptyList);
        _subsets3(res, emptyList, nums, 0);
        return res;
    }

    public void _subsets3(List<List<Integer>> res, List<Integer> preNums, int[] nums, int idx) {
        if (idx >= nums.length) {
            return;
        }
        // 取i从 idx 到 nums.length，先选择第i个数组成组合数，再选 i 后面的数字与当前的集合组成新的组合数
        for (int i = idx; i < nums.length; i++) {
            preNums.add(nums[i]);
            res.add(new ArrayList<>(preNums));
            _subsets3(res, preNums, nums, i + 1);
            preNums.remove(preNums.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets3(new int[]{1,2,3}));
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
}