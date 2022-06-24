package basis.constrct.extend;

import bean.Human;
import bean.Student;

public class ExtendTest {

    public static void main(String[] args) {
        Human human = new Human("Alex", "Male");
        human.breath();

        Student student = new Student("Beth", "Female", "123");
        student.breath();
        student.Study();
    }
}
