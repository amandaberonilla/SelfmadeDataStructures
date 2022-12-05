// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World!\n\n\n");

        try {
            String fileName = new String("A3/EHITS_test_file1.txt");
//            File file = new File("C:\\Users\\Amanda\\Desktop\\monday\\codes\\comp352a3\\comp352_a3\\src\\A3\\EHITS_test_file1.txt");
//            File file = new File("C:\\Users\\adtbe\\IdeaProjects\\comp352_a3\\src\\A3\\EHITS_test_file1.txt");
//            File file = new File("C:\\Users\\adtbe\\IdeaProjects\\comp352_a3\\src\\A3\\test.txt");
//            File file = new File("C:\\Users\\adtbe\\IdeaProjects\\comp352_a3\\src\\A3\\test2.txt");
            File file = new File("C:\\Users\\adtbe\\IdeaProjects\\comp352_a3\\src\\A3\\test3.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            int count = 0;
            String line;

            int test1 = 65862;
            int test2 = 71421784;
            int test3 = 65135867;
            int bound1 = 0;
            int bound2 = 35000;
            int bound3 = 30000000;
            int bound4 = 90000000;

            System.out.println("ElasticERL erl = new ElasticERL()");
            ElasticERL erl = new ElasticERL();
            System.out.println("erl.allKeys() = " + Arrays.toString(erl.allKeys()));

            while(read.readLine() != null) {
                count++;
            }

            System.out.println("\nerl.SetEINThreshold(" + count + ")");
            erl.SetEINThreshold(count);
            System.out.println("Hello");

            read = new BufferedReader(new FileReader(file));
            while((line = read.readLine()) != null) {
                int key = Integer.parseInt(line);
                erl.add(key, "");
            }

            System.out.println("\nerl.generate() = " + erl.generate());

//            System.out.println("\nerl.allKeys() = " + Arrays.toString(erl.allKeys()));
            System.out.println("\nerl.nextKey(" + test1 + ") = " + erl.nextKey(test1));
            System.out.println("erl.prevKey(" + test2 + ") = " + erl.prevKey(test2));

            System.out.println("\nerl.rangeKey(" + bound1 + ", " + bound2 + ") = " + erl.rangeKey(bound1, bound2));
            System.out.println("erl.rangeKey(" + bound2 + ", " + bound3 + ") = " + erl.rangeKey(bound2, bound3));
            System.out.println("erl.rangeKey(" + bound2 + ", " + bound4 + ") = " + erl.rangeKey(bound2, bound4));

            System.out.println("\nerl.remove(" + test3 + ")");
            erl.remove(test3);

//            System.out.println("\nerl.allKeys() = " + Arrays.toString(erl.allKeys()));
            System.out.println("erl.nextKey(" + test1 + ") = " + erl.nextKey(test1));
            System.out.println("erl.prevKey(" + test2 + ") = " + erl.prevKey(test2));
            System.out.println("erl.getValues(" + test1 + ") = " + erl.getValues(test1));
            System.out.println("erl.getValues(" + test2 + ") = " + erl.getValues(test2));

            System.out.println("\nerl.rangeKey(" + bound1 + ", " + bound3 + ") = " + erl.rangeKey(bound1, bound3));
            System.out.println("erl.rangeKey(" + bound2 + ", " + bound3 + ") = " + erl.rangeKey(bound2, bound3));
            System.out.println("erl.rangeKey(" + bound2 + ", " + bound4 + ") = " + erl.rangeKey(bound2, bound4));

            read.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
