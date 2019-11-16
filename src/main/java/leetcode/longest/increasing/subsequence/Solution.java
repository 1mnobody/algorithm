package leetcode.longest.increasing.subsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // max[i] 以第i个元素开头并且 **第i个元素必须被选中** 的最长上升子序列值
        // dp完之后，max数组中的最大值就是nums的最长上升子序列值
        int[] max = new int[nums.length];
        max[nums.length - 1] = 1;
        int res = 1;
        for (int i = max.length - 2; i >= 0; i--) {
            max[i] = 1;
            for (int j = i + 1; j < max.length; j++) {
                if (nums[i] < nums[j]) {
                    max[i] = Math.max(max[j] + 1, max[i]);
                }
            }
            if (res < max[i]) res = max[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,6,7,9,4,10,5,6};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums));
    }
}