package main.model.pojo;

/**
 * Created by admin on 21.04.2017.
 */
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private boolean admin;
    private boolean isBlocked;


    public User(long id, String firstName, String lastName, String login, String password, boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
