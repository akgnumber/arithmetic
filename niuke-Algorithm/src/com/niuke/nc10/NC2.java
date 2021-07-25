package com.niuke.nc10;

import java.util.ArrayList;
import java.util.List;

public class NC2 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {

        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int i = 0,j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j)
                    break;
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;  // 最后一个节点的下一个节点为null
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Solution solution = new Solution();
        solution.reorderList(listNode1);
//        System.out.println(listNode1.next.next.val);
    }
}
