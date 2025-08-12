import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SignInPage implements ActionListener {
    private BankAccountFunction account;

    JFrame frame = new JFrame();
    JLabel userNameText = new JLabel("UserName");
    JLabel passwordText = new JLabel("Password");
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap<>();

    SignInPage(HashMap<String, String> loginInfoOriginal, BankAccountFunction account) {
        this.logininfo = loginInfoOriginal;
        this.account = account;

        userNameText.setBounds(50,100, 75, 25 );
        userNameField.setBounds(125,100,200, 25);

        passwordText.setBounds(50,150,75,25);
        passwordField.setBounds(125,150,200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusPainted(false);

        resetButton.setBounds(225,200,100, 25 );
        resetButton.addActionListener(this);
        resetButton.setFocusPainted(false);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));


        frame.add(userNameText);
        frame.add(passwordText);
        frame.add(userNameField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton) {
            userNameField.setText("");
            passwordField.setText("");
        }
        if(e.getSource() == loginButton) {
            String username = userNameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if(logininfo.containsKey(username)) {
                if(logininfo.get(username).equals(password)) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("successful");
                    frame.dispose();
                    new BankAccountGui(account).setVisible(true);
                }
                else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong password");
                }

            }
            else {
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Username not found");
            }

        }

    }
}
