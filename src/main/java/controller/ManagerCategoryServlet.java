package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class ManagerActorServlet
 */
@WebServlet("/ManagerCategoryServlet")
public class ManagerCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryDAO cateDAO = new CategoryDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String category_id = request.getParameter("category_id");
		int menu_id = Integer.parseInt(request.getParameter("menu_id"));
		String url = "";
		try {
			switch (command) {
				case "delete":
					cateDAO.delete(Integer.parseInt(category_id));
					request.setAttribute("succced", "A Movie was deleted successfully");	
					url = "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
					break;
			}
		} catch (Exception e) {
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String name_category = request.getParameter("category_name");
		String category_id = request.getParameter("category_id");
		int menu_id = Integer.parseInt(request.getParameter("menu_id"));
		String url = "", error = "";
		if(name_category == "" || name_category == null)
		{
			error = "Category's Name is not empty";
		}
		
		try {
			if (error.length() == 0) {
				switch (command) {
				case "insert":
						if(menu_id == 1)
						{
							cateDAO.insert(new Category(cateDAO.getMaxId()+1, name_category,(byte)1));
							request.setAttribute("succced", "A category was inserted successfully");	
							url = "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
							break;
						}else if(menu_id == 2) {
							cateDAO.insert(new Category(cateDAO.getMaxId()+1, name_category,(byte)2));
							request.setAttribute("succced", "A category was inserted successfully");	
							url = "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
							break;
						}
				case "update":
					if(menu_id == 1)
					{
						cateDAO.update(new Category(Integer.parseInt(category_id), name_category, (byte)1));
						request.setAttribute("succced", "A category was updated successfully");	
						url = "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
						break;
					}else if(menu_id == 2) {
						cateDAO.update(new Category(Integer.parseInt(category_id), name_category, (byte)2));
						request.setAttribute("succced", "A category was updated successfully");	
						url = "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
						break;
					}
				}
			} else {
				request.setAttribute("error", error.toString());
				url =  "/Admin/dist/categories_Movie.jsp?menu_id=" + menu_id;
			}
		} catch (Exception e) {
		}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
	}

}
