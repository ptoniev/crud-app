package bg.proxiad.crud.controllers.login;


import bg.proxiad.crud.exceptions.RecordNotFoundException;
import bg.proxiad.crud.helpers.UserHelper;
import bg.proxiad.crud.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class UserLoginController {
    @Autowired
    UserHelper helper;

    @GetMapping(path = "/")
    public ModelAndView loadLoginPage(@ModelAttribute("userInfo") UserModel userInfo)
    {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @PostMapping(path = "/")
    public ModelAndView authenticateInput(@ModelAttribute("userInfo") UserModel userInfo, HttpServletRequest req) throws IOException {
        var usersMap = helper.getUserMap(req);
        if (helper.checkUserInput(req, userInfo)) {
            ModelAndView mv = new ModelAndView("existingUser");
            // On the following row we set a uname variable into the session which we can use for
            // delete account button once a user has logged in.

            helper.getSession(req).setAttribute("usName", userInfo.getuName());
            return mv;
        } else {
            throw new RecordNotFoundException();
        }

    }

    @GetMapping(path = "/list-of-users")
    public ModelAndView loadUsersPage(@ModelAttribute("userInfo") UserModel userInfo, HttpServletRequest req){
        if(helper.checkUsersMap(req)){
            throw new NullPointerException();
        }
        ModelAndView mv = new ModelAndView("listUsersJSTL");
        return mv;
    }

    @GetMapping(path = "/create-account")
    public ModelAndView getSignUpPage(@ModelAttribute("userInfo") UserModel userInfo)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signUpPage");
        return mv;
    }

    @PostMapping(path = "/create-account")
    public ModelAndView createAccount(@Valid @ModelAttribute("userInfo") UserModel userInfo, BindingResult br, HttpServletRequest req)
            throws IOException {
        ModelAndView mv = new ModelAndView();
        var userMap = helper.getUserMap(req);
        if(br.hasErrors()) {
            mv.addObject(userInfo).toString();
            mv.setViewName("signUpPage");
            return mv;
        } else {

            if (userMap.containsKey(userInfo.getuName())) {
                mv.setViewName("errorCreation");
                return mv;
            } else {
                System.out.println("User name is:" + userInfo.getuName());
                System.out.println("Pass is: " + userInfo.getPass());

                userMap.put(userInfo.getuName(), userInfo.getPass());
                helper.getSession(req).setAttribute("userMap", userMap);
                System.out.println("Watch map print: " + helper.getUserMap(req).get(userInfo.getuName()));
                mv.setViewName("successfulCreation");
                return mv;
            }
        }
    }
}
