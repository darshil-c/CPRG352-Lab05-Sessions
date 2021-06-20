package servlets;

import domain.AccountService;
import domain.User;
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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
       String logout = request.getParameter("logout");
       
       // check if the user has logged out
       if (logout != null) {
           session.invalidate();
           request.setAttribute("message", "You have logged out.");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
       
       // check if the user has an existing username in their session
       else if (session.getAttribute("username") != null) {
           response.sendRedirect("home");
       } 
       
       // if the user doesn't have a valid session or has logged out send them to loginpage
       else {
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if (!username.equals("") || !password.equals("")) {
            AccountService aServ = new AccountService();
            User user = aServ.login(username, password);
            if (user != null) {
                session.setAttribute("username", username);
                response.sendRedirect("home");
            } else {
                request.setAttribute("message", "Incorrect Username or Password.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            
        } else {
            request.setAttribute("message", "Make sure your inputs are not empty.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
