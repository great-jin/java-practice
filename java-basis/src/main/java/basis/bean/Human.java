package basis.bean;

public class Human {

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
