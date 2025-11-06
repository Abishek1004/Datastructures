import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    Node head = null;
    void InsertBeginning(int data){
        Node newNode= new Node(data);
        newNode.next=head;
        head = newNode;
        System.out.println("Value Inserted.");
    }

    void InsertMiddle(int index,int data){
        if(index<0){
            System.out.println("Invalid Index.");
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next = newNode;
        System.out.println("Value Inserted.");
    }


    void InsertLast(int data){
        if(head==null){
            InsertBeginning(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Value Inserted at last.");
    }

    void Delete(int data){
        Node temp=head;
        if(head.data == data){
            head = head.next;
            return;
        }
        while(temp.next!=null && temp.next.data!=data){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Invalid index ");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Node with value "+data+" deleted.");
    }

    void deleteIndex(int index){
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        System.out.println("Node deleted at index "+index);
    }

    void search(int data){
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                System.out.println("Value found in the list.");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Value not found in the list.");  
    }

    void Reverse(){
        Node prev = null;
        Node current = head;
        Node next=null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void Display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // your custom LinkedList class
        Scanner input = new Scanner(System.in);
        int choice = 0;
        try{
            do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert in Middle");
            System.out.println("3. Insert at End");
            System.out.println("4. Delete By Value");
            System.out.println("5. Delete at Index");
            System.out.println("6. Search Node");
            System.out.println("7. Reverse List");
            System.out.println("8. Display List");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            int data, index;

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to insert: ");
                    data = input.nextInt();
                    list.InsertBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter an index: ");
                    index = input.nextInt();
                    System.out.print("Enter a value to insert: ");
                    data = input.nextInt();
                    list.InsertMiddle(index, data);
                    break;

                case 3:
                    System.out.print("Enter a value to insert: ");
                    data = input.nextInt();
                    list.InsertLast(data);
                    break;

                case 4:
                    System.out.print("Enter a value to delete: ");
                    data = input.nextInt();
                    list.Delete(data);
                    break;

                case 5:
                    System.out.println("Enter an index to delete: ");
                    index=input.nextInt();
                    list.deleteIndex(index);
                    break;

                case 6:
                    System.out.print("Enter a value to search: ");
                    data = input.nextInt();
                    list.search(data);
                    break;

                case 7:
                    list.Reverse();
                    System.out.println("List Reversed.");
                    break;
                case 8:
                    list.Display();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
        input.close();
        }catch(Exception e){
            System.err.println("Invalid input. Please enter numeric values only.");
            input.next(); 
        }
    }
}