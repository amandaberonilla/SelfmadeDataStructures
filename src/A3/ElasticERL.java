// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.util.Random;

public class ElasticERL {
    private Object ADT;
    private int ADTSize;
    private int threshold;
    private int size;
    private MySequence stack;
    private MySequence sortedStack;


    public ElasticERL() {
        this(0);
    }


    public ElasticERL(int size) {
        this.size = size;
        this.SetEINThreshold(size);
        this.stack = new MySequence();
        this.sortedStack = new MySequence();
    }


    private void addToStacks(Element element) {
        this.stack.add(element);
        this.sortedStack.sortedAdd(element);
        this.size++;
    }


    private void removeFromStacks(Element element) {
        this.stack.remove(element.getKey());
        this.sortedStack.remove(element.getKey());
        this.size--;
    }


//    SetEINThreshold (Size): where 100 ≤ Size ≤ ~500,000 is an integer number that defines the size of the list. This size is very important as it will determine what data types or data structures will be used (i.e. a Tree, Hash Table, AVL tree, binary tree, sequence, etc.);
    public void SetEINThreshold(int threshold) {
//        Setting attributes
        if(threshold > 500_000) {
            System.out.println("Argument passed is too large. Threshold set to 500 000.");
            this.threshold = 500_000;
        }
        else if(threshold < 100) {
            System.out.println("Argument passed is too small. Threshold set to 100.");
            this.threshold = 100;
        }
        else {
            this.threshold = threshold;
        }
//        If size is smaller, use a sequence
        if(this.threshold <= 1_000) {
            this.ADTSize = 1_000;
            MySequence seq = new MySequence();
            if(this.stack != null && this.stack.getElements(this.size).length != 0) {
                for(Element element : this.stack.getElements(this.size)) {
                    seq.add(element);
                }
            }
            this.ADT = seq;
        }
//        If the size is larger, use a hashmap
        else {
            MyHashMap hash = new MyHashMap(10_000);
            this.ADTSize = 10_000;
            if(this.stack != null && this.stack.getElements(this.size).length != 0) {
                for(Element element : this.stack.getElements(this.size)) {
                    hash.add(element);
                }
            }
            this.ADT = hash;
        }
    }


//    generate(): randomly generates new non-existing key of 8 digits;
    public int generate() {
//        Setting up variables
        int result;
        StringBuilder generate = new StringBuilder();
        Random random = new Random();
//        Looping 8 times to get a random digit and adding it to the key
        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(10);
            generate.append(index);
        }
        result = Integer.parseInt(generate.toString());
//        Checking if the key already exists
        if(this.stack != null && this.stack.getElements(this.size).length != 0) {
            for (Element element : this.stack.getElements(this.threshold)) {
                if (element != null && element.getKey() == result) {
                    return generate();
                }
            }
        }
        return result;
    }


//    allKeys(ElasticERL): return all keys in ElasticERL as a sorted sequence;
    public int[] allKeys() {
        if(this.sortedStack.getElements(this.threshold).length == 0) {
            return new int[0];
        }
        return this.sortedStack.getKeys(this.threshold);
    }

//    add(ElasticERL,key,value2): add an entry for the given key and value;
    public void add(int key, String value) {
//        Checking if we cross the threshold
        if(this.size >= this.threshold) {
            System.out.println("Size surpasses threshold. Kindly resize.");
            return;
        }
//        Setting variables
        Element element;
        if(value.equals("")) {
            element = new Element(key);
        }
        else {
            element = new Element(key, value);
        }
//        Calling add() from either Sequence or HashMap
        if(this.threshold < 1_000) {
            ((MySequence)this.ADT).add(element);
        }
        else {
//            If the ADT size is 1000, then we currently have a sequence. When we add an element, we cross the
//            threshold bound, so we set the threshold and use a hashmap to avoid this issue.
            if(this.ADTSize == 1_000) {
                this.SetEINThreshold(1_001);
            }
            ((MyHashMap)this.ADT).add(element);
        }
//        Adding the element to the stack
        this.addToStacks(element);
    }


//    remove(ElasticERL,key): remove the entry for the given key;
    public void remove(int key) {
//        Checking if we cross 0
        if(this.size <= 0) {
            System.out.println("Size too low. Kindly add before removing.");
            return;
        }
//        Setting variables
        Element element = new Element(key);
//        Calling remove() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(this.size <= 1_001) {
//            If the ADT size is not 1000, then we currently have a hashmap. When we remove an element, we cross the
//            threshold bound, so we set the threshold and use a sequence to avoid this issue.
            if(this.ADTSize != 1_000) {
                this.SetEINThreshold(1_000);
            }
            ((MySequence)this.ADT).remove(key);
        }
        else {
            ((MyHashMap)this.ADT).remove(key);
        }
//        Removing the element from the stack
        this.removeFromStacks(element);
    }



//    getValues(ElasticERL,key): return the values of the given key;
    public String getValues(int key) {
        if(this.ADTSize == 1_000) {
            return ((MySequence)this.ADT).getValues(key);
        }
        return ((MyHashMap)this.ADT).getValues(key);
    }



//    nextKey(ElasticERL,key): return the key for the successor of key;
    public int nextKey(int key) {
        int result = -1;
        if(this.sortedStack.getElements(this.threshold).length == 0) {
            return result;
        }
        int[] keys = this.sortedStack.getKeys(this.threshold);
        for(int i = 0; i < this.threshold - 1; i++) {
            if(keys[i] == key) {
                result = keys[i + 1];
                break;
            }
        }
        return result;
    }



//    prevKey(ElasticERL,key): return the key for the predecessor of key;
    public int prevKey(int key) {
        int result = -1;
        if(this.sortedStack.getElements(this.threshold).length == 0) {
            return result;
        }
        int[] keys = this.sortedStack.getKeys(this.threshold);
        for(int i = 1; i < this.threshold; i++) {
            if(keys[i] == key) {
                result = keys[i - 1];
                break;
            }
        }
        return result;
    }



//    rangeKey(key1, key2): returns the number of keys that are within the specified range of the two keys key1 and key2
    public int rangeKey(int key1, int key2) {
        if(this.ADTSize == 1_000) {
            return ((MySequence)this.ADT).rangeKey(key1, key2);
        }
        return ((MyHashMap)this.ADT).rangeKey(key1, key2);
    }
}
