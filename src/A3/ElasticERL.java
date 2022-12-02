// Amanda Beronilla (40228871) & Abdurrahim Gigani (40181121)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.util.Random;

public class ElasticERL {
    private Object ADT;
    private int threshold;
    private int size;
    // TO DO: FIX THE STACKS
    private MyLinkedList stack;
    private MyLinkedList sortedStack;

    public ElasticERL(int size) {
        this.size = 0;
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

    public MyLinkedList getStack() {
        return this.stack;
    }

    public void increaseSize() {
        this.size++;
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
            // TO DO: SET ALL VALUES INTO SEQUENCE
            // get list of stuff in chronological order
            for(int i = 0; i < this.size; i++) {
                seq.add(this.stack.getElement(i));
            }
            this.ADT = seq;
        }
//        If the size is larger, use a hashmap
        else {
            MyHashMap hash = new MyHashMap(10_000);
            // TO DO: SET ALL VALUES INTO HASHMAP
            for(int i = 0; i < this.size; i++) {
                hash.add(this.stack.getElement(i));
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
        for(int i = 0; i < this.size; i++) {
            if(this.stack.getElement(i) == result) {
                return generate();
            }
        }
        return result;
    }


//    allKeys(ElasticERL): return all keys in ElasticERL as a sorted sequence;
    public static int[] allKeys(ElasticERL erl) {
//        Calling allKeys() from either Sequence or HashMap
//        TO DO: CALL METHODS - or just return this.sortedStack?
        if(erl.getThreshold() <= 1_000) {

        }
        else {

        }
    }


//    add(ElasticERL,key,value2): add an entry for the given key and value;
    public static void add(ElasticERL erl, int key, String value) {
//        Setting variables
        Element element = new Element(key, value);
//        Calling add() from either Sequence or HashMap
        if(erl.getThreshold() <= 1_000 && erl.getSize() < 1_000) {
            ((MySequence)erl.getADT()).add(element);
        }
        else {
//            If the threshold is 1000, then we currently have a sequence. When we add an element, we exceed the
//            threshold, so we set the threshold and use a hashmap to avoid this issue.
            if(erl.getThreshold() == 1_000) {
                erl.SetEINThreshold(1_001);
            }
            ((MyHashMap)erl.getADT()).add(element);
        }
        erl.increaseSize();
//        Adding the element to the stack
        erl.getStack().add(element);
    }


//    remove(ElasticERL,key): remove the entry for the given key;
    public static void remove(ElasticERL erl, int key) {
//        Setting variables
        Element element = new Element(key);
//        Calling remove() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(erl.getThreshold() <= 1_000) {
            ((MySequence)erl.getADT()).remove(element);
        }
        else {
            ((MyHashMap)erl.getADT()).remove(key);
        }
//        Removing the element from the stack
        erl.getStack().remove(key);
    }



//    getValues(ElasticERL,key): return the values of the given key;
    public static String getValues(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS
        if(erl.getThreshold() <= 1_000) {
            ((MySequence)erl.getADT()).
        }
        else {
            ((MyHashMap)erl.getADT()).getValues(key);
        }
    }



//    nextKey(ElasticERL,key): return the key for the successor of key;
    public static int nextKey(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS - this.sortedStack?
        if(erl.getThreshold() <= 1_000) {
            ((MySequence)erl.getADT()).
        }
        else {
            ((MyHashMap)erl.getADT()).
        }
    }



//    prevKey(ElasticERL,key): return the key for the predecessor of key;
    public static int prevKey(ElasticERL erl, int key) {
//        Calling getValues() from either Sequence or HashMap
//        TO DO: CALL METHODS - this.sortedStack?
        if(erl.getThreshold() <= 1_000) {
            ((MySequence)erl.getADT()).
        }
        else {
            ((MyHashMap)erl.getADT()).
        }
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
