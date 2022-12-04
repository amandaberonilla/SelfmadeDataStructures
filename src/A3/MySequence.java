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

        public Element getElement() {
            return this.element;
        }

        public Node getPrev() {
            return this.prev;
        }

        public Node getNext() {
            return this.next;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public void setNext(Node node) {
            this.next = node;
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
        for(int i = 0; i < threshold; i++) {
            result[i] = node.getElement();
            node = node.next;
        }
        return result;
    }

    public int[] getKeys(int threshold) {
        int[] result = new int[threshold];
        Node node = this.head;
        for(int i = 0; i < threshold; i++) {
            result[i] = node.getElement().getKey();
            node = node.next;
        }
        return result;
    }

    public void add(int key) {
        Element element = new Element(key);
        this.add(element);
    }

    public void add(int key, String value) {
        Element element = new Element(key, value);
        this.add(element);
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
            this.head = new Node(element);
            return;
        }
        Node node = this.head;
        while(node != null) {
            if(node == this.tail) {
                this.add(element);
                return;
            }
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
    }

    public void remove(int key) {
        if(this.head.element.getKey() == key) {
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
        Node node = this.head;
        while(node != null) {
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
