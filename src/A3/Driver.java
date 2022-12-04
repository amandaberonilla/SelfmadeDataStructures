// Amanda Beronilla (40228871)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            String fileName = new String("A3/EHITS_test_file1.txt");
            File file = new File("C:\\Users\\Amanda\\Desktop\\monday\\codes\\comp352a3\\comp352_a3\\src\\A3\\EHITS_test_file1.txt");
            BufferedReader read = new BufferedReader(new FileReader(file));
            int count = 0;
            String line;

            ElasticERL erl = new ElasticERL();
            System.out.println("erl.allKeys() = " + erl.allKeys());

            while(read.readLine() != null) {
                count++;
            }
            System.out.println(count);

            erl.SetEINThreshold(count);
            while((line = read.readLine()) != null) {
                int key = Integer.parseInt(line);
                erl.add(key, "");
            }

            System.out.println("erl.generate() = " + erl.generate());

            System.out.println("erl.nextKey() = " + erl.nextKey(33223370));
            System.out.println("erl.prevKey() = " + erl.prevKey(33223370));

            read.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
