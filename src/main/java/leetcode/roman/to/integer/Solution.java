package leetcode.roman.to.integer;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class Solution {

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            res += symbolToValue(cs[i]);
            int needToMinus = leftSum(cs, i);
            res -= 2*needToMinus;
        }
        return res;
    }

    private int leftSum(char[] cs, int idx) {
        int res = 0;
        if (cs[idx] == 'V' || cs[idx] == 'X') {
            int i = idx;
            while(i >= 1 && cs[--i] == 'I') {
                res += 1;
            }
        }
        if (cs[idx] == 'L' || cs[idx] == 'C') {
            int i = idx;
            while(i >= 1 && cs[--i] == 'X') {
                res += 10;
            }
        }
        if (cs[idx] == 'D' || cs[idx] == 'M') {
            int i = idx;
            while(i >= 1 && cs[--i] == 'C') {
                res += 100;
            }
        }
        return res;
    }

    private int symbolToValue(char c) {
        switch (c) {
            case ('I'):
                return 1;
            case ('V'):
                return 5;
            case ('X'):
                return 10;
            case ('L'):
                return 50;
            case ('C'):
                return 100;
            case ('D'):
                return 500;
            case ('M'):
                return 1000;
            default:
                throw new RuntimeException("error param");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
    }


    static int[] map = new int[91];
    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }
    public int romanToInt2(String s) {
        char[] chars = s.toCharArray();
        map[2] = 0;
        map[1] = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            map[0] = map[chars[i]];
            if (map[0] >= map[1]) {
                map[1] = map[0];
                map[2] += map[0];
            } else {
                map[2] -= map[0];
            }
        }
        return map[2];
    }
}
