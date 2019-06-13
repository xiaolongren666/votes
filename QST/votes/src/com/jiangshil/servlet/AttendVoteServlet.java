package com.jiangshil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiangshil.dao.ListDao;
import com.jiangshil.dao.UserDao;

@WebServlet("/attendVoteServlet")
public class AttendVoteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String types = request.getParameter("type");
		if(types==null || types.equals("")) {
			//获取当前投票数据，并跳转到投票页面
			String title = request.getParameter("title");
			String optionNum = request.getParameter("optionNum");
			String voteNum = request.getParameter("voteNum");
			int id = ListDao.findTitleId(title);
			List<String> optionList = ListDao.findTitleOption(id);
			int type = ListDao.findTitleType(id);
			request.setAttribute("title", title);
			request.setAttribute("optionNum", optionNum);
			request.setAttribute("voteNum",voteNum);
			request.setAttribute("type", type);
			request.setAttribute("optionList", optionList);
			request.getRequestDispatcher("admin/cytp.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("username");
			int userId = UserDao.findUserId(name);
			String title = request.getParameter("title");
			int titleId = ListDao.findTitleId(title);
			String type = request.getParameter("type");
			if(type.equals("0")) {
				String option = request.getParameter("radio");
				int optionid = ListDao.findOptionId(option);
				ListDao.addvote(titleId, optionid, userId);
				
			}else {
				String option[] = request.getParameterValues("chbox");
				for(String string : option) {
					System.out.println(string);
					int optionid = ListDao.findOptionId(string);
					ListDao.addvote(titleId, optionid, userId);
					
				}
			}
			
			response.getWriter().print("<script language='JavaScript'>alert('投票成功');window.location.href='admin/tpList.jsp';</script>");
		}
	}
	

}
