// Amanda Beronilla (40228871) & Abdurrahim Gigani (40181121)
// COMP 352 Data Structures and Algorithms sect FF
// Dr. Aiman Hanna
// 5 December 2022

package A3;

public class Element {
    private int key;
    private String value;

    public Element(int key) {
        this.key = key;
        this.value = "Element";
    }

    public Element(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
