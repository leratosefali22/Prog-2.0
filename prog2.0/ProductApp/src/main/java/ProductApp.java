import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        // Window Setup matching Sample Screenshot
        setTitle("Product App");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools"); // Shown as Edit in sample screenshot, Tools in Q.2.4
       
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Main Form Panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 1. Customer Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.35;
        panel.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.65;
        txtCustomerName = new JTextField(15);
        panel.add(txtCustomerName, gbc);

        // 2. Select Product Combo Box
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.35;
        panel.add(new JLabel("Select Product:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.65;
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct, gbc);

        // 3. Enter Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.35;
        panel.add(new JLabel("Enter Price:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.65;
        txtPrice = new JTextField(15);
        panel.add(txtPrice, gbc);

        // 4. PROCESS Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 5, 8);
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        panel.add(btnProcess, gbc);

        add(panel);
    }

    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = (String) cmbProduct.getSelectedItem();
        String priceText = txtPrice.getText().trim();

        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Customer Name and Price.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);

            // Calculation Requirements:
            // VAT: 15% of product price
            // Commission: 5% of product price
            // Total Sale Amount: Price + VAT + Commission
            double vat = price * 0.15;
            double commission = price * 0.05;
            double totalSaleAmount = price + vat + commission;

            String resultMessage = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + totalSaleAmount;

            // Display the details
            JOptionPane.showMessageDialog(this, resultMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Store the details in data.txt
            saveDetailsToFile(resultMessage);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveDetailsToFile(String details) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("****************************************");
            writer.println(details);
            writer.println("****************************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save to data.txt: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}

