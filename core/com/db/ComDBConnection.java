/*
 * Class 
 * @filename Connection 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 25 Aug 2017 * 
 */
package core.com.db;

import app.config.Setup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryno
 */
public class ComDBConnection {
    Connection conn = null;
    ResultSet resultSet = null;
    Statement stmt = null;
    Properties properties = new Properties();
    String dbDriver = null;
    String dbURL = null;
    String dbName = null;
    String dbUser = null;
    String dbPassword = null;
    
    //--------------------------------------------------------------------------
    public ComDBConnection(){
        this.dbDriver = Setup.DB_DRIVER;
        this.dbURL = Setup.DB_URL;
        this.dbName = Setup.DB_NAME;
        this.dbUser = Setup.DB_USER;
        this.dbPassword = Setup.DB_PASSWORD;
    }
    //--------------------------------------------------------------------------
    public Connection getConnection(){
        if(this.conn != null){ return this.conn; }
        try {
            Class.forName(this.dbDriver);
            this.conn = DriverManager.getConnection(this.dbURL+this.dbName, this.dbUser, this.dbPassword);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        
        return this.conn;
    }
    //--------------------------------------------------------------------------
    public ResultSet query(String sql){
        try {
            this.conn = this.getConnection();
            this.stmt = this.conn.createStatement();
            this.resultSet = stmt.executeQuery(sql);
            
            return this.resultSet;
        } catch (SQLException ex) {
            System.out.println("SQL: " + sql);
            System.err.println(ex.getMessage());
            System.err.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        }
        return null;
    }
    //--------------------------------------------------------------------------
    public Object statement(String sql){
		String generatedColumns[] = { "ID" };
		Object generated_id = null;
		try {
			this.conn = this.getConnection();
			PreparedStatement preparedStmt = this.conn.prepareStatement(sql, generatedColumns);
			preparedStmt.executeUpdate();
			generated_id = this.get_generated_id(preparedStmt);
			this.conn.close();
		} catch (SQLException ex) {
			System.err.println(sql);
			Logger.getLogger(ComDBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return generated_id;
    }
	//--------------------------------------------------------------------------
    public Integer get_generated_id(PreparedStatement stmt){
		try {
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}
		} catch (SQLException ex) {
			Logger.getLogger(ComDBTable.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
    }
    //--------------------------------------------------------------------------
    public void close(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
    //--------------------------------------------------------------------------
    public static void shutdown(){
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(ComDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------------------------------------------------
}
