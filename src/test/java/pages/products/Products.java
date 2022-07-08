package pages.products;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Products {

    private String image, name, description, price;

    private Products(String image, String name, String description, String price){
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

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
                productsList.add(new Products(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("Brak pliku.");
        }

        return productsList;
    }

    public static List<String> test(){

        List<String> productsList = new ArrayList<>();
        FileInputStream fileInputStream;

        try{
            fileInputStream = new FileInputStream("src/test/resources/test.txt");
            Scanner sc = new Scanner(fileInputStream);
            while(sc.hasNextLine()) {
                productsList.add(sc.nextLine());
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("Brak pliku.");
        }

        return productsList;
    }
}
