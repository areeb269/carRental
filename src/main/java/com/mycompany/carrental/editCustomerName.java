/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AAComm
 */
public class editCustomerName extends editCustomerInfo
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/customer";
    static final String USER = "root";
    static final String PASS = "12famf34_";
    
    private Connection getDatabaseCnnection()
    {
        Connection conn = null;
        try
        {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //Open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }
        catch(Exception e)
        {
           //Handle errors for Class.forName
           e.printStackTrace();
           return null;
        }
        return conn;
    }
    public int editInfo(String id,person p)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET name = '" + p.getName() + "' WHERE id = '" + id + "'";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)
                stmt.close();
            }
            catch(SQLException se2)
            {
            }
            try
            {
                if(conn!=null)
                conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
        return 0;
    }
}