package leetcode.reverse.integer;

/**
 * 翻转一个数字，溢出时返回0
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int tmp = x > 0 ? x : -x;
        int res = 0;
        int bound = Integer.MAX_VALUE / 10;
        int r;
        while(tmp != 0) {
            r = res * 10;
            if (bound < res) return 0;
            res = r + tmp % 10;
            tmp /= 10;
        }
        if (res < 0) return 0;
        if (x < 0) res = -res;
        return res;
    }

}
