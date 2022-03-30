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
    public HttpSession getSession(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        return session;
    }
    public Map<String, String> getUserMap(HttpServletRequest req) {
        getSession(req).setAttribute("userMap", userMap);
        return userMap;
    }

    public boolean checkUserInput(HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo){
        Map<String, String> existingUsersMap = getUserMap(req);
        boolean checkUser = (existingUsersMap.containsKey(userInfo.getuName()) && existingUsersMap.containsValue(userInfo.getPass()));
        return checkUser;
    }

    public boolean checkUsersMap(HttpServletRequest req)
    {
        Map<String, String> allUsers = (Map<String, String>) getSession(req).getAttribute("userMap");
        boolean checkUsers = (userMap == null || userMap.isEmpty());
        return checkUsers;
    }
    public void updatePassword(HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo)
    {
        String newPassword;
        newPassword = req.getParameter("newPassword");
        Map<String, String> mapUsersUpdate =
                (Map<String, String>) getUserMap(req);
        mapUsersUpdate.remove(userInfo.getuName(), userInfo.getPass());
        mapUsersUpdate.put(userInfo.getuName(), newPassword);
        getSession(req).setAttribute("userMap", mapUsersUpdate);
    }

    public void updateUsername(HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo)
    {
        String newUserName;
        newUserName = req.getParameter("newUsername");
        Map<String, String> mapUsersUpdate =
                (Map<String, String>) getUserMap(req);
        mapUsersUpdate.remove(userInfo.getuName(), userInfo.getPass());
        mapUsersUpdate.put(newUserName, userInfo.getPass());
        getSession(req).setAttribute("userMap", mapUsersUpdate);
    }

    public void deleteUser(HttpServletRequest req)
    {
        String query = (String) getSession(req).getAttribute("usName");
        Map<String, String> mapUsersDelete =
                (Map<String, String>) getUserMap(req);
        mapUsersDelete.remove(query);
        getSession(req).setAttribute("userMap", mapUsersDelete);

    }

}
