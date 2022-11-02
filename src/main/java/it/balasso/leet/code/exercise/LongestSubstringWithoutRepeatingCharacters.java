package it.balasso.leet.code.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int maxValue = 0;

        int[] alreadyChecked = new int[512];

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char cRight = s.charAt(right);
            alreadyChecked[cRight] += 1;

            while (alreadyChecked[cRight] > 1) {
                char cLeft = s.charAt(left);
                alreadyChecked[cLeft] = alreadyChecked[cLeft] - 1;
                left++;
            }

            maxValue = Math.max(maxValue, right - left + 1);

            right++;
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
        result = lengthOfLongestSubstring("bbbbb");
        System.out.println(result);
        result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);

    }
}
