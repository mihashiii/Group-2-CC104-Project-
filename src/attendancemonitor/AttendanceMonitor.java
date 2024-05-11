
package attendancemonitor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;



public class AttendanceMonitor implements ActionListener {
    
    private static JLabel label;
    private static JTextField userText;
    private static JLabel label2;
    private static JPasswordField passText;
    private static JButton button;
    private static JLabel success;
    private static JFrame frame;
    private static JButton bsign;
    private static JLabel header;
    private static JFrame thirdFrame;
    
    private static ArrayList<String> newUser = new ArrayList<>();
    private static ArrayList<String> newPass = new ArrayList<>();
    private static ArrayList<Integer> studentId = new ArrayList<>();
    private static ArrayList<String> course = new ArrayList<>();
    
        static {
            newUser.add ("user");
            newPass.add ("default");
            studentId.add(2023200855);
            course.add("BSIT");
        }
    
         private static ArrayList<String[]> attendanceRecords = new ArrayList<>();
        static {
                attendanceRecords.add(new String[]{"Demo", "2024-05-11", "Present","BSIT"});
                attendanceRecords.add(new String[]{"Demo", "2024-05-11", "Absent","BSIT"});
        }
    

    public static void main(String[] args) {
        LoginPage();
        
     
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
            JOptionPane.showMessageDialog(null, "Username/password field cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (user.equals(newUser.get(i)) && password.equals(newPass.get(i))) {
                MenuPage();
                JOptionPane.showMessageDialog(null,"Welcome back "+user+"!");
                frame.dispose();
            } else {
               JOptionPane.showMessageDialog(null, "Incorrect username/password", "Warning", JOptionPane.WARNING_MESSAGE);

            }
        }
      
    }});
        panel.add(button);
        
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
        JPanel panelTwo = new JPanel ();//(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JFrame frameTwo = new JFrame("Attendance Monitoring");
        frameTwo.setSize(350, 200);
        frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTwo.setLocationRelativeTo(null);
        panelTwo.setBackground(Color.gray);
        panelTwo.setLayout(null);

        JButton attendanceButton = new JButton("Mark Attendance");
       attendanceButton.setBounds(20, 20, 140, 50);
        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttendancePage();
                frameTwo.dispose();
            }
        });
        panelTwo.add(attendanceButton);

        JButton attendanceReportButton = new JButton("Attendance Report"); 
        attendanceReportButton.setBounds(175, 20, 140, 50);
        attendanceReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttendanceReportPage();
                frameTwo.dispose();
            }
        });
        panelTwo.add(attendanceReportButton);

        frameTwo.add(panelTwo);
        frameTwo.setVisible(true);
    }
    
    public static void SignUp() {
    JFrame thirdFrame = new JFrame("Attendance Monitoring");
    JPanel thirdPanel = new JPanel();
    thirdFrame.setSize(350, 270);
    thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thirdFrame.setLocationRelativeTo(null);
    thirdFrame.add(thirdPanel);
    thirdPanel.setLayout(null);

    thirdPanel.setBackground(Color.gray);

    JLabel label = new JLabel("User:");
    label.setForeground(Color.WHITE);
    label.setBounds(10, 50, 100, 25);
    thirdPanel.add(label);

    JTextField userText = new JTextField(20);
    userText.setBounds(100, 50, 200, 25);
    thirdPanel.add(userText);

    JLabel label2 = new JLabel("Password:");
    label2.setForeground(Color.WHITE);
    label2.setBounds(10, 80, 100, 25);
    thirdPanel.add(label2);

    JPasswordField passText = new JPasswordField(20);
    passText.setBounds(100, 80, 200, 25);
    thirdPanel.add(passText);
    
    JLabel studentLbl = new JLabel("Student ID:");
    studentLbl.setForeground(Color.WHITE);
    studentLbl.setBounds(10, 110, 100, 25);
    thirdPanel.add(studentLbl);
    
    JTextField idText = new JTextField(20);
    idText.setBounds(100, 110, 200, 25);
    thirdPanel.add(idText);
    
    JLabel courseLbl = new JLabel("Course:");
    courseLbl.setForeground(Color.WHITE);
    courseLbl.setBounds(10,140, 100, 25);
    thirdPanel.add(courseLbl);
    
    JTextField courseText = new JTextField(20);
    courseText.setBounds(100, 140, 200, 25);
    thirdPanel.add(courseText);


    JButton submit = new JButton("Submit");
    submit.setBounds(220, 180, 80, 25);
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = userText.getText();
            String password = new String(passText.getPassword());
            String Course = courseText.getText(); // Retrieve course information
            
            // Retrieve student identification
            String idTextValue = idText.getText();
            int studentIdentification = 0;
            try {
                studentIdentification = Integer.parseInt(idTextValue);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid student ID.");
                return;
            }
            
            if (user.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the required fields.");
                return; 
            }

            boolean accountExists = false;
            for (int i = 0; i < newUser.size(); i++) {
                if (user.equals(newUser.get(i)) && password.equals(newPass.get(i))) {
                    JOptionPane.showMessageDialog(null, "An account with this username/password already exists.");
                    accountExists = true;
                    break; 
                }
            }

            if (!accountExists) {
                newUser.add(user);
                newPass.add(password);
                studentId.add(studentIdentification);
                course.add(Course); // Add course information
                
                JOptionPane.showMessageDialog(null, "Registered Successfully");
                LoginPage();
                thirdFrame.dispose();
            }
        }
    });
    thirdPanel.add(submit);

    JLabel header = new JLabel("Sign Up");
    header.setFont(new Font("Serif", Font.BOLD, 20));
    header.setForeground(Color.WHITE);
    header.setBounds(135, 0, 300, 25);
    thirdPanel.add(header);

    thirdFrame.setVisible(true);
}
    
    public static void AttendancePage() {
        JPanel attendancePanel = new JPanel ();
        JFrame attendanceFrame = new JFrame ("Attendance");
        attendanceFrame.setSize(350,200);
        attendanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attendanceFrame.setLocationRelativeTo(null);
        attendancePanel.setBackground(Color.gray);
        attendancePanel.setLayout(null);
        
        JLabel attendanceLabel = new JLabel ("Attendance Marked!");
        attendanceLabel.setBounds(100,50,200,25);
        attendancePanel.add(attendanceLabel);
        
        button = new JButton ("Back");
        button.setBounds (125,120,80,25);
        button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            MenuPage();
            attendanceFrame.dispose();
        
    }});
       
        attendancePanel.add(button);
        
       
       String username = userText.getText();
       String currentDate = "2024-05-11";
       String status = "Present";
       String kurso = ""; // 
       for (int i = 0; i < newUser.size(); i++) {
        if (username.equals(newUser.get(i))) {
            kurso = course.get(i);
            break;
        }
    }
        attendanceRecords.add(new String[]{username, currentDate, status,kurso});
        
        attendanceFrame.add(attendancePanel);
        attendanceFrame.setVisible(true);
    }
    
    public static void AttendanceReportPage() {
    JFrame reportFrame = new JFrame("Attendance Report");
    reportFrame.setSize(400, 300);
    reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    reportFrame.setLocationRelativeTo(null);

    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
    reportFrame.add(panel);

    String[] columns = {"Username", "Date", "Status","Section"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable table = new JTable(model);

   
    for (int i = 0; i < attendanceRecords.size(); i++) {
        String[] record = attendanceRecords.get(i);
        model.addRow(record);
}

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(380, 200));
    panel.add(scrollPane);

    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuPage();
            reportFrame.dispose();
        }
    });
    panel.add(backButton);

    reportFrame.setVisible(true);
}
    
}
