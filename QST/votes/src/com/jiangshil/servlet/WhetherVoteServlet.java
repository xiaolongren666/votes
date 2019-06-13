package com.jiangshil.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiangshil.dao.ListDao;
import com.jiangshil.dao.UserDao;

/**
 * Servlet implementation class WhetherVoteServlet
 */
@WebServlet("/whetherVoteServlet")
public class WhetherVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WhetherVoteServlet() {
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
		String title=request.getParameter("title");
		String optionNum=request.getParameter("optionNum");
		String voteNum=request.getParameter("voteNum");
		
		int titleid=ListDao.findTitleId(title);
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		int userid=UserDao.findUserId(username);
		
		//获取该投票的所有选项。
		List<String>  slist=ListDao.findTitleOption(titleid);
		
		//获取用户已选择的选项
		List<Integer> inte=ListDao.findUserOption(titleid, userid);
		List<String>  sinte=new ArrayList<>();
		for (int i : inte) {
			sinte.add(ListDao.findOption(i));
		}
		
		for (String string : sinte) {
			System.out.println(string);
		}
		
		request.setAttribute("title", title);
		request.setAttribute("optionNum", optionNum);
		request.setAttribute("voteNum", voteNum);
		request.setAttribute("list", slist);
		request.setAttribute("sinte", sinte);
		request.getRequestDispatcher("admin/yesVote.jsp").forward(request, response);
		return;
	}
}
