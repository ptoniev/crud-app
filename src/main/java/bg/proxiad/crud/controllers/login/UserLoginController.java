package bg.proxiad.crud.controllers.login;


import bg.proxiad.crud.exceptions.RecordNotFoundException;
import bg.proxiad.crud.helpers.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserLoginController {
    //@Autowired
    UserHelper helper = new UserHelper();

    @GetMapping(path = "/")
    public ModelAndView loadLoginPage()
    {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping(path = "/")
    public ModelAndView authenticateInput(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var usersMap = helper.getUsersMap(req);
        if (helper.checkUserInput(req)) {
            ModelAndView mv = new ModelAndView("existingUser");
            // On the following row we set a uname variable into the session which we can use for
            // delete account button once a user has logged in.
            helper.getSession(req).setAttribute("uname", helper.getUserName(req));
            return mv;
        } else {
            throw new RecordNotFoundException();
       }

    }


    @GetMapping(path = "/list-of-users")
    public ModelAndView loadUsersPage(HttpServletRequest req){
        if(helper.checkUsersMap(req)){
            throw new NullPointerException();
        }
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
