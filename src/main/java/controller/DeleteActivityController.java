package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.ActivitiHistoryMovie;
import DAO.Activity_HistoryDAO;


@WebServlet("/DeleteActivity")
public class DeleteActivityController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Activity_HistoryDAO dao = new Activity_HistoryDAO();
    public DeleteActivityController() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		request.setCharacterEncoding("utf-8");
    		response.setCharacterEncoding("utf-8");
    		HttpSession session = request.getSession();
        	int account_id=Integer.parseInt(request.getParameter("account_id"));
        	int movie_id=Integer.parseInt(request.getParameter("movie_id"));
        	try {
				dao.deleteActivity(account_id, movie_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        }
    }