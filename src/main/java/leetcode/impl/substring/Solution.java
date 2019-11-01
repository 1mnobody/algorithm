package leetcode.impl.substring;

/**
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    // Sunday算法
    public int strStr(String s, String t) {
        if(s == null || t == null) return -1;
        if("".equals(t)) return 0;
        int i = 0, j = 0, next = i + t.length();
        int length = 0;
        while( i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                j = t.length() - 1;
                while(j >= 0 && next < s.length() &&s.charAt(next) != t.charAt(j)) {
                    j --;
                }
                if (j == -1) { // -1 说明 needle 中不存在 haystack[next]
                    i = next + 1;
                } else {
                    // needle.length() - j 是needle后移的长度，减去length的原因：haystack中如果包含了needle的部分字符，
                    // 则i会往前移，比如下面的情况，i=8时，上下两个字符一致，i会前进一步。导致下面的表达式在设置i的值时直接
                    // 跳过了最后的字符“i”，但实际上，i应该指向最后一个字符
                    // mississippi
                    //         pi
                    i = i + t.length() - j - length;
                }
                next = i + t.length();
                j = 0; // j 归零，从头开始与i位置处的字符串开始比较
                length = 0;
            } else {
                i ++;
                j ++;
                if (++ length == t.length()) return i - t.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "mississippi";
        String b = "pi";
        Solution s = new Solution();
        System.out.println(s.strStr(a,b));
    }
}
