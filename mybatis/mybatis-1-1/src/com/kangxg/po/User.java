package com.kangxg.po;

import java.util.List;

public class User {
    private Integer id;
    private String  username;
    private String  address;
    private List<Orders> ordersList;   //体现 一对多关系

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public List<Orders> getOrders()
    {
        return this.ordersList;
    }

    public void setOrders(List<Orders> ordersList)
    {
        this.ordersList = ordersList;
    }

    @Override
    public String toString()
    {
        return "User [id =" + id +"," +"username =" +username +", address =" +address +", ordersList =" +ordersList +"]";
    }
}
