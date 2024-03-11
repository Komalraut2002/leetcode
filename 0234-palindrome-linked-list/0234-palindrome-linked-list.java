// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {}

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode current = head;

        while (current != null) {
            st.push(current);
            current = current.next;
        }

        while (!st.isEmpty()) {
            ListNode poppedNode = st.pop();
            if (poppedNode.val != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
