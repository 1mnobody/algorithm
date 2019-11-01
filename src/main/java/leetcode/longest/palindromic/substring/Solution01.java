package leetcode.longest.palindromic.substring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 暴力解法
 * Created by wuzhsh on 2019/4/16.
 */
public class Solution01 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String tmp = s.substring(i, j + 1);
                if (isPalindrome(tmp) && tmp.length() >= res.length()) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            if (cs[i++] != cs[j--]) {
                return false;
            }
        }
        return true;
    }

}
