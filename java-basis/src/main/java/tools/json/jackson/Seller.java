package tools.json.jackson;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

// 设置忽略字段列表
@JsonIgnoreProperties({"address"})
// 设置字段出现顺序
@JsonPropertyOrder({"Id", "name", "gender", "birthday", "address",})
public class Seller {

    /**
     * 字段出现顺序
     */
    @JsonProperty(index = 1)
    private String Id;

    private String name;

    /**
     * 将属性映射为另一名称
     * <p>
     * 只要有一个属性设置别名未设置字段在转化时将被忽略
     */
    @JsonProperty("sex")
    private String gender;

    /**
     * 格式化时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 忽略属性
     */
    @JsonIgnore
    private String address;

    public Seller() {
    }

    public Seller(String id, String name, String gender, Date birthday, String address) {
        this.Id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
