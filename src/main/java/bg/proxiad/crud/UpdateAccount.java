package bg.proxiad.crud;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-username")
public class UpdateAccount extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected String oldUserName;
  protected String newUserName;
  protected String password;

  HashMap<String, String> mapUsersUpdate = new HashMap<>();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher //
        = getServletContext().getRequestDispatcher("/changeUsername.jsp");

    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    oldUserName = req.getParameter("oldUsername");
    newUserName = req.getParameter("newUsername");
    password = req.getParameter("password");

    HashMap<String, String> mapUsersUpdate =
        (HashMap<String, String>) getServletContext().getAttribute("mapUsers");
    mapUsersUpdate.remove(oldUserName, password);
    mapUsersUpdate.put(newUserName, password);

    getServletContext().setAttribute("mapUsers", mapUsersUpdate);
    resp.getWriter()
        .format(
            "<html><body><h1>Your username was successfully changed!</h1><ul>\r\n"
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
