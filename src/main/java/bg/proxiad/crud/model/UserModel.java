package bg.proxiad.crud.model;


import javax.validation.constraints.Size;

public class UserModel {
    @Size(min=3, message="User name field must consist of at least 3 letters.")
    String uName;
    @Size(min=3, message="Password field must consist of at least 3 letters.")
    String pass;

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    String newUsername;
    String newPassword;

    public UserModel()
    {
        System.out.println("Constructor called.");
    }
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
