package bg.proxiad.crud.helpers;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Component
public class UserHelper {
protected String userName;
protected String password;
Map<String, String> usersMap = new TreeMap<>();

public Map<String, String> getUsersMap(HttpServletRequest req){
    getSession(req).setAttribute("usersMap", usersMap);
    return usersMap;
}

public String getUserName(HttpServletRequest req)
{
    userName = req.getParameter("username");
    return userName;
}

public String getPassword(HttpServletRequest req){
    password = req.getParameter("password");
    return password;
}

public HttpSession getSession(HttpServletRequest req)
{
    HttpSession session = req.getSession();
    return session;
}

public boolean checkUserInfo(HttpServletRequest req){
    Map<String, String> existingUsersMap = (Map<String, String>) getSession(req).getAttribute("usersMap");
   boolean checkUser = (existingUsersMap.containsKey(getUserName(req)) && existingUsersMap.containsValue(getPassword(req)));
   return checkUser;
}

    public void updatePassword(HttpServletRequest req)
    {
        String newPassword;
        newPassword = req.getParameter("newPassword");
        Map<String, String> mapUsersUpdate =
                (Map<String, String>) getSession(req).getAttribute("usersMap");
            mapUsersUpdate.remove(getUserName(req), getPassword(req));
            mapUsersUpdate.put(getUserName(req), newPassword);
            getSession(req).setAttribute("usersMap", mapUsersUpdate);
        }

    public void updateUsername(HttpServletRequest req)
    {
        String newUserName;
        newUserName = req.getParameter("newUsername");
        Map<String, String> mapUsersUpdate =
                (Map<String, String>) getSession(req).getAttribute("usersMap");
        mapUsersUpdate.remove(getUserName(req), getPassword(req));
        mapUsersUpdate.put(newUserName, getPassword(req));
        getSession(req).setAttribute("usersMap", mapUsersUpdate);
    }

    public void deleteUser(HttpServletRequest req)
    {
        String query = (String) getSession(req).getAttribute("uname");
        Map<String, String> mapUsersDelete =
                (Map<String, String>) getSession(req).getAttribute("usersMap");
        mapUsersDelete.remove(query);
        getSession(req).setAttribute("usersMap", mapUsersDelete);

    }
}
