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
        private static ArrayList<String> teacherUser = new ArrayList<>();
        private static ArrayList<String> teacherPass = new ArrayList<>();
        private static ArrayList<Boolean> marked = new ArrayList<>();

            static {
                newUser.add ("user");
                newPass.add ("default");
                studentId.add(2023200855);
                course.add("BSIT");
                teacherUser.add("123");
                teacherPass.add("123");
                marked.add(false);


            }

        private static ArrayList<String[]> attendanceRecords = new ArrayList<>();
            static {
                    attendanceRecords.add(new String[]{"Demo", "2024-05-11", "Present","BSIT"});
                    attendanceRecords.add(new String[]{"Demo", "2024-05-11", "Absent","BSIT"});
            }

        public static void main(String[] args) {
           LoginPage();
        }


        public static void LoginPage() {
                // Frame settings
                frame = new JFrame("Attendance Monitoring");
                frame.setSize(350, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                // Main panel settings
                JPanel panel = new JPanel();
                panel.setBackground(new Color(224, 176, 255));
                panel.setLayout(null);
                frame.add(panel);

                // Header settings
                JLabel header = new JLabel("Attendance Monitoring System");
                header.setFont(new Font("Serif", Font.BOLD, 20));
                header.setForeground(Color.BLACK);
                header.setBounds(37, 10, 300, 25);
                panel.add(header);

                
                JLabel label = new JLabel("Username:");
                label.setForeground(Color.BLACK);
                label.setBounds(15, 50, 80, 25);
                panel.add(label);

                userText = new JTextField(20);
                userText.setBounds(100, 50, 200, 25);
                panel.add(userText);

                
                JLabel label2 = new JLabel("Password:");
                label2.setForeground(Color.BLACK);
                label2.setBounds(15, 80, 80, 25);
                panel.add(label2);

                passText = new JPasswordField(20);
                passText.setBounds(100, 80, 200, 25);
                panel.add(passText);

                // Settings ng login button
                JButton button = new JButton("Login");
                button.setBounds(220, 120, 80, 25);
                button.setBackground(new Color(80, 154, 239));
                button.setForeground(Color.WHITE);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = userText.getText();
                        String password = passText.getText();

                        boolean foundUser = false;

                        for (int i = 0; i < newUser.size(); i++) {
                            if (user.isEmpty() || password.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Username/password field cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
                                return;
                            } else if (user.equals(newUser.get(i)) && password.equals(newPass.get(i))) {
                                MenuPage();
                                JOptionPane.showMessageDialog(null, "Welcome back " + user + "!");
                                frame.dispose();
                                foundUser = true;
                                break;
                            } else if (user.equals(teacherUser.get(0)) && password.equals(teacherPass.get(0))) {
                                teacherAdmin();
                                JOptionPane.showMessageDialog(null, "Welcome ADMIN!");
                                frame.dispose();
                                foundUser = true;
                                break;
                            }
                        }

                        if (!foundUser) {
                            JOptionPane.showMessageDialog(null, "Incorrect username/password", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
                panel.add(button);

                // Settings ng signup button
                JButton bsign = new JButton("Sign Up");
                bsign.setBounds(100, 120, 80, 25);
                bsign.setBackground(new Color(80, 154, 239));
                bsign.setForeground(Color.WHITE);
                bsign.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SignUp();
                        frame.dispose();
                    }
                });
                panel.add(bsign);

               
                frame.setVisible(true);
}

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        public static void MenuPage() {
                // Settings ng frame
                JFrame frameTwo = new JFrame("Attendance Monitoring");
                frameTwo.setSize(600, 350);
                frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTwo.setLocationRelativeTo(null);
                frameTwo.setResizable(false);

                // Main panel 
                JPanel panelTwo = new JPanel();
                panelTwo.setBackground(new Color(224, 176, 255));
                panelTwo.setLayout(null);
                frameTwo.add(panelTwo);

                // Student Label Settings
                JLabel label = new JLabel("Student");
                label.setFont(new Font("Serif", Font.BOLD, 35));
                label.setForeground(Color.WHITE);
                label.setBounds(225, 5, 220, 50);
                panelTwo.add(label);

                // Settings ng attendance button
                JButton attendanceButton = new JButton("Mark Attendance");
                attendanceButton.setFont(new Font("Arial", Font.BOLD, 15));
                attendanceButton.setBounds(85, 80, 200, 50);
                attendanceButton.setBackground(new Color(80, 154, 239));
                attendanceButton.setForeground(Color.WHITE);
                attendanceButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = userText.getText();
                        int index = newUser.indexOf(username);

                        if (!marked.get(index)) {
                            marked.set(index, Boolean.TRUE);
                            AttendancePage();
                            frameTwo.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "You are already marked present.");
                        }
                    }
                });
                panelTwo.add(attendanceButton);

                // Settings ng attendance report button
                JButton attendanceReportButton = new JButton("Attendance Report");
                attendanceReportButton.setFont(new Font("Arial", Font.BOLD, 15));
                attendanceReportButton.setBounds(300, 80, 200, 50);
                attendanceReportButton.setBackground(new Color(80, 154, 239));
                attendanceReportButton.setForeground(Color.WHITE);
                attendanceReportButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AttendanceReportPage();
                        frameTwo.dispose();
                    }
                });
                panelTwo.add(attendanceReportButton);

                // Settings ng logout button
                JButton logoutButton = new JButton("Logout");
                logoutButton.setFont(new Font("Arial", Font.BOLD, 15));
                logoutButton.setBackground(new Color(220, 122, 115));
                logoutButton.setForeground(Color.WHITE);
                logoutButton.setBounds(400, 250, 150, 35);
                logoutButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginPage();
                        frameTwo.dispose();
                    }
                });
                
                // Settings ng header panel
                JPanel panelHeader = new JPanel();
                panelHeader.setBounds(0, 0, 600, 60);
                panelHeader.setBackground(new Color(212, 152, 245));
                panelTwo.add(panelHeader);
                
                panelTwo.add(logoutButton);

              
                frameTwo.setVisible(true);
}

        public static void SignUp() {
                // Frame settings
                JFrame thirdFrame = new JFrame("Attendance Monitoring");
                thirdFrame.setSize(350, 270);
                thirdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thirdFrame.setLocationRelativeTo(null);
                thirdFrame.setResizable(false);

                // Main panel settings
                JPanel thirdPanel = new JPanel();
                thirdPanel.setLayout(null);
                thirdPanel.setBackground(new Color(224, 176, 255));
                thirdFrame.add(thirdPanel);

                // Header label settings
                JLabel header = new JLabel("Sign Up");
                header.setFont(new Font("Serif", Font.BOLD, 20));
                header.setForeground(Color.BLACK);
                header.setBounds(135, 0, 300, 25);
                thirdPanel.add(header);

                // User label and text field settings
                JLabel label = new JLabel("User:");
                label.setForeground(Color.BLACK);
                label.setBounds(10, 50, 100, 25);
                thirdPanel.add(label);

                JTextField userText = new JTextField(20);
                userText.setBounds(100, 50, 200, 25);
                thirdPanel.add(userText);

                // Password label and text field settings
                JLabel label2 = new JLabel("Password:");
                label2.setForeground(Color.BLACK);
                label2.setBounds(10, 80, 100, 25);
                thirdPanel.add(label2);

                JPasswordField passText = new JPasswordField(20);
                passText.setBounds(100, 80, 200, 25);
                thirdPanel.add(passText);

                // Student ID label and text field settings
                JLabel studentLbl = new JLabel("Student ID:");
                studentLbl.setForeground(Color.BLACK);
                studentLbl.setBounds(10, 110, 100, 25);
                thirdPanel.add(studentLbl);

                JTextField idText = new JTextField(20);
                idText.setBounds(100, 110, 200, 25);
                thirdPanel.add(idText);

                // Course label and text field settings
                JLabel courseLbl = new JLabel("Course:");
                courseLbl.setForeground(Color.BLACK);
                courseLbl.setBounds(10, 140, 100, 25);
                thirdPanel.add(courseLbl);

                JTextField courseText = new JTextField(20);
                courseText.setBounds(100, 140, 200, 25);
                thirdPanel.add(courseText);

                // Back button settings
                JButton backButton = new JButton("Back");
                backButton.setBounds(100, 180, 80, 25);
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginPage();
                        thirdFrame.dispose();
                    }
                });
                thirdPanel.add(backButton);

                // Submit button settings
                JButton submit = new JButton("Submit");
                submit.setBounds(220, 180, 80, 25);
                submit.setBackground(new Color(80, 154, 239));
                submit.setForeground(Color.WHITE);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = userText.getText();
                        String password = new String(passText.getPassword());
                        String Course = courseText.getText();  
                        String idTextValue = idText.getText();

                        if (user.isEmpty() || password.isEmpty() || Course.isEmpty() || idTextValue.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill in the required fields.");
                            return; 
                        }

                        int studentIdentification = 0;
                        try {
                            studentIdentification = Integer.parseInt(idTextValue);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid student ID.");
                            return;
                        }

                        boolean accountExists = false;
                        for (int i = 0; i < newUser.size(); i++) {
                            if (user.equals(newUser.get(i))) {
                                JOptionPane.showMessageDialog(null, "An account with this username/password already exists.");
                                accountExists = true;
                                break; 
                            }
                        }

                        if (!accountExists) {
                            newUser.add(user);
                            newPass.add(password);
                            studentId.add(studentIdentification);
                            course.add(Course);
                            marked.add(false);

                            JOptionPane.showMessageDialog(null, "Registered Successfully");
                            LoginPage();
                            thirdFrame.dispose();
                        }
                    }
                });
                thirdPanel.add(submit);

                
                thirdFrame.setVisible(true);
     }

        public static void AttendancePage() {
                // Frame settings
                JFrame attendanceFrame = new JFrame("Attendance");
                attendanceFrame.setSize(350, 200);
                attendanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                attendanceFrame.setLocationRelativeTo(null);
                attendanceFrame.setResizable(false);

                // Main panel settings
                JPanel attendancePanel = new JPanel();
                attendancePanel.setBackground(new Color(224, 176, 255));
                attendancePanel.setLayout(null);
                attendanceFrame.add(attendancePanel);

                // Attendance label settings
                JLabel attendanceLabel = new JLabel("Attendance Marked!");
                attendanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
                attendanceLabel.setForeground(Color.BLACK);
                attendanceLabel.setBounds(65, 10, 200, 25);
                attendancePanel.add(attendanceLabel);

                // Mark attendance logic
                String username = userText.getText();
                String currentDate = "2024-05-11";
                String status = "Present";
                String kurso = "";
                for (int i = 0; i < newUser.size(); i++) {
                    if (username.equals(newUser.get(i))) {
                        kurso = course.get(i);
                        break;
                    }
                }
                attendanceRecords.add(new String[]{username, currentDate, status, kurso});

                // Details label settings
                JLabel details = new JLabel("<html>Username: " + username + "<br>Date: " + currentDate + "<br>Status: " + status + "</html>");
                details.setFont(new Font("Calibri", Font.BOLD, 15));
                details.setHorizontalAlignment(JLabel.CENTER);
                details.setForeground(Color.BLACK);
                details.setBounds(65, 45, 200, 75);
                attendancePanel.add(details);

                // Back button settings
                JButton backButton = new JButton("Back");
                backButton.setBounds(125, 130, 80, 25);
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MenuPage();
                        attendanceFrame.dispose();
                    }
                });
                attendancePanel.add(backButton);

             
                attendanceFrame.setVisible(true);
}

        public static void AttendanceReportPage() {
            // Frame setup
            JFrame reportFrame = new JFrame("Attendance Report");
            reportFrame.setSize(600, 400);
            reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reportFrame.setLocationRelativeTo(null);
            reportFrame.setResizable(false);

            // Main panel setup
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            panel.setBackground(new Color(224, 176, 255));
            reportFrame.add(panel);

            // Table setup
            String[] columns = {"Username", "Date", "Status", "Course"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable table = new JTable(model);

            // Adding records to the table model
            for (int i = 0; i < attendanceRecords.size(); i++) {
                String[] record = attendanceRecords.get(i);
                model.addRow(record);
            }

            // Scroll pane setup
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(580, 300));
            panel.add(scrollPane);

            // Back button setup
            JButton backButton = new JButton("Back");
            backButton.setBackground(new Color(80, 154, 239));
            backButton.setForeground(Color.WHITE);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MenuPage();
                    reportFrame.dispose();
                }
            });
            panel.add(backButton);

            // Make the frame visible
            reportFrame.setVisible(true);
}

        public static void teacherAdmin() {
                // Frame settings
                JFrame frameTwo = new JFrame("Attendance Monitoring");
                frameTwo.setSize(600, 350);
                frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTwo.setLocationRelativeTo(null);
                frameTwo.setResizable(false);

                // Main panel settings
                JPanel panelOne = new JPanel();
                panelOne.setLayout(null);
                panelOne.setBackground(new Color(224, 176, 255));
                frameTwo.add(panelOne);

                // Admin label settings
                JLabel admin = new JLabel("Administrator");
                admin.setFont(new Font("Serif", Font.BOLD, 35));
                admin.setForeground(Color.WHITE);
                admin.setBounds(178, 10, 220, 50);
                panelOne.add(admin);

                // Header panel settings
                JPanel panelHeader = new JPanel();
                panelHeader.setBounds(0, 0, 600, 70);
                panelHeader.setBackground(new Color(212, 152, 245));
                panelOne.add(panelHeader);

                // Check Attendance button settings
                JButton button = new JButton("Check Attendance");
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setBounds(85, 95, 200, 50);
                button.setBackground(new Color(80, 154, 239));
                button.setForeground(Color.WHITE);
                panelOne.add(button);

                
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AttendancePageAdmin();
                        frameTwo.dispose();
                    }
                });

                // Add Students button settings
                JButton addStudents = new JButton("Add Students");
                addStudents.setFont(new Font("Arial", Font.BOLD, 15));
                addStudents.setBounds(85, 165, 200, 50);
                addStudents.setBackground(new Color(80, 154, 239));
                addStudents.setForeground(Color.WHITE);
                panelOne.add(addStudents);

                // Add action listener for Add Students button
                addStudents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addStudents();
                        frameTwo.dispose();
                    }
                });

                // Remove Students button settings
                JButton removeStudents = new JButton("Remove Students");
                removeStudents.setFont(new Font("Arial", Font.BOLD, 15));
                removeStudents.setBounds(300, 165, 200, 50);
                removeStudents.setBackground(new Color(80, 154, 239));
                removeStudents.setForeground(Color.WHITE);
                panelOne.add(removeStudents);

               
                removeStudents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeStudents();
                        frameTwo.dispose();
                    }
                });

                // Edit Students button settings
                JButton editStudents = new JButton("Edit Students");
                editStudents.setFont(new Font("Arial", Font.BOLD, 15));
                editStudents.setBounds(300, 95, 200, 50);
                editStudents.setBackground(new Color(80, 154, 239));
                editStudents.setForeground(Color.WHITE);
                panelOne.add(editStudents);

              
                editStudents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EditStudents();
                        frameTwo.dispose();
                    }
                });

                // Logout button settings
                JButton logout = new JButton("Logout");
                logout.setFont(new Font("Arial", Font.BOLD, 15));
                logout.setBackground(new Color(220, 122, 115));
                logout.setForeground(Color.WHITE);
                logout.setBounds(400, 250, 150, 35);
                panelOne.add(logout);

              
                logout.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginPage();
                        frameTwo.dispose();
                    }
                });

               
                frameTwo.setVisible(true);
}

        public static void AttendancePageAdmin() {
                // Frame settings
                JFrame reportFrame = new JFrame("Attendance Report");
                reportFrame.setSize(600, 400);
                reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reportFrame.setLocationRelativeTo(null);
                reportFrame.setResizable(false);

                // Main panel settings
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
                reportFrame.add(panel);
                panel.setBackground(new Color(224, 176, 255));

                // Table setup
                String[] columns = {"Username", "Date", "Status", "Course"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                JTable table = new JTable(model);

                // Logic para makapaglagay sa table
                for (int i = 0; i < attendanceRecords.size(); i++) {
                    String[] record = attendanceRecords.get(i);
                    model.addRow(record);
                }

                // Scroll pane setup pang size din sa table
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(580, 300));
                panel.add(scrollPane);

                // Back button settings
                JButton backButton = new JButton("Back");
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teacherAdmin();
                        reportFrame.dispose();
                    }
                });
                panel.add(backButton);

               
                reportFrame.setVisible(true);
}

        public static void addStudents() {
                // Frame settings
                JFrame reportFrame = new JFrame("Add Students");
                reportFrame.setSize(600, 400);
                reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reportFrame.setLocationRelativeTo(null);
                reportFrame.setResizable(false);

                // Main panel settings
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
                reportFrame.add(panel);
                panel.setBackground(new Color(224, 176, 255));

                // Table setup
                String[] columns = {"Username", "Password", "Course"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                JTable table = new JTable(model);

                // Panglagay sa table na logic
                for (int i = 0; i < newUser.size(); i++) {
                    String username = newUser.get(i);
                    String password = newPass.get(i);
                    String kurso = course.get(i);
                    model.addRow(new Object[]{username, password, kurso});
                }

                // Scroll pane settings pang size din ng table
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(580, 300));
                panel.add(scrollPane);

                // Add button settings
                JButton addButton = new JButton("Add");
                addButton.setBackground(new Color(80, 154, 239));
                addButton.setForeground(Color.WHITE);
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddStudentPopUp();
                    }
                });
                panel.add(addButton);

                // Back button settings
                JButton backButton = new JButton("Back");
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teacherAdmin();
                        reportFrame.dispose();
                    }
                });
                panel.add(backButton);

               
                reportFrame.setVisible(true);
}
        
        public static void removeStudents() {
                // Frame settings
                JFrame reportFrame = new JFrame("Remove Students");
                reportFrame.setSize(600, 400);
                reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reportFrame.setLocationRelativeTo(null);
                reportFrame.setResizable(false);

                // Main panel settings
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
                reportFrame.add(panel);
                panel.setBackground(new Color(224, 176, 255));

                // Table setup
                String[] columns = {"Username", "Password", "Course"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                JTable table = new JTable(model);

                
                for (int i = 0; i < newUser.size(); i++) {
                    String username = newUser.get(i);
                    String password = newPass.get(i);
                    String kurso = course.get(i);
                    model.addRow(new Object[]{username, password, kurso});
                }

                // Scroll pane setup
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(580, 300));
                panel.add(scrollPane);

                // Remove button settings
                JButton removeButton = new JButton("Remove");
                removeButton.setBackground(new Color(80, 154, 239));
                removeButton.setForeground(Color.WHITE);
                removeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String usernameToRemove = JOptionPane.showInputDialog(null, "Enter the username of the student to remove:");
                        if (usernameToRemove != null && !usernameToRemove.isEmpty()) {
                            int indexToRemove = newUser.indexOf(usernameToRemove);
                            if (indexToRemove != -1) {
                                newUser.remove(indexToRemove);
                                newPass.remove(indexToRemove);
                                course.remove(indexToRemove);
                                model.removeRow(indexToRemove);
                                JOptionPane.showMessageDialog(null, "Student removed successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Student not found.");
                            }
                        }
                    }
                });
                panel.add(removeButton);

                // Back button settings
                JButton backButton = new JButton("Back");
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teacherAdmin();
                        reportFrame.dispose();
                    }
                });
                panel.add(backButton);

           
                reportFrame.setVisible(true);
}

        public static void AddStudentPopUp() {
                // Frame settings
                JFrame thirdFrame = new JFrame("Add Student");
                thirdFrame.setSize(350, 270);
                thirdFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                thirdFrame.setLocationRelativeTo(null);
                thirdFrame.setResizable(false);

                // Main panel settings
                JPanel thirdPanel = new JPanel();
                thirdPanel.setBackground(new Color(224, 176, 255));
                thirdPanel.setLayout(null);
                thirdFrame.add(thirdPanel);

                // Labels and text fields for user input
                JLabel label = new JLabel("User:");
                label.setForeground(Color.BLACK);
                label.setBounds(10, 50, 100, 25);
                thirdPanel.add(label);

                JTextField userText = new JTextField(20);
                userText.setBounds(100, 50, 200, 25);
                thirdPanel.add(userText);

                JLabel label2 = new JLabel("Password:");
                label2.setForeground(Color.BLACK);
                label2.setBounds(10, 80, 100, 25);
                thirdPanel.add(label2);

                JPasswordField passText = new JPasswordField(20);
                passText.setBounds(100, 80, 200, 25);
                thirdPanel.add(passText);

                JLabel studentLbl = new JLabel("Student ID:");
                studentLbl.setForeground(Color.BLACK);
                studentLbl.setBounds(10, 110, 100, 25);
                thirdPanel.add(studentLbl);

                JTextField idText = new JTextField(20);
                idText.setBounds(100, 110, 200, 25);
                thirdPanel.add(idText);

                JLabel courseLbl = new JLabel("Course:");
                courseLbl.setForeground(Color.BLACK);
                courseLbl.setBounds(10, 140, 100, 25);
                thirdPanel.add(courseLbl);

                JTextField courseText = new JTextField(20);
                courseText.setBounds(100, 140, 200, 25);
                thirdPanel.add(courseText);

                // Buttons for actions
                JButton backButton = new JButton("Cancel");
                backButton.setBounds(100, 180, 80, 25);
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thirdFrame.dispose();
                    }
                });
                thirdPanel.add(backButton);

                JButton submit = new JButton("Submit");
                submit.setBounds(220, 180, 80, 25);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Getting inputs sa mga user
                        String user = userText.getText();
                        String password = new String(passText.getPassword());
                        String Course = courseText.getText();
                        String idTextValue = idText.getText();

                        // Validating inputs
                        if (user.isEmpty() || password.isEmpty() || Course.isEmpty() || idTextValue.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill in the required fields.");
                            return;
                        }

                        int studentIdentification = 0;
                        try {
                            studentIdentification = Integer.parseInt(idTextValue);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid student ID.");
                            return;
                        }

                        // Checking for existing account
                        boolean accountExists = false;
                        for (int i = 0; i < newUser.size(); i++) {
                            if (user.equals(newUser.get(i))) {
                                JOptionPane.showMessageDialog(null, "An account with this username/password already exists.");
                                accountExists = true;
                                break;
                            }
                        }

                        // Pang add ng new student if no account exists
                        if (!accountExists) {
                            newUser.add(user);
                            newPass.add(password);
                            studentId.add(studentIdentification);
                            course.add(Course);
                            marked.add(false);

                            JOptionPane.showMessageDialog(null, "Added Successfully");
                            addStudents();
                            thirdFrame.dispose();
                        }
                    }
                });
                thirdPanel.add(submit);

              
                JLabel header = new JLabel("Add Student");
                header.setFont(new Font("Serif", Font.BOLD, 20));
                header.setForeground(Color.WHITE);
                header.setBounds(120, 0, 300, 25);
                thirdPanel.add(header);

                
                thirdFrame.setVisible(true);
}
    
        public static void EditStudents() {
                // Frame settings
                JFrame reportFrame = new JFrame("Edit Students");
                reportFrame.setSize(600, 400);
                reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reportFrame.setLocationRelativeTo(null);
                reportFrame.setResizable(false);

                // Panel settings
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); 
                reportFrame.add(panel);
                panel.setBackground(new Color(224, 176, 255));

                // Table creation
                String[] columns = {"Username", "Password", "Course"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                JTable table = new JTable(model);

                
                for (int i = 0; i < newUser.size(); i++) {
                    String username = newUser.get(i);
                    String password = newPass.get(i);
                    String kurso = course.get(i);
                    model.addRow(new Object[]{username, password, kurso});
                }

                // Scroll pane for the table
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setPreferredSize(new Dimension(580, 300));
                panel.add(scrollPane);

                // Edit button
                JButton editButton = new JButton("Edit");
                editButton.setBackground(new Color(80, 154, 239));
                editButton.setForeground(Color.WHITE);
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EditDetailsPopUp();
                    }
                });
                panel.add(editButton);

                // Back button
                JButton backButton = new JButton("Back");
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.WHITE);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        teacherAdmin();
                        reportFrame.dispose();
                    }
                });
                panel.add(backButton);

               
                reportFrame.setVisible(true);
}
        
        public static void EditDetailsPopUp() {
                // Prompt for the username to be edited
                String edit = JOptionPane.showInputDialog(null, "Enter username to edit.");

                // Check if the username exists in the list
                if (!newUser.contains(edit)) {
                    JOptionPane.showMessageDialog(null, "User does not exist.");
                    return;
                }

                // Find the index of the username in the lists
                int index = newUser.indexOf(edit);

                // Create the frame and panel
                JFrame thirdFrame = new JFrame("Edit Student");
                JPanel thirdPanel = new JPanel();
                thirdFrame.setSize(350, 270);
                thirdFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                thirdFrame.setLocationRelativeTo(null);
                thirdFrame.add(thirdPanel);
                thirdPanel.setLayout(null);
                thirdFrame.setResizable(false);

                // Set background color
                thirdPanel.setBackground(new Color(224, 176, 255));

                // Add labels and text fields for user information
                JLabel label = new JLabel("User:");
                label.setForeground(Color.black);
                label.setBounds(10, 50, 100, 25);
                thirdPanel.add(label);
                JTextField userText = new JTextField(20);
                userText.setBounds(100, 50, 200, 25);
                thirdPanel.add(userText);

                JLabel label2 = new JLabel("Password:");
                label2.setForeground(Color.black);
                label2.setBounds(10, 80, 100, 25);
                thirdPanel.add(label2);
                JPasswordField passText = new JPasswordField(20);
                passText.setBounds(100, 80, 200, 25);
                thirdPanel.add(passText);

                JLabel studentLbl = new JLabel("Student ID:");
                studentLbl.setForeground(Color.black);
                studentLbl.setBounds(10, 110, 100, 25);
                thirdPanel.add(studentLbl);
                JTextField idText = new JTextField(20);
                idText.setBounds(100, 110, 200, 25);
                thirdPanel.add(idText);

                JLabel courseLbl = new JLabel("Course:");
                courseLbl.setForeground(Color.black);
                courseLbl.setBounds(10, 140, 100, 25);
                thirdPanel.add(courseLbl);
                JTextField courseText = new JTextField(20);
                courseText.setBounds(100, 140, 200, 25);
                thirdPanel.add(courseText);

                JButton backButton = new JButton("Cancel");
                backButton.setBounds(100, 180, 80, 25);
                backButton.setBackground(new Color(80, 154, 239));
                backButton.setForeground(Color.white);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thirdFrame.dispose();
                    }
                });
                thirdPanel.add(backButton);

                // Button for submitting the changes
                JButton submit = new JButton("Submit");
                submit.setBounds(220, 180, 80, 25);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve user information from text fields
                        String user = userText.getText();
                        String password = new String(passText.getPassword());
                        String Course = courseText.getText();
                        String idTextValue = idText.getText();

                        // Check if any field is empty
                        if (user.isEmpty() || password.isEmpty() || Course.isEmpty() || idTextValue.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill in the required fields.");
                            return;
                        }

                        int studentIdentification = 0;
                        try {
                            studentIdentification = Integer.parseInt(idTextValue);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid student ID.");
                            return;
                        }

                        // Update user information
                        newUser.set(index, user);
                        newPass.set(index, password);
                        studentId.set(index, studentIdentification);
                        course.set(index, Course);
                        marked.set(index, false);

                        JOptionPane.showMessageDialog(null, "Edited Successfully");
                        addStudents();
                        thirdFrame.dispose();
                    }
                });
                thirdPanel.add(submit);

                JLabel header = new JLabel("Add Student");
                header.setFont(new Font("Serif", Font.BOLD, 20));
                header.setForeground(Color.WHITE);
                header.setBounds(120, 0, 300, 25);
                thirdPanel.add(header);

                thirdFrame.setVisible(true);
}
        
    }
    
