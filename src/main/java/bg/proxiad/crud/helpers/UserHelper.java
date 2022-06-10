package bg.proxiad.crud.helpers;

import bg.proxiad.crud.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Component
public class UserHelper {

  Map<String, String> userMap = new TreeMap<>();

  public Map<String, String> getUserMap(HttpSession session) {
    session.setAttribute("userMap", userMap);
    return userMap;
  }

  public boolean checkUserInput(
      HttpSession session, @ModelAttribute("userInfo") UserModel userInfo) {
    Map<String, String> existingUsersMap = getUserMap(session);
    boolean checkUser =
        (existingUsersMap.containsKey(userInfo.getuName())
            && existingUsersMap.containsValue(userInfo.getPass()));
    return checkUser;
  }

  public boolean checkUsersMap(HttpSession session) {
    Map<String, String> allUsers = (Map<String, String>) session.getAttribute("userMap");
    boolean checkUsers = (userMap == null || userMap.isEmpty());
    return checkUsers;
  }

  public void updatePassword(
      HttpSession session, HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo) {
    String newPassword;
    newPassword = req.getParameter("newPassword");
    Map<String, String> mapUsersUpdate = (Map<String, String>) getUserMap(session);
    mapUsersUpdate.remove(userInfo.getuName(), userInfo.getPass());
    mapUsersUpdate.put(userInfo.getuName(), newPassword);
    session.setAttribute("userMap", mapUsersUpdate);
  }

  public void updateUsername(
      HttpServletRequest req, HttpSession session, @ModelAttribute("userInfo") UserModel userInfo) {
    String newUserName;
    newUserName = req.getParameter("newUsername");
    Map<String, String> mapUsersUpdate = (Map<String, String>) getUserMap(session);
    mapUsersUpdate.remove(userInfo.getuName(), userInfo.getPass());
    mapUsersUpdate.put(newUserName, userInfo.getPass());
    session.setAttribute("userMap", mapUsersUpdate);
  }

  public void deleteUser(HttpSession session) {
    String query = (String) session.getAttribute("usName");
    Map<String, String> mapUsersDelete = (Map<String, String>) getUserMap(session);
    mapUsersDelete.remove(query);
    session.setAttribute("userMap", mapUsersDelete);
  }

  public void registerUser(@ModelAttribute("userInfo") UserModel userInfo, HttpSession session) {
    userMap.put(userInfo.getuName(), userInfo.getPass());
    session.setAttribute("userMap", userMap);
  }
}
