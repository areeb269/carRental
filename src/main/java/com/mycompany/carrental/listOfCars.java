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
public class listOfCars
{
    private String SerialNo,Company,CarName,Model,Hp,Capacity,Rent;
    public listOfCars(String SerialNo,String Company,String CarName,String Model,String Hp,String Capacity,String Rent)
    {
        this.SerialNo=SerialNo;
        this.Company=Company;
        this.CarName=CarName;
        this.Model=Model;
        this.Hp=Hp;
        this.Capacity=Capacity;
        this.Rent=Rent;                
    }

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
}