// Amanda Beronilla (40228871) & Abdurrahim Gigani (40181121)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(generate());
    }
    public static int generate() {
        String digits = "0123456789";
        int result;
        String generate = "";
        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            int index = random.nextInt(10);
            generate += index;
        }
        result = Integer.parseInt(generate);
        // TO DO: CHECK IF KEY ALREADY EXISTS
        return result;
    }
}
