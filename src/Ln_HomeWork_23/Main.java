package Ln_HomeWork_23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Creating a sample product
        Characters characteristics1 = new Characters();
        characteristics1.addCharacter(KeyCharacter.CPU, Arrays.asList("Intel i7"));
        Product laptop1 = new Product(1, Category.Laptop, "Laptop X", characteristics1, 999.99);

        // Saving the product
        manager.saveProduct(laptop1);

        // Creating another sample product
        Characters characteristics2 = new Characters();
        characteristics2.addCharacter(KeyCharacter.CPU, Arrays.asList("AMD Ryzen 5"));
        Product laptop2 = new Product( 2,Category.Laptop, "Laptop Y", characteristics2, 899.99);

        // Saving the second product
        manager.saveProduct(laptop2);

        // Retrieving a product by ID
        Product retrievedProduct = manager.getByIdProduct(1);
        if (retrievedProduct != null) {
            System.out.println("Product Name: " + retrievedProduct.getName());
            System.out.println("Category: " + retrievedProduct.getCategory());
            System.out.println("Characteristics: " + retrievedProduct.getCharacters().getCharacteristics());
            System.out.println("Price: $" + retrievedProduct.getPrice());
        } else {
            System.out.println("Product not found.");
        }

        // Listing all products
        List<Product> productList = manager.getAllProduct();
        System.out.println("\nAll Products:");
        for (Product product : productList) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Characteristics: " + product.getCharacters().getCharacteristics());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("--------");
        }

        // Updating a product
        Product updatedProduct = manager.getByIdProduct(2);
        if (updatedProduct != null) {
            updatedProduct.setPrice(849.99);
            manager.updateProduct(updatedProduct);
            System.out.println("\nUpdated Product Price: $" + updatedProduct.getPrice());
        } else {
            System.out.println("Product not found for updating.");
        }

        // Searching for products by name
        List<Product> searchResults = manager.searchByProductName("Laptop X");
        System.out.println("\nSearch Results for 'Laptop X':");
        for (Product result : searchResults) {
            System.out.println("Product ID: " + result.getId());
            System.out.println("Product Name: " + result.getName());
            System.out.println("Category: " + result.getCategory());
            System.out.println("Characteristics: " + result.getCharacters().getCharacteristics());
            System.out.println("Price: $" + result.getPrice());
            System.out.println("--------");
        }

        // Filtering products by characteristic
        List<Product> filteredProducts = manager.filterByCharacter(KeyCharacter.CPU, "Intel i7");
        System.out.println("\nFiltered Products (CPU: Intel i7):");
        for (Product filteredProduct : filteredProducts) {
            System.out.println("Product ID: " + filteredProduct.getId());
            System.out.println("Product Name: " + filteredProduct.getName());
            System.out.println("Category: " + filteredProduct.getCategory());
            System.out.println("Characteristics: " + filteredProduct.getCharacters().getCharacteristics());
            System.out.println("Price: $" + filteredProduct.getPrice());
            System.out.println("--------");
        }

        // Sorting products by characteristic (CPU)
        List<Product> sortedProducts = manager.sortByCharacter(KeyCharacter.CPU);
        System.out.println("\nSorted Products (by CPU):");
        for (Product sortedProduct : sortedProducts) {
            System.out.println("Product ID: " + sortedProduct.getId());
            System.out.println("Product Name: " + sortedProduct.getName());
            System.out.println("Category: " + sortedProduct.getCategory());
            System.out.println("Characteristics: " + sortedProduct.getCharacters().getCharacteristics());
            System.out.println("Price: $" + sortedProduct.getPrice());
            System.out.println("--------");
        }

        // Deleting a product by ID
        manager.deleteByProduct(1);
        System.out.println("\nProduct with ID 1 deleted.");

        // Deleting a specific character key (CPU) from all products
        manager.deleteCharacterByKeyName(KeyCharacter.CPU);
        System.out.println("\nDeleted CPU characteristic from all products.");

        // Deleting all character values and mappings from all products
        manager.deleteAllCharacters();
        System.out.println("\nDeleted all character values and mappings from all products.");
    }
}
