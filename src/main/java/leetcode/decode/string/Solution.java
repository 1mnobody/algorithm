package leetcode.decode.string;

import java.util.Stack;

/**
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * <p>
 * Created by wuzhsh on 2019/4/1.
 */
public class Solution {

    public static String decodeString(String string) {
        int idx = 0, length = string.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        char cur;
        // res中保存的是当前已经展开的字符串
        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder();
        while(idx < length) {
            cur = string.charAt(idx);
            if (Character.isDigit(cur)) {
                num.append(cur);
            } else if (cur == '[') {
                numStack.push(Integer.valueOf(num.toString()));
                strStack.push(res.toString());
                res = new StringBuilder();
                num = new StringBuilder();
            } else if (cur == ']') {
                String tmp = strStack.pop();
                int repeatTimes = numStack.pop();
                while (repeatTimes-- > 0) {
                    tmp += res.toString();
                }
                res = new StringBuilder(tmp);
            } else {
                res.append(cur);
            }
            idx ++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("cc2[abc]3[cd]ef"));
    }
}
