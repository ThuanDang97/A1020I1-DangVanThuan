package B12_Java_Collection_Framework.BaiTap.SuDung_ArrayList_LinkedList;

public class main {
    public static void main(String[] args) {
        Product pr1 = new Product();
        pr1.setId(01);
        pr1.setName("sp1");
        pr1.setPrice(1000);
        Product pr2 = new Product();
        pr1.setId(02);
        pr1.setName("sp2");
        pr1.setPrice(2000);

        ProductManager pm2 = new ProductManager();
        pm2.addProduct(pr1);
        pm2.addProduct(pr2);
        pm2.displayProduct(01);
    }
}
