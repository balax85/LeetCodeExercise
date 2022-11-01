package it.balasso.leet.code.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                if (i < index) {
                    return new int[] {i, index};
                } else {
                    return new int[] {index, i};
                }

            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array = new int[] {2, 7 , 11, 15};
        int[] result = twoSum(array, 99);
        System.out.println("Result -> " + Arrays.toString(result));

        array = new int[] {-3,4, 3, 90};
        result = twoSum(array, 0);
        System.out.println("Result -> " + Arrays.toString(result));




    }
}
