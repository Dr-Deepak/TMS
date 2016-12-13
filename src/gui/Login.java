/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** @author Deepak Created On Nov 30, 2016 by 5:38:17 PM */
package gui;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class Login {

    private static String userName, password;

    public static void main(String[] args) throws Exception {

        // TODO code application logic here
        JFrame frame = new JFrame("Java Database Tables");
        frame.setLayout(new BorderLayout());
        JPanel tabelPanel = new JPanel(), southPanel = new JPanel();

        southPanel.setLayout(new FlowLayout());
        //cOmponent  that will hold the selected data frpm the list
        final JLabel lblSelectedItem = new JLabel("Selected Item: ");
        final JTextField txtSelectedItem = new JTextField(15);
        //final String DB_URL = "jdbc:mysql://sql.computerstudi.es:3306/gc200327564";
        final String DB_URL = "jdbc:mysql://localhost/gc200327564";
        //create cpnnection ,statement and resultset objects
        Connection conn = null;
        DriverManager dm;
        Statement stat = null;
        ResultSet rs = null;

        //default wuery
        final String Qry = "Select * from employees";

        /**
         * Login window
         */
        // panel to hold the login information
        JPanel panel = new JPanel();
        //login components
        JLabel lblUserName = new JLabel("Enter Username"),
                lblPassword = new JLabel("Enter Password");
        JTextField txtFldUserName = new JTextField(15);
        JPasswordField txtFldPassword = new JPasswordField(15);
        panel.add(lblUserName);
        panel.add(txtFldUserName);
        panel.add(lblPassword);
        panel.add(txtFldPassword);
        int counter = 0;
        boolean dbCredCheck = false;
        //loop asking user to authenticate user
        String[] buttonOps = new String[]{"OK", "Cancel"};
        do {
            JOptionPane loginJoP = null;
            int result = loginJoP.showOptionDialog(null, panel, "Enter Login Info",
                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttonOps, buttonOps[0]);
          
          
                try {
//                Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(DB_URL, userName = txtFldUserName.getText(),
                            password = new String(txtFldPassword.getPassword()));
                    System.out.println(conn);
                    dbCredCheck = true;

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password" + "\n Please try again");

                    // reset  the loop check 
                    dbCredCheck = false;

                    // increment the counter
                    counter++;
                    if (counter > 3) {
                        JOptionPane.showMessageDialog(null, "Faliure to authenicate. "
                                + "The system will shut down");
                        System.exit(0);
                    }
                }
           
        } while (!dbCredCheck);

        if (conn != null) {
            try {
                //create a statement object
                stat = conn.createStatement();
                //create a resultset
                rs = stat.executeQuery(Qry);
                //get the metadata
                ResultSetMetaData metaData = rs.getMetaData();
                //metadata number of columns
                int colCount = metaData.getColumnCount();

                //Intitalize a table object to store data fetched from database
                final JTable table = new JTable(buildTM(rs));
                tabelPanel.add(table);
                // close connection  
                conn.close();
            } catch (SQLException e) {

            }
        }
        //Add built table to Tabele  panel

        southPanel.add(lblSelectedItem);
        southPanel.add(txtSelectedItem);

        frame.add(tabelPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
    }//end main method
    
public static void insert() {
        Statement stat = null;
        Connection conn = null;
        final String DB_URL = "jdbc:mysql://sql.computerstudi.es:3306/gc200327564";
        try 
        {   
            
            
            
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public static DefaultTableModel buildTM(ResultSet rs) throws Exception {
        //extract metada from resultset
        ResultSetMetaData metaData = rs.getMetaData();
        //create vectors for th col names
        Vector<String> colNames = new Vector<>();
        
        int columnCount = metaData.getColumnCount();
        //loop to capture column names 
        for (int column = 1; column <= columnCount; column++) {
            colNames.add(metaData.getColumnName(column));
        }
        //add data to vector of vectors
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        while (rs.next()) {
            Vector<Object> rowData = new Vector<Object>();
            
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                
                rowData.add(rs.getObject(columnIndex));
                
            }
            //addthe row vector to the outer Vector
            data.add(rowData);
        }
        return new DefaultTableModel(data, colNames);
        
    }
}//end of class
