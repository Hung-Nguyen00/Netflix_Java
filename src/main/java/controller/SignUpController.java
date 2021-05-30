package controller;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Account;
import DAO.AccountDAO;
 
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	AccountDAO accountDAO = new AccountDAO();
 
    public SignUpController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		StringBuilder error = new StringBuilder(); 
		if(email == "" || email == null)
		{
			error.append("Email is not empty </br>");	
		}
		if(password == "" || password == null)
		{
			error.append("Password is not empty");	
		}
		
		try {
			if(error.length() == 0) {
				if(accountDAO.checkEmail(email, password)) {
					request.setAttribute("error", "Your email or password incorrect");	
					String url = "/Inner-Website/signup.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
					rd.forward(request, response);
				}else
					{
						System.out.println(accountDAO.signUpAccount(email, password));
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						response.sendRedirect("/Netflix_Clone/Inner-Website/browse.jsp");
					}
			}else {
				request.setAttribute("error", "Your email or password are no empty");	
				String url = "/Inner-Website/signup.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
    }


