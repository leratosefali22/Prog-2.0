
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

// 1. Declare the Q.2.2 form components as class variables
private JTextField txtCustomerName;
private JComboBox<String> cmbProduct;
private JTextField txtPrice;

// 2. Initialize and add them to your panel/form inside the constructor
JLabel lblCustomerName = new JLabel("Customer Name:");
txtCustomerName = new JTextField(15);

JLabel lblProduct = new JLabel("Select Product:");
String[] products = {
    "Cozy Nights Monarch",
    "Restonic Barbados",
    "Sealy Phuket"
};
cmbProduct = new JComboBox<>(products);

JLabel lblPrice = new JLabel("Enter Price:");
txtPrice = new JTextField(15);

panel.add(lblCustomerName);
panel.add(txtCustomerName);

panel.add(lblProduct);
panel.add(cmbProduct);

panel.add(lblPrice);
panel.add(txtPrice);/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Student
 */
public class Mavenproject5 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
