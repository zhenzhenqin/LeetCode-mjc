package LeeCode;


/**
 * 160. 相交链表
 * 2025.10.30
 */
public class main160 {

    /**
     * 思路：
     * 关于张小姐的思路：
     * 1. 遍历两个链表，获取长度
     * 2. 让较长的指针先移动到与较短的链表相同长度的位置
     * 3. 然后让两个指针同时移动，直到遇到相同的节点
     */

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //遍历两个链表 获取长度
            int lenA = 0;
            int lenB = 0;

            ListNode l1 = headA;
            ListNode l2 = headB;

            while(l1 != null){
                lenA++;
                l1 = l1.next;
            }
            while(l2 != null){
                lenB++;
                l2 = l2.next;
            }

            //重置指针
            l1 = headA;
            l2 = headB;

            //先让较长的走到相同长度的位置
            if(lenA > lenB){
                while (lenA > lenB){
                    l1 = l1.next;
                    lenA--;
                }
            }else{
                while (lenA < lenB){
                    l2 = l2.next;
                    lenB--;
                }
            }

            //然后两个指针一起走 直到相交
            while(l1 != l2){
                l1 = l1.next;
                l2 = l2.next;
            }

            return l1;

        }
    }


    /**
     * 另一种思路（灵活）：
     * 1.先一起遍历两个链表， 如果第一次遍历完没有相交，则遍历完之后，将两个链表重新指向另一个链表的头节点，重复
     * 如：
     * a,b,c
     * e,f,g,h
     * 则距离上就是：
     * a,b,c,e,f,g,h
     * e,f,g,h,a,b,c
     * 这样子距离一样，如果相等则一定相交
     *
     * 距离不相等就算两个节点相等也不一定会相交
     * 如
     * a b c
     * e f g c
     * 就算在c会相交 但是如果距离不相等的话 是无法判断的
     * 但是
     * a b c e f g c
     * e f g c a b c
     */
    static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode left = headA;
            ListNode right = headB;
            while(left != right){
                left = left == null ? headB : left.next;
                right = right == null ? headA : right.next;
            }
            return left;
        }
    }





    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
