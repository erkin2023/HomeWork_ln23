package Ln_HomeWork_23;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
        private List<Product> products = new ArrayList<>();

        // Method to add a new product
        public void saveProduct(Product product) {
            products.add(product);

        }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                products.set(i, updatedProduct);
                return; // Product updated successfully
            }
        }
        // Product not found, handle accordingly
    }

    // Method to retrieve a product by ID
    public Product getByIdProduct(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null); // Product not found
    }

    // Method to search for products by name
    public List<Product> searchByProductName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Method to filter products based on specific characteristics
    public List<Product> filterByCharacter(KeyCharacter key, String value) {
        return products.stream()
                .filter(product -> {
                    Characters chars = product.getCharacters();
                    List<String> values = chars.getCharacteristics().get(key);
                    return values != null && values.contains(value);
                })
                .collect(Collectors.toList());
    }

    // Method to sort products based on a specific characteristic
    public List<Product> sortByCharacter(KeyCharacter key) {
        return products.stream()
                .sorted((product1, product2) -> {
                    List<String> values1 = product1.getCharacters().getCharacteristics().get(key);
                    List<String> values2 = product2.getCharacters().getCharacteristics().get(key);

                    if (values1 == null || values1.isEmpty()) {
                        return values2 == null || values2.isEmpty() ? 0 : 1;
                    } else if (values2 == null || values2.isEmpty()) {
                        return -1;
                    } else {
                        String value1 = values1.get(0);
                        String value2 = values2.get(0);

                        // Check if values are numeric, and compare accordingly
                        if (isNumeric(value1) && isNumeric(value2)) {
                            double numericValue1 = Double.parseDouble(value1);
                            double numericValue2 = Double.parseDouble(value2);
                            return Double.compare(numericValue1, numericValue2);
                        } else {
                            // Handle non-numeric values (e.g., "AMD Ryzen 5")
                            return value1.compareTo(value2);
                        }
                    }
                })
                .collect(Collectors.toList());
    }
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // Method to delete a product by ID
    public void deleteByProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    // Method to retrieve all products
    public List<Product> getAllProduct() {
        return products;
    }

    // Method to delete a specific character key from all products
    public void deleteCharacterByKeyName(KeyCharacter key) {
        products.forEach(product -> product.getCharacters().getCharacteristics().remove(key));
    }

    // Method to delete all character values and their mappings from all products
    public void deleteAllCharacters() {
        products.forEach(product -> product.getCharacters().getCharacteristics().clear());
    }
}
