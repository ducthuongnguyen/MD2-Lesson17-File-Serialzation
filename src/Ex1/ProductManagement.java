package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private List<Product> productList;

    public ProductManagement() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
        System.out.println("Product ID " + product.getId() + " is added successful!");
    }

    public void display(){
        System.out.println("List: ");
        for (Product product:
             productList) {
            System.out.println(product);
        }
    }

    public void search(int id){
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                System.out.println("Product ID "+ productList.get(i).getId()+" you searched: " + productList.get(i).toString());
                break;
            }else
            System.out.println("Product ID you searched is not found!");
        }
    }


    public void writeToFile(String path, List<Product> productList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(productList);
            oos.close();
            System.out.println("Recording product list to file "+ path +" is done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void readFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            products = (List<Product>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Display product list record in file "+ path +": ");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }


}
