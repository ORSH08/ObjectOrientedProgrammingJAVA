public abstract class Person {

    protected String userName;
    protected String password;

    public Person(String userName) {
        this.userName = userName;
        this.password = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Username: " + userName +
                " ,Password: " + password + "\n";
    }
}