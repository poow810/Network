package Stream;

public class Fruit implements Comparable<Fruit>{
    private String name;
    private Integer price;

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public int compareTo(Fruit o) {
        return this.price - o.price;
    }
}
