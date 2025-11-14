class List{
    int data;
    List next;
    List(int d){
        data = d;
        next = null;
    }
}
public class sample {
    static void intersection(List head1, List head2){
        List ptr1 = head1;
        while(ptr1 != null){
            List ptr2 = head2;
            while(ptr2 != null){
                if(ptr1 == ptr2){
                    System.out.println("Intersection at node with data: " + ptr1.data);
                    return;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
        System.out.println("No intersection found.");
    }
    static void printList(List node){
        while(node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        List head1 = new List(1);
        head1.next = new List(2);
        head1.next.next = new List(3);

        List head2 = new List(4);
        head2.next = new List(5);
        head2.next.next = head1.next; // Creating intersection at node with data 2

        printList(head1);
        printList(head2);
        intersection(head1, head2);
    }
}
