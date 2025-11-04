import java.util.InputMismatchException;
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
        LinkedList list = new LinkedList();
        String userChoice = null;
            do {
                int choice, data, index;
                Scanner input = new Scanner(System.in);
                System.out.println("1.Insert Beginning.");
                System.out.println("2.Insert Middle.");
                System.out.println("3.Insert Last.");
                System.out.println("4.Delete Node.");
                System.out.println("5.Display");
                System.out.print("Enter Your Choice : ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter a Value to Insert : ");
                        data = input.nextInt();
                        list.InsertBeginning(data);
                        break;
                    case 2:
                        System.out.println("Enter a Index : ");
                        index=input.nextInt();
                        System.out.print("Enter a Value to Insert : ");
                        data = input.nextInt();
                        list.InsertMiddle(index,data);
                        break;
                    case 3:
                        System.out.print("Enter a Value to Insert : ");
                        data = input.nextInt();
                        list.InsertLast(data);
                        break;
                    case 4:
                        System.out.println("Enter a Value to Delete :");
                        data=input.nextInt();
                        list.Delete(data);
                        break;
                    case 5:
                        list.Display();
                        break;
                    default:
                        System.err.print("Invalid Choice.");
                        break;
                }
                System.out.print("Do you want to continue (yes/no) :");
                userChoice = input.next();
            } while (userChoice.equalsIgnoreCase("yes"));
            
    }
}
