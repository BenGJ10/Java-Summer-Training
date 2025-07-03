/*
    Steps to Connect to JDBC:
        1. Registry JDBC Driver: This is usually done automatically with modern JDBC drivers. Class.forName("com.mysql.cj.jdbc.Driver") can be used for MySQL.w
        2. Create Connection: Use `DriverManager.getConnection()` to establish a connection to the database.
        3. Create Statement: Use `Connection.createStatement()` to create a statement object for sending SQL statements to the database.
        4. Execute Query: Use `Statement.executeQuery()` for SELECT statements or `Statement.executeUpdate()` for INSERT, UPDATE, DELETE statements. 
                         `PreparedStatement` can also be used for parameterized queries.
        5. Process Results: For SELECT statements, process the `ResultSet` returned by `executeQuery()`.
        6. Close Connection: Always close the `ResultSet`, `Statement`, and `Connection` objects to free up resources.
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyJFrameClass frame = new MyJFrameClass();
            frame.setSize(600, 700);
            frame.setMinimumSize(new Dimension(500, 600));
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
        });
    }
}

class MyJFrameClass extends JFrame {
    private JTextField regNoField, firstNameField, surnameField, ageField, cgpaField, actionField;
    private JTextArea resultArea;
    private JLabel statusLabel, resultLabel, retrieveLabel, actionLabel;
    private JButton createButton, retrieveButton, updateButton, deleteButton, clearButton, exitButton;
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crud_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Change to your MySQL password

    public MyJFrameClass() {
        setTitle("Student Management System");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        initializeComponents();
        setupLayout();
        addActionListeners();
    }

    private void initializeComponents() {
        // Text Fields
        regNoField = new JTextField(20);
        firstNameField = new JTextField(20);
        surnameField = new JTextField(20);
        ageField = new JTextField(20);
        cgpaField = new JTextField(20);
        actionField = new JTextField(20);
        
        // Text Area
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // Buttons
        createButton = new JButton("Create");
        retrieveButton = new JButton("Retrieve");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        
        // Labels
        statusLabel = new JLabel("Welcome to Student Management System");
        resultLabel = new JLabel("Result Area");
        retrieveLabel = new JLabel("Retrieved Data");
        actionLabel = new JLabel("Reg No for Update/Delete");
        
        // Styling
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        statusLabel.setFont(labelFont);
        resultLabel.setFont(labelFont);
        retrieveLabel.setFont(labelFont);
        actionLabel.setFont(labelFont);
    }

    private void setupLayout() {
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Fields
        addComponent(cp, gbc, new JLabel("Registration Number:"), 0, 0);
        addComponent(cp, gbc, regNoField, 0, 1);
        addComponent(cp, gbc, new JLabel("First Name:"), 1, 0);
        addComponent(cp, gbc, firstNameField, 1, 1);
        addComponent(cp, gbc, new JLabel("Surname:"), 2, 0);
        addComponent(cp, gbc, surnameField, 2, 1);
        addComponent(cp, gbc, new JLabel("Age:"), 3, 0);
        addComponent(cp, gbc, ageField, 3, 1);
        addComponent(cp, gbc, new JLabel("CGPA (till 4th sem):"), 4, 0);
        addComponent(cp, gbc, cgpaField, 4, 1);
        
        // Action Field
        addComponent(cp, gbc, actionLabel, 5, 0);
        addComponent(cp, gbc, actionField, 5, 1);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(createButton);
        buttonPanel.add(retrieveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        
        gbc.gridwidth = 2;
        addComponent(cp, gbc, buttonPanel, 6, 0);
        
        // Status and Result Labels
        gbc.gridwidth = 2;
        addComponent(cp, gbc, statusLabel, 7, 0);
        addComponent(cp, gbc, resultLabel, 8, 0);
        
        // Result Area
        addComponent(cp, gbc, retrieveLabel, 9, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        addComponent(cp, gbc, new JScrollPane(resultArea), 10, 0);
        
        cp.setBackground(new Color(240, 240, 240));
    }

    private void addComponent(Container container, GridBagConstraints gbc, Component component, int row, int col) {
        gbc.gridx = col;
        gbc.gridy = row;
        container.add(component, gbc);
    }

    private void addActionListeners() {
        createButton.addActionListener(e -> create());
        retrieveButton.addActionListener(e -> retrieve());
        updateButton.addActionListener(e -> update());
        deleteButton.addActionListener(e -> delete());
        clearButton.addActionListener(e -> clear());
        exitButton.addActionListener(e -> exit());
    }

    private void create() {
        try {
            int regNo = Integer.parseInt(regNoField.getText().trim());
            String firstName = firstNameField.getText().trim();
            String surname = surnameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            float cgpa = Float.parseFloat(cgpaField.getText().trim());

            if (firstName.isEmpty() || surname.isEmpty()) {
                statusLabel.setText("Please fill in all required fields");
                return;
            }

            try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(
                     "INSERT INTO result (reg_no, first_name, surname, age, cgpa) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setInt(1, regNo);
                stmt.setString(2, firstName);
                stmt.setString(3, surname);
                stmt.setInt(4, age);
                stmt.setFloat(5, cgpa);
                stmt.executeUpdate();
                statusLabel.setText("Data saved successfully");
                retrieveLabel.setText("Data created. Click Retrieve to view");
                updateResultLabel(cgpa);
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid numbers for Reg No, Age, and CGPA");
        } catch (SQLException e) {
            statusLabel.setText("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void retrieve() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM result")) {
            StringBuilder results = new StringBuilder();
            while (rs.next()) {
                results.append(String.format("%d   %s   %s   %d   %.2f%n",
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)));
            }
            resultArea.setText(results.toString());
            statusLabel.setText("Data retrieved successfully");
            retrieveLabel.setText("Retrieved Data");
        } catch (SQLException e) {
            statusLabel.setText("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void update() {
        String regNoStr = actionField.getText().trim();
        if (regNoStr.isEmpty()) {
            statusLabel.setText("Please provide Registration Number for update");
            return;
        }

        try {
            int regNo = Integer.parseInt(regNoStr);
            String firstName = firstNameField.getText().trim();
            String surname = surnameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            float cgpa = Float.parseFloat(cgpaField.getText().trim());

            try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                 PreparedStatement stmt = con.prepareStatement(
                     "UPDATE result SET first_name=?, surname=?, age=?, cgpa=? WHERE reg_no=?")) {
                stmt.setString(1, firstName);
                stmt.setString(2, surname);
                stmt.setInt(3, age);
                stmt.setFloat(4, cgpa);
                stmt.setInt(5, regNo);
                int rows = stmt.executeUpdate();
                
                if (rows > 0) {
                    statusLabel.setText("Data updated successfully");
                    retrieveLabel.setText("Data updated. Click Retrieve to view");
                    updateResultLabel(cgpa);
                } else {
                    statusLabel.setText("No record found with Registration Number: " + regNo);
                }
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter valid numbers for Reg No, Age, and CGPA");
        } catch (SQLException e) {
            statusLabel.setText("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void delete() {
        String regNoStr = actionField.getText().trim();
        if (regNoStr.isEmpty()) {
            statusLabel.setText("Please provide Registration Number for deletion");
            return;
        }

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("DELETE FROM result WHERE reg_no=?")) {
            stmt.setInt(1, Integer.parseInt(regNoStr));
            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                statusLabel.setText("Data deleted successfully");
                retrieveLabel.setText("Data deleted. Click Retrieve to view");
            } else {
                statusLabel.setText("No record found with Registration Number: " + regNoStr);
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter a valid Registration Number");
        } catch (SQLException e) {
            statusLabel.setText("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void clear() {
        regNoField.setText("");
        firstNameField.setText("");
        surnameField.setText("");
        ageField.setText("");
        cgpaField.setText("");
        actionField.setText("");
        resultArea.setText("");
        statusLabel.setText("All fields cleared");
        resultLabel.setText("Result Area");
        retrieveLabel.setText("Click Retrieve to check data");
    }

    private void exit() {
        statusLabel.setText("Exiting...");
        dispose();
    }

    private void updateResultLabel(float cgpa) {
        if (cgpa > 10 || cgpa < 0) {
            resultLabel.setText("Please enter valid CGPA (0-10)");
        } else if (cgpa > 5) {
            resultLabel.setText("Eligible for placement");
        } else {
            resultLabel.setText("Not eligible for placement");
        }
    }
}