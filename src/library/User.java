package library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    protected String username; //unique
    protected String password;

    public User(String username, String password, int accessLevel){
        this.username = username;
        this.password = password;

    }

    public static User login(){
        System.out.println("Please enter your username:\n----> ");
        String username = basicUtil.getInput();
        System.out.println("And your password:\n----> ");
        String password = basicUtil.getInput();

        return new User(username, hash(password),0);
    }

    public static String hash(String password){
        String hashedPassword = "";
        //credit to 'howtodoinjava.com' for this method (but I did make sure I understood what was happening)
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update(password.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashedPassword = sb.toString();

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return hashedPassword;
    }

    public boolean comparePassword(User user){
        
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
