// Amanda Beronilla (40228871) & Abdurrahim Gigani (40181121)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

public class MyHashMap {
    private MyLinkedList[] map;

    public MyHashMap(int size) {
        this.map = new MyLinkedList[size];
    }

    public void add(int key) {
        int index = key / 10_000;
        Element element = new Element(key);
        this.map[index].add(element);
    }

    public void add(int key, String value) {
        int index = key / 10_000;
        Element element = new Element(key, value);
        this.map[index].add(element);
    }

    public void add(Element element) {
        int index = element.getKey() / 10_000;
        this.map[index].add(element);
    }

    public void remove(int key) {
        int index = key / 10_000;
        this.map[index].remove(key);
    }

    public String getValues(int key) {
        int index = key / 10_000;
        return this.map[index].getValues(key);
    }

    public int rangeKey(int key1, int key2) {
        int result = 0;
        int index1 = Math.min(key1, key2) / 10_000;
        int index2 = Math.max(key1, key2) / 10_000;
        int parse = index2 - index1;
        for(int i = 0; i < parse; i++) {
            MyLinkedList list = this.map[i];
            result += list.rangeKey(Math.min(key1, key2), Math.max(key1, key2));
        }
        return result;
    }
}
