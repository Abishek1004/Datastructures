public class MiddleElement {
    static class LinkedList{
        int data;
        LinkedList next;
        LinkedList(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static  LinkedList MiddleValue (LinkedList head){
        LinkedList slow = head;
        LinkedList fast = head;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        l1.next = new LinkedList(2);
        l1.next.next = new LinkedList(3);

        MiddleElement.LinkedList center = MiddleValue(l1);

        System.out.print("Center Value is : "+center.data);
        
    }
}
