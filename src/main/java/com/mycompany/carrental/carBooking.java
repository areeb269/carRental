/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AAComm
 */
public class carBooking 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/customer";
    static final String USER = "root";
    static final String PASS = "12famf34_";
    
    
    private Connection getDatabaseCnnection()
    {
        Connection conn = null;
        try{
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

    public int selectSerialNo(String id,car c)
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
            sql="UPDATE customerinfo SET serialno = '" + c.getSerialNo() + "' WHERE id = '" + id + "'";
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
            }
        }
        return 0;
    }

    public int selectCompany(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET companyselected = '" + c.getCompany() + "' WHERE id = '" + id + "'";
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
            }
        }
        return 0;
    }

    public int selectName(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET nameselected = '" + c.getCarName() + "' WHERE id = '" + id + "'";
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
            }
        }
        return 0;
    } 

    public String dateRent(car c)
    {
        String dd=c.getDate1();
        String mm=c.getMonth1();
        String yyyy=c.getYear1();
        String rentDate = dd + "-" + mm + "-" + yyyy;
        return rentDate;
    }

    public int enterRentDate(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET rentdate ='" + c.getRentDate() + "' WHERE id = '" + id + "'";
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
            }
        }
        return 0;
    }

    public int enterRentDays(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET rentdays ='" + c.getRentDays() + "' WHERE id = '" + id + "'";
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
            }
        }
        return 0;
    }

    public void searchID(String id)
    {   
        Connection conn = null;
        Statement stmt = null;
        car obj= new car();
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM carinfo WHERE serialno = " + id ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                obj.setCarName(rs.getString("carname"));
                obj.setCompany(rs.getString("carcompany"));
                System.out.println(obj.getCarName());
                System.out.println(obj.getCompany());
            }
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
            }
        }
    }
}