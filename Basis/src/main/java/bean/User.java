package bean;

public class User {

    private int ID;
    private String userName;

    public User() {

    }

    public User(int ID, String userName) {
        this.ID = ID;
        this.userName = userName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
