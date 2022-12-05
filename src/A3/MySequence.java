// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

public class MySequence {
    class Node {
        private Element element;
        private Node prev;
        private Node next;

        public Node() {
            this.element = null;
            this.prev = null;
            this.next = null;
        }

        public Node(Element element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public MySequence() {
        this.head = new Node();
        this.tail = new Node();
    }

    public Element[] getElements(int threshold) {
        Element[] result = new Element[threshold];
        Node node = this.head;
        int i = 0;
        if(node.next == null) {
            return new Element[0];
        }
        node = node.next;
        while(node != this.tail) {
            result[i] = node.element;
            node = node.next;
            i++;
        }
        return result;
    }

    public int[] getKeys(int threshold) {
        int[] result = new int[threshold];
        Node node = this.head.next;
        int i = 0;
        if(node == null) {
            return new int[0];
        }
        while(node != this.tail) {
            result[i] = node.element.getKey();
            node = node.next;
            i++;
        }
        return result;
    }

    public void add(Element element) {
        Node node = new Node(element);
        if (this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            node.next = this.tail;
            this.tail.prev = node;
            return;
        }
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void sortedAdd(Element element) {
        if (this.head.next == null) {
            this.add(element);
            return;
        }
        Node node = this.head.next;
        while(node != this.tail) {
            if (element.getKey() < node.element.getKey()) {
                Node newNode = new Node(element);
                node.prev.next = newNode;
                newNode.prev = node.prev;
                newNode.next = node;
                node.prev = newNode;
                return;
            }
            node = node.next;
        }
        this.add(element);
    }

    public void remove(int key) {
        if(this.head.next != null && this.head.next.element.getKey() == key) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        Node node = this.head.next;
        while(node != this.tail) {
            if(node.element.getKey() == key) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return;
            }
            node = node.next;
        }
        System.out.println("Key not found.");
    }

    public String getValues(int key) {
        String result = "Key not found.";
        Node node = this.head.next;
        if(node == null) {
            return result;
        }
        while(node != this.tail) {
            if(node.element.getKey() == key) {
                result = node.element.getValue();
                break;
            }
            node = node.next;
        }
        return result;
    }

    public int rangeKey(int key1, int key2) {
        int result = 0;
        Node node = this.head.next;
        if(node == null) {
            return result;
        }
        while(node != this.tail) {
            if(node.element.getKey() >= key1 && node.element.getKey() <= key2) {
                result++;
            }
            node = node.next;
        }
        return result;
    }
}
