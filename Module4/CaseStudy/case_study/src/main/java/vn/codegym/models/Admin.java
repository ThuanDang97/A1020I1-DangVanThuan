package vn.codegym.models;


public class Admin {

    private String userName;
    private String PassWord;

    public Admin() {
    }

    public Admin(String userName, String passWord) {
        this.userName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    @Override
    public String toString() {
        return "admin{" +
                "userName='" + userName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }
}
