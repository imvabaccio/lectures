public class Item {
    Integer value;
    Integer weight;
    Integer vbyw;

    Item(Integer value, Integer weight) {
        this.value = value;
        this.weight = weight;
        vbyw = value / weight;
    }
}
