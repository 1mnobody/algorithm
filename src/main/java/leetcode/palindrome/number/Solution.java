package leetcode.palindrome.number;

/**
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    public boolean isPalindrome(int x) {
        String xStr = x + "";
        int i = 0, j = xStr.length() - 1;
        while(i <= j) {
            if(xStr.charAt(i++) != xStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(11));
    }
}
