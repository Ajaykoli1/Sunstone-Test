package Sunstone_Training;


class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    public Product(int productId, String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price or Quantity cannot be negative!");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
        this.price = 0.0;
        this.quantity = 0;
    }

    public void addProduct(int productId, String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price or Quantity cannot be negative!");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        System.out.println("Product added: " + productName);
    }

    public void addProduct(String productName, double price) throws InvalidProductException {
        if (price < 0) {
            throw new InvalidProductException("Price cannot be negative!");
        }
        this.productName = productName;
        this.price = price;
        System.out.println("Product added: " + productName);
    }

    public void addProduct(String productName, double price, int quantity) throws InvalidProductException {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price or Quantity cannot be negative!");
        }
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        System.out.println("Product added: " + productName);
    }

    public void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

public class ProductManager {
    public static void main(String[] args) {
        try {
            Product p1 = new Product(1, "Laptop", 50000 , 5);
            p1.display();

            Product p2 = new Product(2, "Mouse");
            p2.display();

            p2.addProduct(2, "Mouse", 500, 10);
            p2.display();

            Product p3 = new Product(3, "Keyboard");
            p3.addProduct("Keyboard", 800);
            p3.display();

            Product p4 = new Product(4, "Monitor");
            p4.addProduct("Monitor", 7000, 3);
            p4.display();

            Product p5 = new Product(5, "Phone", -10000, 2);
            p5.display();

        } catch (InvalidProductException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}