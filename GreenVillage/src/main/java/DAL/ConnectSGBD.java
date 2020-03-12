/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 80010-58-17
 */
public class ConnectSGBD {
    
        public Connection GetConnect() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/fil_rouge?serverTimezone=UTC";
        Connection con = DriverManager.getConnection(url, "root", "");
        return con;
    }

}
