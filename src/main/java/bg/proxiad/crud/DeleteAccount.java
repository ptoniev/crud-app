package bg.proxiad.crud;

import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-account")
public class DeleteAccount extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected String userName;
  protected String password;
  /*
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  } */

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String query = request.getParameter("uname");
    System.out.println("uname is" + request.getParameter("uname"));
    HashMap<String, String> mapUsersDelete =
        (HashMap<String, String>) getServletContext().getAttribute("mapUsers");
    mapUsersDelete.remove(query);

    getServletContext().setAttribute("mapUsers", mapUsersDelete);
    response
        .getWriter()
        .format(
            "<html><body><h1>Account deletion complete.</h1><ul>\r\n"
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
