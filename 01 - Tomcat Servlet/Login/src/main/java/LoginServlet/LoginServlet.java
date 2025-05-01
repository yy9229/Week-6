package LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns="/LoginServlet",
		initParams = {
				@WebInitParam(name = "user", value = "Sobhit"),
				@WebInitParam(name = "password", value = "BridgeLabz@1")
		}
)
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(!user.matches("[A-Z][a-zA-Z]{2,}$")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			out.println("<font color = red>Name must start with a capital letter and have atleast 3 characters.</font>");
			rd.include(request, response);
			return;
		}
		
		String passwordError = validatePassword(pwd);
		if(passwordError!=null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			out.println("<font color = red>" + passwordError + "</font>");
			rd.include(request, response);
			return;
		}
		
        if (userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
	}
	private String validatePassword(String pwd) {
        if (pwd.length() < 8) {
            return "Password must have at least 8 characters.";
        }
        if (!pwd.matches(".*[A-Z].*")) {
            return "Password must have at least one uppercase letter.";
        }
        if (!pwd.matches(".*\\d.*")) {
            return "Password must have at least one digit.";
        }
        String specialChars = pwd.replaceAll("[a-zA-Z0-9]", "");
        if (specialChars.length() != 1) {
            return "Password must have exactly one special character.";
        }
        return null;
    }
}