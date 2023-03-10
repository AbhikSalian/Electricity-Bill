//Electricity bill calculator using GUI
//Abhik L Salian
//4SO21CS004
import java.awt.event.*;
import javax.swing.*;

public class ElectricityBill implements ActionListener {
   
    JFrame frame;
    JTextField customerNoField, meterNoField, previousReadingField, currentReadingField;
    JButton calculateButton, printButton;
    JRadioButton domestic,commercial;
    int customerNo, meterNo, previousReading, currentReading,units;
    double totalBill;

    public ElectricityBill() {

        frame = new JFrame("Electricity Bill Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel customerNoLabel = new JLabel("Customer Number:");
        customerNoLabel.setBounds(20, 20, 120, 25);
        panel.add(customerNoLabel);

        customerNoField = new JTextField(10);
        customerNoField.setBounds(150, 20, 150, 25);
        panel.add(customerNoField);

        JLabel meterNoLabel = new JLabel("Meter Number:");
        meterNoLabel.setBounds(20, 60, 120, 25);
        panel.add(meterNoLabel);

        meterNoField = new JTextField(10);
        meterNoField.setBounds(150, 60, 150, 25);
        panel.add(meterNoField);

        JLabel previousReadingLabel = new JLabel("Previous Reading:");
        previousReadingLabel.setBounds(20, 100, 120, 25);
        panel.add(previousReadingLabel);

        previousReadingField = new JTextField(10);
        previousReadingField.setBounds(150, 100, 150, 25);
        panel.add(previousReadingField);

        JLabel currentReadingLabel = new JLabel("Current Reading:");
        currentReadingLabel.setBounds(20, 140, 120, 25);
        panel.add(currentReadingLabel);

        currentReadingField = new JTextField(10);
        currentReadingField.setBounds(150, 140, 150, 25);
        panel.add(currentReadingField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(70, 250, 100, 25);
        panel.add(calculateButton);

        printButton = new JButton("Print");
        printButton.setBounds(210, 250, 100, 25);
        panel.add(printButton);

        JLabel ctype=new JLabel("Select customer type :");
        ctype.setBounds(20,180,200,25);
        panel.add(ctype);
       
        domestic = new JRadioButton("Domestic");
        domestic.setBounds(70,200,100,25);
        panel.add(domestic);
       
        commercial = new JRadioButton("Commercial");
        commercial.setBounds(170,200,100,25);
        panel.add(commercial);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(domestic);
        bg.add(commercial);
       
        calculateButton.addActionListener(this);
        printButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(domestic.isSelected())
        {
        if (e.getSource() == calculateButton) {
               
                customerNo = Integer.parseInt(customerNoField.getText());
                meterNo = Integer.parseInt(meterNoField.getText());
                previousReading = Integer.parseInt(previousReadingField.getText());
                currentReading = Integer.parseInt(currentReadingField.getText());

                units = currentReading - previousReading;
                if (units <= 100)
                    totalBill = units;
                else if (units <= 200)
                    totalBill = 100 + (units - 100) * 2.5;
                else if (units <= 500)
                    totalBill = 100 + 250 + (units - 200) * 4;
                else
                    totalBill = 100 + 250 + 1200 + (units - 500) * 6;

                JOptionPane.showMessageDialog(frame, "Total Bill: Rs. " +totalBill);

            }
            else if (e.getSource() == printButton) {
           
            /*int units = currentReading - previousReading;
            if (units <= 100)
                totalBill = units;
            else if (units <= 200)
                totalBill = 100 + (units - 100) * 2.5;
            else if (units <= 500)
                totalBill = 100 + 250 + (units - 200) * 4;
            else
                totalBill = 100 + 250 + 1200 + (units - 500) * 6;
*/
            String billDetails = "Customer Number: " + customerNo + "\n" +
                                 "Meter Number: " + meterNo + "\n" +
                                 "Previous Reading: " + previousReading + "\n" +
                                 "Current Reading: " + currentReading + "\n" +
                                 "Total Units: " + units + "\n" +
                                 "Total Bill: Rs. " + totalBill;
            JTextArea textArea = new JTextArea(billDetails);
            JOptionPane.showMessageDialog(frame, textArea);
    }
        }
        if(commercial.isSelected())
             {
              if (e.getSource() == calculateButton) {
                     
                     customerNo = Integer.parseInt(customerNoField.getText());
                     meterNo = Integer.parseInt(meterNoField.getText());
                     previousReading = Integer.parseInt(previousReadingField.getText());
                     currentReading = Integer.parseInt(currentReadingField.getText());

                     units = currentReading - previousReading;
                     if (units <= 100)
                         totalBill = units*2;
                     else if (units <= 200)
                         totalBill = 200 + (units - 100) * 4.5;
                     else if (units <= 500)
                         totalBill = 200 + 450 + (units - 200) * 6;
                     else
                         totalBill = 200 + 450 + 1800 + (units - 500) * 7;

                     JOptionPane.showMessageDialog(frame, "Total Bill: Rs. " +totalBill);

                 }
                 else if (e.getSource() == printButton) {
                 
                 /*int units = currentReading - previousReading;
                 if (units <= 100)
                     totalBill = units;
                 else if (units <= 200)
                     totalBill = 100 + (units - 100) * 2.5;
                 else if (units <= 500)
                     totalBill = 100 + 250 + (units - 200) * 4;
                 else
                     totalBill = 100 + 250 + 1200 + (units - 500) * 6;
*/
                 String billDetails = "Customer Number: " + customerNo + "\n" +
                                      "Meter Number: " + meterNo + "\n" +
                                      "Previous Reading: " + previousReading + "\n" +
                                      "Current Reading: " + currentReading + "\n" +
                                      "Total Units: " + units + "\n" +
                                      "Total Bill: Rs. " + totalBill;
                 JTextArea textArea = new JTextArea(billDetails);
                 JOptionPane.showMessageDialog(frame, textArea);
                 }
              }
       }
public static void main(String[] args) {
    new ElectricityBill();
}
}
