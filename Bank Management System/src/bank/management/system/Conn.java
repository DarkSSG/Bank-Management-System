package bank.management.system;

import java.sql.*;

// step 1: register the driver
// step 2: create connection
// step 3: create statement
// step 4: execute query
// step 5: close connection

public class Conn {
    
    // create connection
    Connection c;
    Statement s;

    public Conn() {
        try {
            // register the driver
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "9433114116sS");
            s = c.createStatement();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
