package leetcode.maximum.subarray;

/**
 * Created by wuzhsh on 2019/3/31.
 */
public class Solution2 {

    Integer memory[];

    // 递归，记录结果（备忘录）
    public int maxSubArray(int[] nums) {
        memory = new Integer[nums.length];
        maxSubArray(nums, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < memory.length; i++) {
            max = max > memory[i] ? max : memory[i];
            System.out.println(i + "开头的最大子串值：" + memory[i]);
        }
        return max;
    }

    // 以第i个数字开头的最大子串值
    public int maxSubArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            memory[i] = nums[i];
        }

        if (memory[i] != null) {
            return memory[i];
        }

        // 以第i+1个数字开头的最大子串值
        if (memory[i + 1] == null) {
            memory[i + 1] = maxSubArray(nums, i + 1);
        }
        int maxSubForNext = memory[i + 1];
        memory[i] = maxSubForNext > 0 ? nums[i] + maxSubForNext : nums[i];
        return memory[i];
    }

    public static void main(String[] args) {
        int nums[] = {1};
        Solution2 s = new Solution2();
        System.out.println(s.maxSubArray(nums));
    }
}
