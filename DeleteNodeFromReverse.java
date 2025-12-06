public class DeleteNodeFromReverse {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node DeleteNthNode(Node head,int n){
        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        for(int i=0;i<=n;i++){
            fast=fast.next;
            if (fast == null) return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    

    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.next = new Node(2);
        newNode.next.next = new Node(3);
        newNode.next.next.next = new Node(4);

        Node Display = DeleteNthNode(newNode,1);
        
        while (Display != null) {
            System.out.print(Display.data);
            if (Display.next != null) System.out.print(" -> ");
            Display= Display.next;
        }
        System.out.println();
    }
}
