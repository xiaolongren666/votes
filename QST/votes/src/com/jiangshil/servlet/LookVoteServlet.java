package com.jiangshil.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiangshil.bean.Option;
import com.jiangshil.dao.ListDao;

@WebServlet("/lookVoteServlet")
public class LookVoteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投票标题
		String title = request.getParameter("title");
		// 投票选项个数
		String optionNum = request.getParameter("optionNum");
		// 投票参与人数
		String voteNum = request.getParameter("voteNum");
		List<Option> options = new ArrayList<Option>();
		//根据投票标题，查找对应的投票ID
		int id = ListDao.findTitleId(title);
		// 根据投票ID查询投票的选项
		List<String> optionList = ListDao.findTitleOption(id);
		for(String string : optionList) {
			Option op = new Option();
			op.setOption(string);
			// 根据投票选项名称查询票数
			int num = ListDao.optionNum(string);
			op.setNum(num);
			options.add(op);
			
		}
		
		int titleNum = ListDao.titleCount(id);
		request.setAttribute("title", title);
		request.setAttribute("optionNum", optionNum);
		request.setAttribute("voteNum", voteNum);
		request.setAttribute("titleNum", titleNum);
		request.setAttribute("options", options);
		request.getRequestDispatcher("admin/cktp.jsp").forward(request, response);
		return;
	}
}
