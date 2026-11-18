public class PrintProduct {

    private final Product product;

    // Constructor receiving a Product object
    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    public void printMostPopularProductSale() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    // Helper method to print the full formatted report
    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("****************************************");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProductSale();
    }

    private static class Product {

        public Product() {
        }

        private String GetTotalProductsSold() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String GetMostPopularProduct() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Student
 */
public class PrintProduct {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
