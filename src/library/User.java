package library;

public class User {
    private String name;
    private String password;
    private int accessLevel; //0 is typical borrower, 1 is admin

    public User(){

    }

    public User(String name, String password, int accessLevel){
        this.name = name;
        this.password = name;
        this.accessLevel = accessLevel;
    }

    public static User login(){
        return new User("a","b",0);
    }

    public String hash(User user){

        return "";
    }

    public boolean comparePassword(){

        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
