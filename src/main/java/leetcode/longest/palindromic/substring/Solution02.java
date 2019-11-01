package leetcode.longest.palindromic.substring;

/**
 * Created by wuzhsh on 2019/4/16.
 */
public class Solution02 {

    /**
     * 动态规划：f[i][j] 的意义是 从[i,j]区间的字符串是回文串
     * f[x][x] = true  一个字母必定是回文串
     * f[x][x+1] = true when f[x]==f[x+1] 两个相连的一样的字母是回文串
     * f[x][y] = true when f[x+1][y-1] = true and f[x]==f[y] 如果[x+1,y-1]区间是一个回文串 且 此串的前一个字符与后一个字符相等，
     * 则包含前后字符的串也是回文串。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] f = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int j = 0; j < s.length(); j++) {
            f[j][j] = true;
            for (int i = 0; i < j; i++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || f[i+1][j-1]);
                if (f[i][j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "aaa";
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.longestPalindrome(s));
    }
}
