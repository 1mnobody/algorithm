package leetcode.remove.duplicates.from.sorted.array;

/**
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int prev = 0, cur = 0;
        for (;cur < nums.length; cur ++) {
            if(nums[prev] != nums[cur]) {
                nums[++prev] = nums[cur];
            }
        }
        return prev + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution s = new Solution();
        int i = s.removeDuplicates(nums);
        for(int j=0; j<i; j++) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();
    }
}
