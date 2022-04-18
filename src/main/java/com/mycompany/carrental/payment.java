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
public class payment 
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
    public String dateReturn(car c)
    {
        String dd=c.getDate2();
        String mm=c.getMonth2();
        String yyyy=c.getYear2();
        String returnDate= dd + "-" + mm + "-" + yyyy;
        return returnDate;
    }
    
    public int enterReturnDate(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET returndate ='" + c.getReturnDate() + "' WHERE id = '" + id + "'";
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

    public int enterAdditionalDays(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET additionaldays ='" + c.getAddDays() + "' WHERE id = '" + id + "'";
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
            }// nothing we can do
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

    public int enterDamages(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET damages ='" + c.getDamages() + "' WHERE id = '" + id + "'";
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
            }// nothing we can do
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

    public String searchRent(String serialNo)
    {   
        Connection conn = null;
        Statement stmt = null;
        car obj= new car();
        String Rent=" ";
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM carinfo WHERE serialno = " + serialNo ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                obj.setRent(rs.getString("rent"));
                Rent=obj.getRent();
                //System.out.println(obj.getRent());
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
            }// nothing we can do
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
        return Rent;
    }    

    public String searchRentDays(String id)
    {   
        Connection conn = null;
        Statement stmt = null;
        car obj= new car();
        String RentDays=" ";
        try{
            conn = getDatabaseCnnection();
            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM customerinfo WHERE id = " + id ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                obj.setRentDays(rs.getString("rentdays"));
                RentDays=obj.getRentDays();
                //System.out.println(obj.getRentDays());
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
        return RentDays;
    }    

    public String searchAddDays(String id)
    {   
        Connection conn = null;
        Statement stmt = null;
        car obj= new car();
        String AddRentDays=" ";
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM customerinfo WHERE id = " + id ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                obj.setAddDays(rs.getString("additionaldays"));
                AddRentDays=obj.getAddDays();
                System.out.println(obj.getAddDays());
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
            try{
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
        return AddRentDays;
    }      

    public int enterBill(String id,car c)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = getDatabaseCnnection();
            //Execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql="UPDATE customerinfo SET bill ='" + c.getBill() + "' WHERE id = '" + id + "'";
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
            try{
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
}