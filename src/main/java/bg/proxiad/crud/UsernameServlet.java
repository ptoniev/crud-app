package bg.proxiad.crud;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class UsernameServlet extends HttpServlet implements Servlet {

  protected String userName;
  private String password;

  /*
   * public void init(ServletConfig servletConfig) throws ServletException {
   * servletConfig.getServletContext().setAttribute("mapUsersLogin", mapUsers); }
   */

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    userName = req.getParameter("username");
    password = req.getParameter("password");
    HashMap<String, String> mapUsersLogin =
        (HashMap<String, String>) getServletContext().getAttribute("mapUsers");
    // here we create boolean attributes to check if there is a user match or if there are no
    // matches or no existing users
    boolean checkUser =
        (mapUsersLogin.containsKey(userName) && mapUsersLogin.containsValue(password));
    if (mapUsersLogin == null || mapUsersLogin.isEmpty()) {
      resp.sendRedirect("errorLogin.jsp");
    }
    if (checkUser) {
      resp.sendRedirect("existingUser.jsp?uname=" + URLEncoder.encode(userName, "UTF-8"));
    } else {
      resp.sendRedirect("errorLogin.jsp");

    }
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getMethod().equals("POST")) {
      doPost(request, response);
    } else if (request.getMethod().equals("GET")) {
      doGet(request, response);
    }
  }
}
