import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountGui extends JFrame {
    private BankAccountFunction account;
    private JLabel balanceText;

    public BankAccountGui(BankAccountFunction account){

        this.account = account;

        // setup gui and title
        setTitle("Bank Account");

        // ends program once close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //size of gui
        setSize(700, 600);

        // center gui to screen
        setLocationRelativeTo(null);

        // make layout manager null to manually position within the gui
        setLayout(null);

        // prevent resizing of gui
        setResizable(false);

        // set background color
        Color blueColor = new Color( 5, 79, 181 );
        getContentPane().setBackground(blueColor);

        addGuiComponents();


    }
    private void addGuiComponents(){
        // Set location, size, and font for deposit components "
        JLabel depositText = new JLabel("Deposit");
        depositText.setBounds(37, 30,200, 50);
        depositText.setFont(new Font("Dialog", Font.BOLD, 30));
        depositText.setForeground(Color.BLACK);
        add(depositText);

        JTextField depositSearchField = new JTextField();
        depositSearchField.setBounds(180, 40,300, 35);
        depositSearchField.setFont(new Font("Dialog", Font.PLAIN,20));
        add(depositSearchField);

        JButton depositButton = new JButton("deposit");
        depositButton.setBounds(510, 40, 150 ,35);
        depositButton.setFont(new Font("Dialog", Font.BOLD , 20));
        depositButton.setBackground(Color.CYAN);
        depositButton.setForeground(Color.BLACK);
        depositButton.setBorderPainted(false);
        depositButton.setFocusPainted(false);
        add(depositButton);

        // Set location, size, and font for withdraw components
        JLabel withdrawText = new JLabel("Withdrawal");
        withdrawText.setBounds(37, 140, 140, 50);
        withdrawText.setFont(new Font("Dialog", Font.BOLD, 22));
        withdrawText.setForeground(Color.BLACK);
        add(withdrawText);

        JTextField withdrawSearchField = new JTextField();
        withdrawSearchField.setBounds(180, 150,300, 35);
        withdrawSearchField.setFont(new Font("Dialog", Font.PLAIN,20));
        add(withdrawSearchField);

        JButton withdrawButton = new JButton("withdraw");
        withdrawButton.setBounds(510, 150, 150 ,35);
        withdrawButton.setFont(new Font("Dialog", Font.BOLD , 20));
        withdrawButton.setBackground(Color.CYAN);
        withdrawButton.setForeground(Color.BLACK);
        withdrawButton.setBorderPainted(false);
        withdrawButton.setFocusPainted(false);
        add(withdrawButton);

        // Set location, size, and font for withdraw components
        balanceText = new JLabel("Balance: $0.00");
        balanceText.setBounds(30, 300, 600, 60);
        balanceText.setFont(new Font("Dialog", Font.BOLD, 40));
        balanceText.setForeground(Color.BLACK);
        add(balanceText);

        // gets input amount then call account.deposit in BankAccountFunction.java to do calculation.
        // finally updates the balance
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double depositAmount = Double.parseDouble(depositSearchField.getText());
                    account.deposit(depositAmount);
                    updateBalance();
                    depositSearchField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "please enter a valid number for deposit.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        // gets input amount then call account.withdraw in BankAccountFunction.java to do calculation.
        // finally updates the balance
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawAmount = Double.parseDouble(withdrawSearchField.getText());
                    account.withdraw(withdrawAmount);
                    updateBalance();
                   withdrawSearchField.setText("");
                   //error handing
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "please enter a valid number for Withdrawal.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });



    }
    // since balanceText is used in the same class the method is private. formats the balance then displays it.
    private void updateBalance() {
        balanceText.setText("Balance: $" + String.format("%,.2f", account.getBalance()));
    }
}




