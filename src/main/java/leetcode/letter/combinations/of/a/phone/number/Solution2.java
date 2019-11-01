package leetcode.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzhsh on 2019/3/31.
 */
public class Solution2 {

    public static final Map<Character, String> digitToLetters = new HashMap<>();

    static {
        digitToLetters.put('1', "");
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        digitToLetters.put('0', " ");
    }

    List result = new ArrayList();

    public List<String> letterCombinations(String digits) {
        result.clear();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        combination(digits, 0, "");
        return result;
    }

    private void combination(String digits, int index, String prevLetters) {
        if (index == digits.length()) {
            result.add(prevLetters);
            return;
        }

        char currentDigit = digits.charAt(index);
        String letters = digitToLetters.get(currentDigit);
        for (int i = 0; i < letters.length(); i++) {
            combination(digits, index + 1, prevLetters + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<String> res = s.letterCombinations("23456");
        res.forEach(letters -> System.out.print(letters + " "));
        System.out.println();
    }
}
