package Lesson4_DZ;

public class ListIsEmptyException extends Exception {
    public ListIsEmptyException () {
        super("The list contains no elements");
    }
}
