package basis.character.extend;

public class ExtendTest {

    public static void main(String[] args) {
        Human human = new Human("Alex", "Male");
        human.breath();

        Student student = new Student("Beth", "Female", "123");
        student.breath();
        student.Study();
    }
}

class Human {

    String name;
    String gender;

    public Human() {
    }

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void breath() {
        System.out.println("human breath");
    }
}


class Student extends Human {

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
