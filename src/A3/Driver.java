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
            File file = new File("C:\\Users\\adtbe\\IdeaProjects\\comp352_a3\\src\\A3\\test.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            int count = 0;
            String line;

            System.out.println("ElasticERL erl = new ElasticERL()");
            ElasticERL erl = new ElasticERL();
            System.out.println("erl.allKeys() = " + Arrays.toString(erl.allKeys()));

            while(read.readLine() != null) {
                count++;
            }

            System.out.println("\nerl.SetEINThreshold(" + count + ")");
            erl.SetEINThreshold(count);

            read = new BufferedReader(new FileReader(file));
            while((line = read.readLine()) != null) {
                int key = Integer.parseInt(line);
                erl.add(key, "");
            }

            System.out.println("\nerl.generate() = " + erl.generate());

            System.out.println("\nerl.allKeys() = " + Arrays.toString(erl.allKeys()));
            System.out.println("erl.nextKey(40497861) = " + erl.nextKey(40497861));
            System.out.println("erl.prevKey(80625115) = " + erl.prevKey(80625115));

            System.out.println("\nerl.rangeKey(40000000, 80000000) = " + erl.rangeKey(40000000, 80000000));
            System.out.println("erl.rangeKey(50000000, 80000000) = " + erl.rangeKey(50000000, 80000000));
            System.out.println("erl.rangeKey(50000000, 90000000) = " + erl.rangeKey(50000000, 90000000));

            System.out.println("\nerl.remove(67065291)");
            erl.remove(67065291);

            System.out.println("\nerl.allKeys() = " + Arrays.toString(erl.allKeys()));
            System.out.println("erl.nextKey(40497861) = " + erl.nextKey(40497861));
            System.out.println("erl.prevKey(80625115) = " + erl.prevKey(80625115));
            System.out.println("erl.getValues(40497861) = " + erl.getValues(40497861));
            System.out.println("erl.getValues(67065291) = " + erl.getValues(67065291));

            System.out.println("\nerl.rangeKey(40000000, 80000000) = " + erl.rangeKey(40000000, 80000000));
            System.out.println("erl.rangeKey(50000000, 80000000) = " + erl.rangeKey(50000000, 80000000));
            System.out.println("erl.rangeKey(50000000, 90000000) = " + erl.rangeKey(50000000, 90000000));

            read.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
