/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(a!=null && b!=null){
            if(a.val<b.val){
                temp.next=a;
                temp=a;
                a=a.next;
            }
            else{
                temp.next=b;
                temp=b;
                b=b.next;
            }
        }
        if(a!=null){
            temp.next=a;
        }
        else{
            temp.next=b;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode middle=findMiddle(head);
        ListNode nextMiddle=middle.next;
        middle.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(nextMiddle);
        
        return merge(left,right);
    }
}