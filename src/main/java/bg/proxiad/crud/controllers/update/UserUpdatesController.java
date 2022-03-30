package bg.proxiad.crud.controllers.update;

import bg.proxiad.crud.exceptions.RecordNotFoundException;
import bg.proxiad.crud.helpers.UserHelper;
import bg.proxiad.crud.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UserUpdatesController {
    @Autowired
    UserHelper helper;

    @GetMapping(path = "/update-password")
    public ModelAndView loadUpdatePasswordPage(@ModelAttribute("userInfo") UserModel userInfo) {
        ModelAndView mv = new ModelAndView("changePassword");
        return mv;
    }

    @PostMapping(path = "/update-password")
    public ModelAndView updatePassword(HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo )
            throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("passwordUpdated");
        if(helper.checkUserInput(req, userInfo)) {
            helper.updatePassword(req, userInfo);
            return mv;
        } else {
            throw new RecordNotFoundException();
        }
    }



    @GetMapping(path = "/update-username")
    public ModelAndView loadUpdateUsernamePage(@ModelAttribute("userInfo") UserModel userInfo) {
        ModelAndView mv = new ModelAndView("changeUsername");
        return mv;
    }

    @PostMapping(path = "/update-username")
    public ModelAndView updateUsername(HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo)
            throws ServletException, IOException {
        ModelAndView mv = new ModelAndView("usernameUpdated");
        if(helper.checkUserInput(req, userInfo)) {
            helper.updateUsername(req, userInfo);
            return mv;
        } else {
            throw new RecordNotFoundException();
        }

    }

    @PostMapping(path = "/delete-account")
    public ModelAndView deleteAccount(HttpServletRequest request, @ModelAttribute("userInfo") UserModel userInfo)
            throws  IOException {
        ModelAndView mv = new ModelAndView("deletionComplete");
        helper.deleteUser(request);
        return mv;
    }
}
