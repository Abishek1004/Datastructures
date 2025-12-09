class Nodes {
    int data;
    Nodes prev;
    Nodes next;

    Nodes(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedListDemo {

    Nodes head;

    // INSERT at end
    public void insert(int data) {
        Nodes newNode = new Nodes(data);

        if (head == null) {   // first node
            head = newNode;
            return;
        }

        Nodes temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // DELETE a node (by value)
    public void delete(int key) {
        Nodes temp = head;

        // if head is the key
        if (temp != null && temp.data == key) {
            head = temp.next;
            if (head != null) head.prev = null;
            return;
        }

        // search the key
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) return; // not found

        // connect prev and next
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    // DISPLAY forward
    public void display() {
        Nodes temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();

        dll.insert(10);
        dll.insert(20);
        dll.insert(30);

        dll.display(); // 10 20 30

        dll.delete(20);

        dll.display(); // 10 30
    }
}
