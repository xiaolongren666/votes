package com.jiangshil.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangshil.dao.ListDao;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/changeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int titleid = ListDao.findTitleId(title);
		List<String> optionList = ListDao.findTitleOption(titleid);
		List<String> yList = new ArrayList<>();
		for (int i = 0; i < optionList.size(); i++) {
			yList.add(optionList.get(i));
		}
		request.setAttribute("title", title);
		request.setAttribute("list", optionList);
		request.setAttribute("ylist", yList);
		request.getRequestDispatcher("admin/change.jsp").forward(request, response);
	}
}
