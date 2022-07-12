package json;

import java.util.Date;

public class Teacher {

    private int id;

    private String name;

    private String gender;

    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Teacher() {
    }

    public Teacher(int id, String name, String gender, Date birth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                '}';
    }
}
