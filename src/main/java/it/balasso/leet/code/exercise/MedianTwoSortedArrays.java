package it.balasso.leet.code.exercise;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;

        boolean twoIndex = totalSize % 2 == 0;
        int indexToFind1 = (totalSize / 2) - 1;
        if (!twoIndex) {
            indexToFind1++;
        }
        int indexToFind2 = indexToFind1 + 1;

        int index1 = 0;
        int index2 = 0;

        int currentMergedIndex = 0;

        int firstValue = 0;
        int secondValue = 0;

        boolean found = false;

        while (!found && (index1 < nums1.length || index2 < nums2.length)) {
            if (index2 >= nums2.length || (index1 < nums1.length && nums1[index1] < nums2[index2])) {
                if (currentMergedIndex == indexToFind1) {
                    firstValue = nums1[index1];
                } else if (currentMergedIndex == indexToFind2) {
                    secondValue = nums1[index1];
                    found = true;
                }
                index1++;
            } else if (index1 >= nums1.length || (index2 < nums2.length && nums1[index1] >= nums2[index2])) {
                if (currentMergedIndex == indexToFind1) {
                    firstValue = nums2[index2];
                } else if (currentMergedIndex == indexToFind2) {
                    secondValue = nums2[index2];
                    found = true;
                }
                index2++;
            }
            currentMergedIndex++;
        }
        return twoIndex ? ((firstValue + secondValue) / 2d) : firstValue;
    }

    public static double findMedianSortedArraysWithLog(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        boolean twoIndex = totalSize % 2 == 0;

        int indexToFind1 = (totalSize / 2) - 1;
        if (!twoIndex) {
            indexToFind1++;
        }
        int indexToFind2 = indexToFind1 + 1;

        int index1 = nums1.length / 2;
        int index2 = nums2.length / 2;

        int firstValue = 0;
        int secondValue = 0;

        boolean found = false;

        while (!found) {
            
        }

        return twoIndex ? ((firstValue + secondValue) / 2d) : firstValue;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,3};

        int[] nums2 = new int[] {2,4};

        double result = findMedianSortedArrays(nums1, nums2);

        System.out.println(result);

    }
}
