package com.kangxg.po;

public class Person {
    private Integer  id;
    private String  name;
    private Integer  age;
    private String  sex;
    private IdCard   card;   // 体现 一对一关系
    public Integer getId()
    {
        return this.id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getAge()
    {
        return this.age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSex()
    {
        return this.sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public IdCard getCard()
    {
        return this.card;
    }
    public void setCard(IdCard card)
    {
        this.card = card;
    }
    @Override
    public String toString(){
        return "Customer [id =" + id +"," +"name =" +name +", age =" +age +", sex =" +sex +", card =" +card +"]";
    }
}

