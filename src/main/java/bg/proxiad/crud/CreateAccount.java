package bg.proxiad.crud;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create-account")
public class CreateAccount extends HttpServlet implements Servlet {

  protected String userName;
  protected String password;

  HashMap<String, String> mapUsers = new HashMap<>();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RequestDispatcher dispatcher //
        = getServletContext().getRequestDispatcher("/signUpPage.jsp");

    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    userName = req.getParameter("username");
    password = req.getParameter("password");
    // UsersContainer user = new UsersContainer(userName, password);

    if (mapUsers.containsKey(userName)) {
      resp.sendRedirect("errorCreation.jsp");
    } else {
      mapUsers.put(userName, password);
      getServletContext().setAttribute("mapUsers", mapUsers);
      resp.getWriter()
          .format(
              "<html><body><p>Your account was successfully created.</p><ul>\r\n"
                  + "<li><a href=\"/\">Login</a></li>\r\n"
                  + "</ul></body></html>");
    }
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
