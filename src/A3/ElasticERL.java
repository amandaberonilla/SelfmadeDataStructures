// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.util.Random;

public class ElasticERL {
    private Object ADT;
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
    }


    public Object getADT() {
        return this.ADT;
    }


    public int getThreshold() {
        return this.threshold;
    }


    public int getSize() {
        return this.size;
    }


    public MySequence getStack() {
        return this.stack;
    }


    public MySequence getSortedStack() {
        return this.sortedStack;
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
            MySequence seq = new MySequence();
            for(Element element : this.stack.getElements(1_000)) {
                seq.add(element);
            }
            this.ADT = seq;
        }
//        If the size is larger, use a hashmap
        else {
            MyHashMap hash = new MyHashMap(10_000);
            for(Element element : this.stack.getElements(10_000)) {
                hash.add(element);
            }
            this.ADT = hash;
        }
    }


//    generate(): randomly generates new non-existing key of 8 digits;
    public int generate() {
//        Setting up variables
        int result;
        String generate = "";
        Random random = new Random();
//        Looping 8 times to get a random digit and adding it to the key
        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(10);
            generate += index;
        }
        result = Integer.parseInt(generate);
//        Checking if the key already exists
        // TO DO: CHECK IF KEY ALREADY EXISTS - use this.stack
        for(Element element : this.stack.getElements(this.threshold)) {
            if(element.getKey() == result) {
                return generate();
            }
        }
        return result;
    }


//    allKeys(ElasticERL): return all keys in ElasticERL as a sorted sequence;
    public static int[] allKeys(ElasticERL erl) {
//        Calling allKeys() from either Sequence or HashMap
//        TO DO: CALL METHODS - or just return this.sortedStack?
//        sorted sequence like sequence the concept or sequence the data type?
        return erl.sortedStack.getKeys(erl.threshold);
    }

//    add(ElasticERL,key,value2): add an entry for the given key and value;
    public static void add(ElasticERL erl, int key, String value) {
//        Checking if we cross the threshold
        if(erl.size >= erl.threshold) {
            System.out.println("Size surpasses threshold. Kindly resize.");
            return;
        }
//        Setting variables
        Element element = new Element(key, value);
//        Calling add() from either Sequence or HashMap
        if(erl.getSize() < 1_000) {
            ((MySequence)erl.getADT()).add(element);
        }
        else {
//            If the threshold is 1000, then we currently have a sequence. When we add an element, we cross the
//            threshold bound, so we set the threshold and use a hashmap to avoid this issue.
            if(erl.getThreshold() == 1_000) {
                erl.SetEINThreshold(1_001);
            }
            ((MyHashMap)erl.getADT()).add(element);
        }
//        Adding the element to the stack
        erl.addToStacks(element);
    }


//    remove(ElasticERL,key): remove the entry for the given key;
    public static void remove(ElasticERL erl, int key) {
//        Checking if we cross 0
        if(erl.size <= 0) {
            System.out.println("Size too low. Kindly add before removing.");
            return;
        }
//        Setting variables
        Element element = new Element(key);
//        Calling remove() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(erl.getSize() <= 1_001) {
//            If the threshold is not 1000, then we currently have a hashmap. When we remove an element, we cross the
//            threshold bound, so we set the threshold and use a sequence to avoid this issue.
            if(erl.getThreshold() != 1_000) {
                erl.SetEINThreshold(1_000);
            }
            ((MySequence)erl.getADT()).remove(key);
        }
        else {
            ((MyHashMap)erl.getADT()).remove(key);
        }
//        Removing the element from the stack
        erl.removeFromStacks(element);
    }



//    getValues(ElasticERL,key): return the values of the given key;
    public static String getValues(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(erl.getThreshold() <= 1_000) {
            return ((MySequence)erl.getADT()).getValues(key);
        }
        else {
            return ((MyHashMap)erl.getADT()).getValues(key);
        }
    }



//    nextKey(ElasticERL,key): return the key for the successor of key;
    public static int nextKey(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS - this.sortedStack?
        int result = -1;
        int[] keys = erl.sortedStack.getKeys(erl.threshold);
        for(int i = 0; i < erl.threshold - 1; i++) {
            if(keys[i] == key) {
                result = keys[i + 1];
                break;
            }
        }
        return result;
    }



//    prevKey(ElasticERL,key): return the key for the predecessor of key;
    public static int prevKey(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS - this.sortedStack?
        int result = -1;
        int[] keys = erl.sortedStack.getKeys(erl.threshold);
        for(int i = 1; i < erl.threshold; i++) {
            if(keys[i] == key) {
                result = keys[i - 1];
                break;
            }
        }
        return result;
    }



//    rangeKey(key1, key2): returns the number of keys that are within the specified range of the two keys key1 and key2
    public int rangeKey(int key1, int key2) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(this.threshold <= 1_000) {
            return ((MySequence)this.ADT).rangeKey(key1, key2);
        }
        else {
            return ((MyHashMap)this.ADT).rangeKey(key1, key2);
        }
    }
}
