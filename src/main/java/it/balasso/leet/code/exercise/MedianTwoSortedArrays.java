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

    private static double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k - 1];
        }

        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k - 1];
        }

        // can't divide another time
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int midVal1 = Integer.MAX_VALUE;
        int midVal2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) {
            midVal1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            midVal2 = nums2[start2 + k / 2 - 1];
        }

        if (midVal1 < midVal2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }

    }

    public static double findMedianSortedArraysWithLog(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median

        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public static double findMedianSortedArraysWithLogWithOutRecursion(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median

        int start1 = 0;
        int start2 = 0;
        int k = l;

        int value1 = 0;

        while (start1 < nums1.length || start2 < nums2.length) {
            // If nums1 is exhausted, return kth number in nums2
            if (start1 > nums1.length - 1) {
                value1 = nums2[start2 + k - 1];
                break;
            }

            // If nums2 is exhausted, return kth number in nums1
            if (start2 > nums2.length - 1) {
                value1 = nums1[start1 + k - 1];
                break;
            }

            // can't divide another time
            if (k == 1) {
                value1 =  Math.min(nums1[start1], nums2[start2]);
                break;
            }

            int midVal1 = Integer.MAX_VALUE;
            int midVal2 = Integer.MAX_VALUE;
            if (start1 + k / 2 - 1 < nums1.length) {
                midVal1 = nums1[start1 + k / 2 - 1];
            }
            if (start2 + k / 2 - 1 < nums2.length) {
                midVal2 = nums2[start2 + k / 2 - 1];
            }

            if (midVal1 < midVal2) {
                start1 = start1 + k / 2;
                k = k - k / 2;
            } else {
                start2 = start2 + k / 2;
                k = k - k / 2;
            }
        }

        start1 = 0;
        start2 = 0;
        k = r;

        int value2 = 0;

        while (start1 < nums1.length || start2 < nums2.length) {
            // If nums1 is exhausted, return kth number in nums2
            if (start1 > nums1.length - 1) {
                value2 = nums2[start2 + k - 1];
                break;
            }

            // If nums2 is exhausted, return kth number in nums1
            if (start2 > nums2.length - 1) {
                value2 = nums1[start1 + k - 1];
                break;
            }

            // can't divide another time
            if (k == 1) {
                value2 =  Math.min(nums1[start1], nums2[start2]);
                break;
            }

            int midVal1 = Integer.MAX_VALUE;
            int midVal2 = Integer.MAX_VALUE;
            if (start1 + k / 2 - 1 < nums1.length) {
                midVal1 = nums1[start1 + k / 2 - 1];
            }
            if (start2 + k / 2 - 1 < nums2.length) {
                midVal2 = nums2[start2 + k / 2 - 1];
            }

            if (midVal1 < midVal2) {
                start1 = start1 + k / 2;
                k = k - k / 2;
            } else {
                start2 = start2 + k / 2;
                k = k - k / 2;
            }
        }


        return (value1 + value2) / 2.0;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {1,3};

        int[] nums2 = new int[] {2,4};

        double result = findMedianSortedArraysWithLogWithOutRecursion(nums1, nums2);

        System.out.println(result);

    }
}
