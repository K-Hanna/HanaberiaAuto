package pages.products;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Products {

    private String image, category, name, description, price;

    private Products(String image, String category, String name, String description, String price){
        this.image = image;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getCategory(){
        return category; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public static List<Products> generate(){

        List<Products> productsList = new Vector<>();
        FileInputStream fileInputStream;

        try{
            fileInputStream = new FileInputStream("src/test/resources/products.txt");
            Scanner sc = new Scanner(fileInputStream);
            while(sc.hasNextLine()) {
                productsList.add(new Products(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("Brak pliku.");
        }

        return productsList;
    }
}
