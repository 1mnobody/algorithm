package leetcode.maximum.subarray;

/**
 * 求最大连续子串的值
 * Created by wuzhsh on 2019/3/31.
 */
public class Solution {

    // 递归
    public int maxSubArray(int[] nums) {
        int res[] = new int[nums.length];
        for (int i=0; i<nums.length; i++)
            res[i] = maxSubArray(nums, i);

        int max = Integer.MIN_VALUE;
        for (int r : res) {
            max = max > r ? max : r;
        }
        return max;
    }

    // 以第i个数字开头的最大子串值
    public int maxSubArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            return nums[i];
        }

        // 以第i+1个数字开头的最大子串值
        int res = maxSubArray(nums, i + 1);
        // 如果以 第i+1个数字开头的最大子串大于零，那么以i开头的最大子串直接加上 i+1个数字开头的最大子串，就是 以第i个数字开头
        // 的最大子串值
        if (res > 0) {
            return res + nums[i];
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(nums));
    }
}
