package bg.proxiad.crud.controllers.update;

import bg.proxiad.crud.exceptions.RecordNotFoundException;
import bg.proxiad.crud.helpers.UserHelper;
import bg.proxiad.crud.model.UserModel;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserUpdatesController {
  @Autowired UserHelper helper;

  @GetMapping(path = "/update-password")
  public ModelAndView loadUpdatePasswordPage(@ModelAttribute("userInfo") UserModel userInfo) {
    ModelAndView mv = new ModelAndView("changePassword");
    return mv;
  }

  @PostMapping(path = "/update-password")
  public ModelAndView updatePassword(
      HttpSession session, HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo)
      throws ServletException, IOException {
    ModelAndView mv = new ModelAndView("passwordUpdated");
    if (helper.checkUserInput(session, userInfo)) {
      helper.updatePassword(session, req, userInfo);
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
  public ModelAndView updateUsername(
      HttpSession session, HttpServletRequest req, @ModelAttribute("userInfo") UserModel userInfo)
      throws ServletException, IOException {
    ModelAndView mv = new ModelAndView("usernameUpdated");
    if (helper.checkUserInput(session, userInfo)) {
      helper.updateUsername(req, session, userInfo);
      return mv;
    } else {
      throw new RecordNotFoundException();
    }
  }

  @PostMapping(path = "/delete-account")
  public ModelAndView deleteAccount(
      HttpSession session, @ModelAttribute("userInfo") UserModel userInfo) throws IOException {
    ModelAndView mv = new ModelAndView("deletionComplete");
    helper.deleteUser(session);
    return mv;
  }

  @GetMapping(path = "/edit-profile")
  public String loadEditProfilePage(@ModelAttribute("userInfo") UserModel userInfo) {
    return "editProfile";
  }

  @PostMapping("/edit-profile")
  public String loadFile(
      @Validated MultipartFile uploadedFile,
      DefaultMultipartHttpServletRequest req,
      HttpSession session)
      throws IOException, ServletException {
    // uploadedFile = req.getMultipartFiles().get("filename").get(0);
    if (uploadedFile != null && !uploadedFile.isEmpty()) {
      byte[] bytes = uploadedFile.getBytes();

      byte[] encodeBase64 = Base64.encodeBase64(bytes);
      String base64Encoded = new String(encodeBase64, "UTF-8");
      session.setAttribute("uploadedFile", base64Encoded);
    }
    return "editProfile";
  }
}
