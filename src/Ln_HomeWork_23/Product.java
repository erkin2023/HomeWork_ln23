package Ln_HomeWork_23;

import java.util.List;
import java.util.Map;

public class Product {
   private static int idd=1;
   private int id;
   private  Category category;
   private String name;
    private Characters characters;
   private double price;

    public Product(int id ,Category category, String name, Characters characters, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.characters = characters;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Characters getCharacters() {
        return characters;
    }

    public double getPrice() {
        return price;
    }

    public static void setIdd(int idd) {
        Product.idd = idd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product" +"\n"+
                "Category =" + category +"\n"+
                "Name ='" + name + '\'' +"\n"+
                "Character =" + characters +"\n"+
                "Price =" + price +"\n";
    }
}
