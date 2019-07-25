/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meaya
 */
import java.sql.*;
public class config {
    static Connection getconnection() throws Exception
    {
       Connection  con = null;
       con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
       return con;
        
    }
}
