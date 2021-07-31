package com.niuke.nc10;

import java.util.HashSet;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 */
public class NC3 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet listNodes = new HashSet();
        ListNode cur = pHead;
        while (cur != null) {
            if (listNodes.contains(cur)) {
                return cur;
            }
            listNodes.add(cur);
            cur = cur.next;
        }
        return null;
    }

}
