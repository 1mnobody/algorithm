package leetcode.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个数字，对应多个字符（手机上的九宫格输入法），给定一个数字串，返回该数字串可能对应的所有字符串
 * Created by wuzhsh on 2019/3/31.
 */
public class Solution {

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


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        return combinations(digits, 0, "");
    }

    // 从digits的第start位开始，获取对应的digits对应的字符串
    private List<String> combinations(String digits, int start, String prevLetter) {
        List<String> arr = new ArrayList<>();
        if (start >= digits.length()) {
            arr.add(prevLetter);
            return arr;
        }
        String letters = digitToLetters.get(digits.charAt(start));
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            arr.addAll(combinations(digits, start + 1, prevLetter + letter + ""));
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.letterCombinations("23456");
        res.forEach(letters -> System.out.print(letters + " "));
        System.out.println();
    }
}
