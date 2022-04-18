package com.kangxg.po;

public class IdCard {
    private Integer id;
    private String code;

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
    @Override
    public String toString()
    {
        return "Customer [id =" + id +"," +"code =" +code  +"]";
    }
}

