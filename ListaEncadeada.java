class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ListaEncadeada {
    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Posição Inválida!");
            return;
        }

        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Posição Inválida!");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        lista.display(); // Saída: 1->2->3->null

        lista.addFirst(0);
        lista.display(); // Saída: 0->1->2->3->null

        lista.addLast(4);
        lista.display(); // Saída: 0->1->2->3->4->null

        lista.insertAtPosition(5, 2);
        lista.display(); // Saída: 0->1->5->2->3->4->null

        lista.insertAtPosition(6, 0);
        lista.display(); // Saída: 6->0->1->5->2->3->4->null

        lista.insertAtPosition(7, 7);
        lista.display(); // Saída: 6->0->1->5->2->3->4->7->null

        lista.insertAtPosition(8, 10); // Posição inválida
    }
}