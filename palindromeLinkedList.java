public class palindromeLinkedList{
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean isPalindrome(ListNode head){
        if( head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;

        while(secondHalf != null){
            if(firstHalf.data != secondHalf.data) return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public static void main(String[] args){
        // Create linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("The Linked List is a Palindrome");
        } else {
            System.out.println("The Linked List is NOT a Palindrome");
        }
    }
}