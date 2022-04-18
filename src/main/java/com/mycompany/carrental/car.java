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
public class car 
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
            //Create a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC driver
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
    protected String Company,CarName, SerialNo,Model,Hp,Capacity,Rent;
    protected String date1,month1,year1,date2,month2,year2;
    String rentDate,returnDate,rentDays,addDays,damages,bill;
//Set Functions
    public void setSerialNo(String a)
    {
        SerialNo=a;
    }
    public void setCompany(String a)
    {
        Company=a;
    }
    public void setCarName(String a)
    {
        CarName=a;
    }
    public void setModel(String a)
    {
        Model=a;
    }
    public void setHp(String a)
    {
        Hp=a;
    }
    public void setCapacity(String a)
    {
        Capacity=a;
    }
    public void setRent(String a)
    {
        Rent=a;
    }
    public void setRentDate(String a)
    {
        rentDate=a;
    }
    public void setReturnDate(String a)
    {
        returnDate=a;
    }
    public void setRentDays(String a)
    {
        rentDays=a;
    }
    public void setAddDays(String a)
    {
        addDays=a;
    }
    public void setDamages(String a)
    {
        damages=a;
    }
    public void setBill(String a)
    {
        bill=a;
    }
    public void setDate1(String a)
    {
        date1=a;
    }
    public void setDate2(String a)
    {
        date2=a;
    }
    public void setMonth1(String a)
    {
        month1=a;
    }
    public void setMonth2(String a)
    {
        month2=a;
    }
    public void setYear1(String a)
    {
        year1=a;
    }
    public void setYear2(String a)
    {
        year2=a;
    }
//Get Functions   
    public String getSerialNo()
    {
        return SerialNo;
    }
    public String getCompany()
    {
        return Company;
    }
    public String getCarName()
    {
        return CarName;
    }
    public String getModel()
    {
        return Model;
    }
    public String getHp()
    {
        return Hp;
    }
    public String getCapacity()
    {
        return Capacity;
    }
    public String getRent()
    {
        return Rent;
    }
    public String getDamages()
    {
        return damages;
    }
    public String getBill()
    {
        return bill;
    }
    public String getDate1()
    {
        return date1;
    }
    public String getDate2()
    {
        return date2;
    }
    public String getMonth1()
    {
        return month1;
    }
    public String getMonth2()
    {
        return month2;
    }
    public String getYear1()
    {
        return year1;
    }
    public String getYear2()
    {
        return year2;
    }
    public String getRentDate()
    {
        return rentDate;
    }
    public String getReturnDate()
    {
        return returnDate;
    }
    public String getRentDays()
    {
        return rentDays;
    }
    public String getAddDays()
    {
        return addDays;
    }
    public int enterData(car c)
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
            sql = "INSERT INTO carinfo VALUES('" + c.getSerialNo() + "','" + c.getCompany() + "','" + c.getCarName() + "','" + c.getModel() + "','" + c.getHp() + "','" + c.getCapacity() + "','" +c.getRent() + "')";                
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
}