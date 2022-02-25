package bg.proxiad.crud;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-password")
public class UpdatePassword extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected String userName;
  protected String oldPassword;
  protected String newPassword;

  HashMap<String, String> mapUsersUpdate = new HashMap<>();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher //
        = getServletContext().getRequestDispatcher("/changePassword.jsp");

    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    oldPassword = req.getParameter("oldPassword");
    newPassword = req.getParameter("newPassword");
    userName = req.getParameter("username");

    HashMap<String, String> mapUsersUpdate =
        (HashMap<String, String>) getServletContext().getAttribute("mapUsers");
    mapUsersUpdate.remove(userName, oldPassword);
    mapUsersUpdate.put(userName, newPassword);

    getServletContext().setAttribute("mapUsers", mapUsersUpdate);
    resp.getWriter()
        .format(
            "<html><body><h1>Your password was successfully changed!</h1><ul>\r\n"
                + "<li><a href=\"/\">Home Page</a></li>\r\n"
                + "</ul></body></html>");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getMethod().equals("POST")) {
      doPost(request, response);
    } else if (request.getMethod().equals("GET")) {
      doGet(request, response);
    }
  }
}
