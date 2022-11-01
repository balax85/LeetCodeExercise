package it.balasso.leet.code.exercise;

import it.balasso.leet.code.exercise.support.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode = null;
        ListNode currentListNode = null;

        int moreTen = 0;
        while (l1 != null || l2 != null || moreTen > 0) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum += l1.val;
                sum += l2.val;
            } else if (l1 != null) {
                sum += l1.val;
            } else if (l2 != null) {
                sum += l2.val;
            }
            sum += moreTen;
            if (sum >= 10) {
                moreTen = sum / 10;
                sum = sum % 10;
            } else {
                moreTen = 0;
            }

            if (currentListNode == null) {
                currentListNode = new ListNode(sum);
                resultListNode = currentListNode;
            } else {
                ListNode tmp = new ListNode(sum);
                currentListNode.next = tmp;
                currentListNode = currentListNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }


        return resultListNode;

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode();
        l11.val = 2;
        ListNode l12 = new ListNode();
        l12.val = 4;
        ListNode l13 = new ListNode();
        l13.val = 3;
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode();
        l21.val = 5;
        ListNode l22 = new ListNode();
        l22.val = 6;
        ListNode l23 = new ListNode();
        l23.val = 4;
        l21.next = l22;
        l22.next = l23;

        ListNode result = addTwoNumbers(l11, l21);

        ListNode currentNode = result;
        while (currentNode != null) {
            System.out.print(currentNode.val);
            currentNode = currentNode.next;
        }

    }

}
