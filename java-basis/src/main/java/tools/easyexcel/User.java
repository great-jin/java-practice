package tools.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.util.Date;

public class User {

    @ExcelProperty(value = "编号", order = 1)
    private String Id;

    @ExcelProperty(value = "姓名", order = 2)
    private String name;

    @ExcelProperty(value = "性别", order = 3)
    private String gender;

    @ExcelProperty(value = "住址", order = 5)
    // 忽略字段
    @ExcelIgnore
    private String address;

    @ExcelProperty(value = "生日", order = 4)
    // 时间格式化
    @DateTimeFormat("yyy-MM-dd")
    private Date birthday;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String id, String name, String gender, String address, Date birthday) {
        Id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }
}
