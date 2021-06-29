package model;

public class User implements Comparable<User>{
    protected int userID;
    protected String name;
    protected String email;
    protected String country;

    public User() {}

    public User(String name, String email, String country) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(int userID, String name, String email, String country) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.getName());
    }
}
