package com.kangxg.po;

public class Orders {
    private Integer id;
    private String  number;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "Orders [id =" + id +"," +"number =" +number  +"]";
    }
}
