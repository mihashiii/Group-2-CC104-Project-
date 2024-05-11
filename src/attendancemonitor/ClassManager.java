
package attendancemonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ClassManager implements ActionListener {
    private static JLabel label;
    private static JTextField userText;
    private static JLabel label2;
    private static JPasswordField passText;
    private static JButton button;
    private static JLabel success;
    private static JFrame frame;
    private static JButton bsign;
    private static JLabel header;
    
    private static ArrayList<String> newUser = new ArrayList<>();
    private static ArrayList<String> newPass = new ArrayList<>();
    
    static {
        newUser.add ("user");
        newPass.add ("admin");
    }
    
        public static void LoginPage () {
         JPanel panel = new JPanel ();
        frame = new JFrame ("Attendance Monitoring");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        
     
        
        panel.setBackground(Color.gray);
        
        panel.setLayout(null);
        
        label = new JLabel ("Username:");
        label.setForeground(Color.WHITE);
        label.setBounds(10,50,80,25);
        panel.add(label);
        
        userText = new JTextField(20);
        userText.setBounds(100,50,200,25);
        panel.add(userText);
        
        label2 = new JLabel ("Password:");
        label2.setForeground(Color.WHITE);
        label2.setBounds (10,80, 80, 25);
        panel.add(label2);
        
        passText = new JPasswordField(20);
        passText.setBounds(100,80, 200, 25);
        panel.add(passText);
        
        button = new JButton ("Login");
        button.setBounds (220,120,80,25);
        button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) { 
        String user = userText.getText();
        String password = passText.getText();
        
        for (int i = 0; i < newUser.size(); i++) {
       
            if(user.isEmpty() || password.isEmpty()) {
                success.setText ("Input Details!");
            } else if (user.equals(newUser.get(i)) && password.equals(newPass.get(i))) {
                MenuPage();
                frame.dispose();
            }
        }
      
    }});
        panel.add(button);
        
        success = new JLabel ("");
        success.setForeground(Color.RED);
        success.setBounds(10,120,300,25);
        panel.add(success);
        
        
        bsign = new JButton ("Sign Up");
        bsign.setBounds (100,120,80,25);
        bsign.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            SignUp();
            frame.dispose();
            
        }
      
    });
        panel.add(bsign);
        
        JLabel header = new JLabel ("Attendance Monitoring System");
        header.setFont(new Font("Serif",Font.BOLD,20));
        header.setForeground(Color.WHITE);
        header.setBounds(35,0,300,25);
        panel.add(header);
        
        
        frame.setVisible(true);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
    
    
    
    public static void MenuPage () {
        
        
    }
    
    public static void SignUp () {
        JFrame thirdFrame = new JFrame ("Attendance Monitoring");
        JPanel thirdPanel = new JPanel ();
        thirdFrame = new JFrame ("Attendance Monitoring");
        thirdFrame.setSize(350,200);
        thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thirdFrame.setLocationRelativeTo(null);
        thirdFrame.add(thirdPanel);
        thirdPanel.setLayout(null);
        
        thirdPanel.setBackground(Color.gray);
        
        label = new JLabel ("New Username:");
        label.setForeground(Color.WHITE);
        label.setBounds(10,50,100,25);
        thirdPanel.add(label);
        
        userText = new JTextField(20);
        userText.setBounds(100,50,200,25);
        thirdPanel.add(userText);
        
        label2 = new JLabel ("New Password:");
        label2.setForeground(Color.WHITE);
        label2.setBounds (10,80, 100, 25);
        thirdPanel.add(label2);
        
        passText = new JPasswordField(20);
        passText.setBounds(100,80, 200, 25);
        thirdPanel.add(passText);
        
        JButton submit = new JButton ("Submit");
        submit.setBounds (220,120,80,25);
        submit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) { 
        String user = userText.getText();
        String password = passText.getText();
        
        newUser.add(user);
        newPass.add(password);
        
        LoginPage();
  
    }});
        thirdPanel.add(submit);
        
        header = new JLabel ("Sign Up");
        header.setFont(new Font("Serif",Font.BOLD,20));
        header.setForeground(Color.WHITE);
        header.setBounds(135,0,300,25);
        thirdPanel.add(header);
        
        thirdFrame.setVisible (true);
     
    }
}

