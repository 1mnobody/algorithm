package leetcode.valid.parentheses;

/**
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    public boolean isValid(String s) {
        char[] stack = new char[s.length() / 2 + 1];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c == '(' || c == '[' || c == '{') {
                stack[++ top] = c;
            }
            if (c == ')' && (top == -1 || (top >= 0 && stack[top --] != '('))) {
                return false;
            }
            if (c == ']' && (top == -1 || (top >= 0 && stack[top --] != '['))) {
                return false;
            }
            if (c == '}' && (top == -1 || (top >= 0 && stack[top --] != '{'))) {
                return false;
            }
        }
        if (top > -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("{{}"));
    }
}
