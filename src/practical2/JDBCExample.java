/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical2;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bredan
 */
public class JDBCExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> numList = new ArrayList<>();
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/users","Bredan", "Bredan"); 
        // replace your user name with <user> and your password with <passwd> 
        } catch (SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
//                try {
//                Scanner scanner = new Scanner(new File("./src/grades.txt"));
//            
//                int x = 0;
//            
//                while (scanner.hasNextLine()) {
//                    x += 1;
//                    statement = con.createStatement();
//                    statement.executeUpdate("Insert into Grades VALUES('Student_" + x +"','" + scanner.nextLine() +" ')");
//                }
//                
//                scanner.close();
//                
//                } catch (FileNotFoundException exe) {
//                    exe.printStackTrace();
//        
//            }
//        statement = con.createStatement();
//        resultSet = statement.executeQuery("SELECT Mark FROM Grades" );
    
        statement = con.createStatement();
        resultSet = statement.executeQuery("SELECT MARK FROM Grades");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        
//        statement = con.createStatement();
//        resultSet = statement.executeQuery("SELECT * FROM Grades" );
//        ResultSetMetaData metaData =  resultSet.getMetaData();
//        int numberOfColumns = metaData.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++)   
            // prints the column name
            System.out.print(metaData.getColumnName(i)+"\t");     
        System.out.println();
        
        Integer x = 0;
        
        // print out the results
        while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++)
                x = resultSet.getInt(i);
                numList.add(x);
        }
        
        
        
        resultSet.close();
        statement.close(); 		
        con.close();                                     
        }
        catch (SQLException s){
            System.out.println("SQL statement is not executed!");
            s.printStackTrace();
        }
    }
}
