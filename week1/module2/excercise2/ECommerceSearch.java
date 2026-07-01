import java.util.Arrays;

// Step 2: Setup - Product Class
class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Required for sorting and binary search
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}

public class ECommerceSearch {

    // Step 3: Implementation - Linear Search
    // Checks every element one by one
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null; // Not found
    }

    // Step 3: Implementation - Binary Search
    // Repeatedly divides a SORTED array in half
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid]; 
            }
            
            if (products[mid].productId < targetId) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        // Create an array of products
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(108, "Running Shoes", "Apparel"),
            new Product(103, "Coffee Maker", "Home Appliances")
        };

        int targetId = 108;

        // Linear Search (Works on unsorted arrays)
        Product foundLinear = linearSearch(inventory, targetId);
        System.out.println("Linear Search found: " + (foundLinear != null ? foundLinear.productName : "Nothing"));

        // Binary Search (Array MUST be sorted first)
        Arrays.sort(inventory); 
        Product foundBinary = binarySearch(inventory, targetId);
        System.out.println("Binary Search found: " + (foundBinary != null ? foundBinary.productName : "Nothing"));
    }
}