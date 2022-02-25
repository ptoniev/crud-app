package bg.proxiad.crud;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list-of-users")
public class ReadUsers extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    HashMap<String, String> mapUsersList =
    //        (HashMap<String, String>) getServletContext().getAttribute("mapUsers");
    //    response.setContentType("text/html");
    RequestDispatcher rd = request.getRequestDispatcher("/listUsersJSTL.jsp");
    rd.forward(request, response);
    /*
    // With the following code we print the user names of all registered users
    PrintWriter out = response.getWriter();
    if (mapUsersList != null) {
      out.print("<h1>" + "List of registered users: " + "</h1>");
      for (String key : mapUsersList.keySet()) {
        out.println("<h1>" + key + "</h1>");
      }
    } else {
      out.print("<h1>" + "There are no registered users. " + "</h1>");
    }
    */
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }
}
