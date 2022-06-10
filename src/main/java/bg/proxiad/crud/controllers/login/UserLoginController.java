package bg.proxiad.crud.controllers.login;

import bg.proxiad.crud.exceptions.RecordNotFoundException;
import bg.proxiad.crud.helpers.UserHelper;
import bg.proxiad.crud.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserLoginController {
  @Autowired UserHelper helper;

  @GetMapping(path = "/")
  public String loadLoginPage(@ModelAttribute("userInfo") UserModel userInfo) {
    return "index";
  }

  @PostMapping(path = "/")
  public String authenticateInput(
      @Valid @ModelAttribute("userInfo") UserModel userInfo, BindingResult br, HttpSession session)
      throws IOException {
    if (br.hasErrors()) {
      return "index";
    }
    if (helper.checkUserInput(session, userInfo)) {
      // On the next row we set this attribute so it can be used for delete account function
      session.setAttribute("usName", userInfo.getuName());
      return "existingUser";
    } else {
      throw new RecordNotFoundException();
    }
  }

  @GetMapping(path = "/list-of-users")
  public String loadUsersPage(@ModelAttribute("userInfo") UserModel userInfo, HttpSession session) {
    if (helper.checkUsersMap(session)) {
      throw new NullPointerException();
    }
    return "listUsersJSTL";
  }

  @GetMapping(path = "/create-account")
  public String getSignUpPage(@ModelAttribute("userInfo") UserModel userInfo) {
    return "signUpPage";
  }

  @PostMapping(path = "/create-account")
  public String createAccount(
      @Valid @ModelAttribute("userInfo") UserModel userInfo, BindingResult br, HttpSession session)
      throws IOException {
    var userMap = helper.getUserMap(session);

    if (br.hasErrors()) {
      return "signUpPage";
    }

    if (userMap.containsKey(userInfo.getuName())) {
      return "errorCreation";
    } else {
      helper.registerUser(userInfo, session);
      return "successfulCreation";
    }
  }
}
