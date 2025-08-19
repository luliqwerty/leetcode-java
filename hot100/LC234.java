package hot100;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        // double pointer
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
