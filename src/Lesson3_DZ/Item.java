package Lesson3_DZ;

public class Item {
    private int itemId;

    public Item(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Item{" +
                " Id = " + itemId +
                '}';
    }
}
