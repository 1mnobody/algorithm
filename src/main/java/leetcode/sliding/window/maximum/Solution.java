package leetcode.sliding.window.maximum;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 * 注：假设 0 < k <= 数组的大小
 * Created by wuzhsh on 11/1/2019.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] res = solution1(new int[]{1, -1}, 1);
//        Arrays.stream(res).forEach(System.out::println);
        int[] res2 = solution2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Arrays.stream(res2).forEach(System.out::println);
    }

    // 使用优先队列，窗口中的数据是排好序的，直接取队首位置的最大值
    static int[] solution1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);
        for (int i = 0; i < nums.length; i++) {
            // 超过的窗口的容量，删掉掉窗口中的第一个数字
            if (i >= k) {
                priorityQueue.remove(nums[i - k]);
            }
            priorityQueue.add(nums[i]);
            // 遍历到 k-1时，窗口中才拥有了k个数字，选出最大值放到结果数组中
            if (i >= k - 1) {
                res[i - k + 1] = priorityQueue.peek();
            }
        }
        return res;
    }

    // 题中保证了k是合理的范围，所以不再做检测
    // left指向窗口第一个数字，right指向窗口的最后一个数字，left指向的永远是窗口中的最大值
    // 这么做的原因是，如果left左边还有更小的数字，在窗口右移时，不会对窗口中数字的大小判断造成影响，
    // 所以在left左边更小的数字直接可以忽略，当窗口大小达到k时，left必须右移了，
    // 即窗口的最大值信息要被丢失了，这个时候要再找一下窗口中的最大值。
    static int[] solution2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        // 初始状态，窗口还差一个元素就满了，下一个元素进入导致窗口塞满时，开始产生第一个结果
        int left = -1, right = k - 2, i = 0;
        while (right + 1 < nums.length) {
            right++;
            if (left >= 0 && nums[right] > nums[left]) {
                left = right;
            }
            if (right - left > k - 1) {
                // 窗口元素个数要保持在k个，右边移动了，左边跟着移动
                left++;
                for (int c = left; c <= right; c++) {
                    if (nums[left] < nums[c]) {
                        left = c;
                    }
                }
            }
            res[i++] = nums[left];
        }
        return res;
    }
}
