package B12_Java_Collection_Framework.BaiTap.SuDung_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {

    public static ArrayList<Product> product = new ArrayList<Product>();

    public void addProduct(Product name){
        product.add(name);
    }

    public void updateProduct(int id){

    }

    public void removeProduct(int id){
        product.remove(product.get(id));
    }

    public void displayProduct(int id){
        System.out.println(product.get(id).toString());
    }

    public void searchProduct(String name){
        boolean check = true;
        for (int i=0; i<product.size(); i++){
            if (product.get(i).equals(name)){
                System.out.println("tim thay san pham tai vi tri "+ i);
                check = false;
            }
        }
        if (check){
            System.out.println("khong tim thay san pham");
        }
    }

    public void sortProduct(){
        Collections.sort(product);
    }

}
