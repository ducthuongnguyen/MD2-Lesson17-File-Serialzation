package Ex1;

public class Main {
    public static void main(String[] args) {
        String filePath = "product_list.txt";
        ProductManagement pm = new ProductManagement();
        pm.add(new Product(1,"iphone 11","Apple",18000,"Black Rose"));
        pm.add(new Product(2,"xiaomi 20","Xiaomi", 10000,"Full colors"));
        pm.add(new Product(3,"Samsung Ultra S21","Samsung",8900,"Pink"));

        pm.writeToFile(filePath,pm.getProductList());
        pm.readFromFile(filePath);
    }
}
