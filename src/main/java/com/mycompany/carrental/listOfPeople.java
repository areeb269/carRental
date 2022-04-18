/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrental;

/**
 *
 * @author AAComm
 */
public class listOfPeople
{
    private String userID,userName,userAddress,userNumber,serialNo,rentDate,returnDate,rentDays,addDays,totalBill;
    public listOfPeople(String userID,String userName,String userAddress,String userNumber
            ,String serialNo,String rentDate,String returnDate,String rentDays,String addDays,String totalBill)
    {
        this.userID=userID;
        this.userName=userName;
        this.userNumber=userNumber;
        this.userAddress=userAddress;
        this.serialNo=serialNo;
        this.rentDate=rentDate;
        this.returnDate=returnDate;
        this.rentDays=rentDays;
        this.addDays=addDays;
        this.totalBill=totalBill;
    }

    public String getID()
    {
        return userID;
    }
    public String getName()
    {
        return userName;
    }
    public String getAddress()
    {
        return userAddress;
    }
    public String getNumber()
    {
        return userNumber;
    }
    public String getSerialNo()
    {
        return serialNo;
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
    public String getTotalBill()
    {
        return totalBill;
    }   
}