package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chaudhari
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // session object
       HttpSession session = request.getSession();
       
       // check if username exists in the session
       if (session.getAttribute("username") != null) {
           // if it does send the user to the homepage
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
       } else {
           // else redirect them to login
           response.sendRedirect("login");
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // no post request in home page
    }

}
