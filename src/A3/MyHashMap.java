// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

public class MyHashMap {
    private MySequence[] map;

    public MyHashMap(int threshold) {
        this.map = new MySequence[threshold];
        for(int i = 0; i < this.map.length; i++) {
            this.map[i] = new MySequence();
        }
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
        for(int i = index1; i <= index2; i++) {
            if(i >= 10_000) {
                return result;
            }
            result += this.map[i].rangeKey(Math.min(key1, key2), Math.max(key1, key2));
        }
        return result;
    }
}
