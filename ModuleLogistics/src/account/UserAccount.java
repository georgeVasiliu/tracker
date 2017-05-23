package account;

/**
 * Created by george on 5/22/17.
 */
public class UserAccount {

    private String userName;
    private char[] userPassword;
    private int userAccountType;


    public UserAccount(String userName, char[] userPassword, int userAccountType) {
        this.userAccountType = userAccountType;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getUserPassword() {
        return userPassword;
    }

    public int getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(int userAccountType) {
        this.userAccountType = userAccountType;
    }
}
