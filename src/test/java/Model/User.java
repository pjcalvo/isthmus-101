package Model;

public class User {
    public String firstName;
    public String lastName;
    public String userName;
    public String password;

    public User(String firstName, String lastName, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
