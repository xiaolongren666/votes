package com.jiangshil.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangshil.dao.ListDao;

/**
 * Servlet implementation class ChangeSuccessServlet
 */
@WebServlet("/changeSuccessServlet")
public class ChangeSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSuccessServlet() {
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
		// 删除标题表的细腻些
		ListDao.delArticle(titleid);
		String type = request.getParameter("type");
		int tp;
		if(type.equals("dan")) {
			tp = 0;
		}else{
			tp = 1;
		}
		// 添加投票表的信息
		int id = ListDao.addTitle(title, tp);
		String[] option = request.getParameterValues("option");
		// 添加选项表的信息
		for(String string : option) {
			ListDao.addOption(string, id);
		}
		response.getWriter().println("<script language='JavaScript'>alert('修改成功');window.location.href='admin/tpList.jsp';</script>");
	}

}
