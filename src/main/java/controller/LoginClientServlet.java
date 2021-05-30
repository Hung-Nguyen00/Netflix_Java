package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.AccountDAO;
import model.Account;
/**
 * Servlet implementation class ManagerAccountServlett
 */
@WebServlet("/LoginClientServlet")
public class LoginClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAO accountDAO = new AccountDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public LoginClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String email = request.getParameter("email");
		String url = "";
		try {
			switch (command) {
				case "delete":
					accountDAO.delete(email);
					url = "/Netflix_Clone/Admin/dist/account.jsp";
					break;
				case "logout":
					HttpSession session = request.getSession();
					session.invalidate();
					session.removeAttribute("email");
					url = "/Netflix_Clone/Inner-Website/login.jsp";
					break;
			}
		} catch (Exception e) {
		}
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String	phone = request.getParameter("phone");
		String expiration = request.getParameter("date");
		String url = "";
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
			if (error.length() == 0) {
				switch (command) {
				case "login":
					if(accountDAO.checkEmail(email, password)) {
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						url = "/Inner-Website/browse.jsp";
						
					} else
					{
						request.setAttribute("error", "Your email or password incorrect");	
						url = "/Inner-Website/signup.jsp";
					}
					break;
					
				}
			} else {
				request.setAttribute("error", "Your email or password are not empty");	
				url = "/Netflix_Clone/Inner-Website/login.jsp";
			}
		} catch (Exception e) {
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		 // 1. create new Update
		// 2. checkEmail() in DAO.
		// 3. get value from  request.Parameter('email')
		// 4. CheckEmail'email() is True ? update : insert.
		// 5. update: showInfo('email') -> form update;
		// 5. insert: 
	}

}
