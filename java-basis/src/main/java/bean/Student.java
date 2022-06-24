package bean;

public class Student extends Human {

    String stuId;

    public Student() {
    }

    public Student(String name, String gender) {
        super(name, gender);
    }

    public Student(String name, String gender, String stuId) {
        super(name, gender);
        this.stuId = stuId;
    }

    public void breath() {
        System.out.println("Student breath");
    }

    public void Study() {
        System.out.println("Student study");
    }
}
