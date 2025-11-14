class LinkedList{
    int data;
    LinkedList next;
    LinkedList(int data){
        this.data = data;
        this.next = null;
    }
}
public class ReverseBetween {
    public static LinkedList reverseList(LinkedList head,int left,int right){
        LinkedList dummy = new LinkedList(0);
        dummy.next = head;

        LinkedList leftprev = dummy;
        LinkedList current = head;

        for(int i=0;i<left-1;i++){
            leftprev = leftprev.next;
            current = current.next;
        }

        LinkedList subList = current;
        LinkedList prev = null;

        for(int i=0; i<right-left;i++){
            LinkedList nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        leftprev.next = prev;
        subList.next = current;
        return dummy.next;
    }   
    public static void printList(LinkedList node){
        while(node!=null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);

        System.out.println("Original List:");
        printList(head);

        int left = 2, right = 4;
        head = reverseList(head, left, right);

        System.out.println("Reversed List between positions " + left + " and " + right + ":");
        printList(head);
    }
}
