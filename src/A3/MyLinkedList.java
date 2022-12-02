// Amanda Beronilla (40228871) & Abdurrahim Gigani (40181121)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

public class MyLinkedList {
    class Node {
        private Element element;
        private Node next;

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(Element element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(Element element) {
        if (this.head == null) {
            this.head = new Node(element);
        }
        else {
            Node node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node(element);
        }
    }

    public void remove(int key) {
        if(this.head.element.getKey() == key) {
            this.head = this.head.next;
            return;
        }
        Node node = this.head;
        while(node.next != null) {
            if(node.next.element.getKey() == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public String getValues(int key) {
        String result = "Key not found.";
        Node node = this.head;
        while(node.next != null) {
            if(node.element.getKey() == key) {
                result = node.element.getValue();
            }
            node = node.next;
        }
        return result;
    }

    public int rangeKey(int key1, int key2) {
        int result = 0;
        Node node = this.head;
        while(node.next != null) {
            if(node.element.getKey() > key1 && node.element.getKey() < key2) {
                result++;
            }
            node = node.next;
        }
        return result;
    }
}
