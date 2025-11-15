class ListNode{
    ListNode next;
    int data;
    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class RemovalofDuplicates {
    static ListNode removeDuplicates(ListNode head){
        if(head == null) return null;

        ListNode current = head;

        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    static void printList(ListNode node){
        while(node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] a){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
