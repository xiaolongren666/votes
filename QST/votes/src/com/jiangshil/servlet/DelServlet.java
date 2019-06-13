package com.jiangshil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangshil.dao.ListDao;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
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
		// 删除投票表的信息
		ListDao.delVote(titleid);
		// 删除选项表的信息
		ListDao.delOption(titleid);
		// 删除标题表的信息
		ListDao.delArticle(titleid);
		response.sendRedirect("admin/tpList.jsp");
	}

}
