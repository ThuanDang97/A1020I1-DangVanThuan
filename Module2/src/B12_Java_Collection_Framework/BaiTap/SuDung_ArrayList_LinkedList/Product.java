package B12_Java_Collection_Framework.BaiTap.SuDung_ArrayList_LinkedList;

public class Product implements Comparable<Product> {

    private String name;
    private int id;
    private int price;
    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }
    public Product() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product name: " + this.name +
                ", ID: " + this.id +
                ", Price: " + this.price;
    }
    @Override
    public int compareTo(Product p) {
        if (getId() > p.getId()) return 1;
        else if (getId() < p.getId()) return -1;
        else return 0;
    }
}
