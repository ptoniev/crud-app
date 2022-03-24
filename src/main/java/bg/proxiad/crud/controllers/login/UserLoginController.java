package bg.proxiad.crud.controllers.login;


import bg.proxiad.crud.helpers.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserLoginController {

    UserHelper helper = new UserHelper();

    @GetMapping(path = "/")
    public ModelAndView loadLoginPage()
    {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping(path = "/")
    public ModelAndView authenticateInput(HttpServletRequest req, HttpServletResponse resp){
        ModelAndView mv = new ModelAndView();
        var usersMap = helper.getUsersMap(req);
        if (usersMap == null || usersMap.isEmpty()) {
            mv.setViewName("errorLogin");
            return mv;
        }

        if (helper.checkUserInfo(req)) {
            // uname is later used for the option of deleting a user after a successful login
            helper.getSession(req).setAttribute("uname", helper.getUserName(req));
            mv.setViewName("existingUser");
            return mv;
        } else {
            mv.setViewName("errorLogin");
            return mv;
        }
    }

    @GetMapping(path = "/list-of-users")
    public ModelAndView loadUsersPage(){
        ModelAndView mv = new ModelAndView("listUsersJSTL");
        return mv;
    }

    @GetMapping(path = "/create-account")
    public ModelAndView getSignUpPage()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signUpPage");
        return mv;
    }

    @PostMapping(path = "/create-account")
    public ModelAndView createAccount(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ModelAndView mv = new ModelAndView();
        var usersMap = helper.getUsersMap(req);

        if (usersMap.containsKey(helper.getUserName(req))) {
            mv.setViewName("errorCreation");
            return mv;
        } else {
            usersMap.put(helper.getUserName(req), helper.getPassword(req));
            helper.getSession(req).setAttribute("usersMap", usersMap);
            mv.setViewName("successfulCreation");
            return mv;
        }

    }
}
