

import java.util.Scanner;

public class ProductSalesReport {

    public static void main(String[] args) {
        // Single-dimensional array to store the product names
        try (Scanner scanner = new Scanner(System.in)) {
            // Single-dimensional array to store the product names
            String[] products = {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
            };
            
            // Two-dimensional array to store sales: [3 products][3 months]
            int[][] sales = new int[3][3];
            
            // 1. Prompt user for sales data
            for (int i = 0; i < products.length; i++) {
                for (int j = 0; j < sales[i].length; j++) {
                    System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                    sales[i][j] = scanner.nextInt();
                }
                System.out.println(); // Blank line between products to match sample
            }
            
            // 2. Calculate total sales, highest single-month sale, and most popular product
            int totalSales = 0;
            int totalEntries = 0;
            int highestTotalProductSales = -1;
            int highestSingleSaleForWinner = 0;
            String mostPopularProduct = "";
            
            for (int i = 0; i < products.length; i++) {
                int productTotal = 0;
                int maxSingleMonthForProduct = 0;
                
                for (int j = 0; j < sales[i].length; j++) {
                    int currentSale = sales[i][j];
                    productTotal += currentSale;
                    totalSales += currentSale;
                    totalEntries++;
                    
                    if (currentSale > maxSingleMonthForProduct) {
                        maxSingleMonthForProduct = currentSale;
                    }
                }
                
                // Determine the most popular product based on highest total sales
                if (productTotal > highestTotalProductSales) {
                    highestTotalProductSales = productTotal;
                    mostPopularProduct = products[i];
                    highestSingleSaleForWinner = maxSingleMonthForProduct;
                }
            }
            
            // Calculate average (153 / 9 = 17 in the sample)
            int averageSales = totalSales / totalEntries;
            
            // 3. Display the formatted report
            System.out.println("PRODUCT SALES REPORT - 2026");
            System.out.println("****************************************");
            System.out.println("TOTAL PRODUCT SALES: " + totalSales);
            System.out.println("AVERAGE PRODUCT SALES: " + averageSales);
            System.out.println("MOST POPULAR PRODUCT: " + mostPopularProduct + " (" + highestSingleSaleForWinner + ")");
        }
    }
}

