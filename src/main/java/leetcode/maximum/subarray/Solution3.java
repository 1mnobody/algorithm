package leetcode.maximum.subarray;

/**
 * Created by wuzhsh on 2019/3/31.
 */
public class Solution3 {

    // 动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] = nums[i + 1] > 0 ? nums[i] + nums[i + 1] : nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = max > num ? max : num;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2};
        Solution3 s = new Solution3();
        System.out.println(s.maxSubArray(nums));
    }
}
