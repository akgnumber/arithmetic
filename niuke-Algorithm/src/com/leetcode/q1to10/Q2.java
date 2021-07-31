package com.leetcode.q1to10;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 *   请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 *   你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *   输入：l1 = [2,4,3], l2 = [5,6,4]
 *   输出：[7,0,8]
 *   解释：342 + 465 = 807.
 */
public class Q2 {

    
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 力扣官方解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null; int carry = 0;
        while (l1!= null || l2!=null) {
            int n1 = l1 == null? 0 :l1.val;
            int n2 = l2 == null? 0 :l2.val;
            int sum = n1 +n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum%10);
            } else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry >0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    /**
     * 自己写答案
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList();
        list1.add(l1.val);
        while (l1.next != null) {
            list1.add(l1.next.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList();
        list2.add(l2.val);
        while (l2.next != null) {
            list2.add(l2.next.val);
            l2 = l2.next;
        }
        boolean carry = false; int largeSize,minSize; List<Integer> largeList;
        if (list1.size() > list2.size()) {
            largeSize = list1.size();
            minSize = list2.size();
            largeList = list1;
        } else {
            largeSize = list2.size();
            minSize = list1.size();
            largeList = list2;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < largeSize; i++) {
            if (i >= minSize) {
                int num = carry ? largeList.get(i) +1 : largeList.get(i);
                stringBuilder.insert(0,num%10);
                if (num <10) {
                    carry = false;
                } else {
                    carry = true;
                }
            }
            int num = carry ?list1.get(i) + list2.get(i)+1:list1.get(i) + list2.get(i);
            stringBuilder.insert(0,num%10);
            if (num >= 10) {
                carry = true;
            } else {
                carry =false;
            }
        }
        if (carry) {
            stringBuilder.insert(0,1);
        }
        ListNode listNode = new ListNode();
        listNode.val = Integer.valueOf(stringBuilder.substring(stringBuilder.length()-1,stringBuilder.length()));
        ListNode temp = listNode;
        for (int i = stringBuilder.length() -1; i > 0; i--) {
            int val = Integer.valueOf(stringBuilder.substring(i-1,i));
            temp.next = new ListNode(val) ;
            temp = temp.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        ListNode l1 = new ListNode(2);
        l1.val = 2;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.val = 5;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = q2.addTwoNumbers(l1,l2);
        System.out.println(res.val + "" + res.next.val + res.next.next.val);

    }

}
