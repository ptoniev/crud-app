package bg.proxiad.crud;

public class UsersContainer {
  String username;
  String password;

  public UsersContainer(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String uname) {
    this.username = uname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String pass) {
    this.password = pass;
  }
}
