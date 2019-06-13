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

import com.jiangshil.bean.Listing;
import com.jiangshil.dao.ListDao;
import com.jiangshil.dao.UserDao;

/**
 * Servlet implementation class ArticleListServlet
 */
@WebServlet("/articleListServlet")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
       
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
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		String hi=request.getParameter("hi");
		if(hi!=null&&hi.equals("1")){
			//如果hi等于1，列表则显示为维护状态
			request.setAttribute("del", "d");
		}
		
		
		int userid = UserDao.findUserId(username);
		String del=request.getParameter("del");
		if(del!=null&&del.equals("d")){
			
			request.setAttribute("del", del);
		}

//		页数
		int goPage=1;
		int count=ListDao.artlcleCount();
		int pageCount;
		if (count%5!=0){
			pageCount = count/5+1;}
		else{
			pageCount = count/5;}
		
		
		String pagestr=request.getParameter("goPage");
		if(pagestr!=null&&!pagestr.equals("")){
			goPage=Integer.parseInt(pagestr);
		}
		
		if(goPage==0){
			goPage=1;
		}
		if(goPage>pageCount){
			goPage=pageCount;
		}
		request.setAttribute("goPage", goPage);
		
		
		if (flag == null || flag.equals("")) {
			

			List<Listing> list = new ArrayList<>();
			list = ListDao.viewList(null,(goPage-1)*5,5);
			for (Listing listing : list) {
				int titleid = ListDao.findTitleId(listing.getTitle());
				boolean isvote = UserDao.userIfVote(titleid, userid);
				listing.setIsVote(isvote);
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/tpList.jsp").forward(request, response);
		} else if (flag.equals("search")) {
			//搜索框模糊查询
			
			String title = request.getParameter("search");
			List<Listing> list = new ArrayList<>();
			list = ListDao.viewList(title,(goPage-1)*5,5);
			for (Listing listing : list) {
				int titleid = ListDao.findTitleId(listing.getTitle());
				boolean isvote = UserDao.userIfVote(titleid, userid);
				listing.setIsVote(isvote);
			}

			if (list.size() == 0) {
				//如果没搜索到。
				request.setAttribute("flag", 1);
				request.getRequestDispatcher("admin/tpList.jsp").forward(request, response);
			} else {
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/tpList.jsp").forward(request, response);
			}

		} else if (flag.equals("add")) {
			//新增投票。
			String title = request.getParameter("title");
			boolean is=ListDao.isReleaseVote(title);
			if(is){
				response.getWriter().print(
						"<script language='JavaScript'>alert('该投票已被发不过，添加失败');window.location.href='admin/tpList.jsp';</script>");
			}
			else{
				String type = request.getParameter("type");
				int tp;
				if (type.equals("dan")) {
					tp = 0;
				} else {
					tp = 1;
				}
				//添加投票表的信息。
				int id = ListDao.addTitle(title, tp);

				String[] option = request.getParameterValues("option");
				
				//添加选项表的信息。
				for (String string : option) {
					ListDao.addOption(string, id);
				}
				response.getWriter().print(
						"<script language='JavaScript'>alert('添加成功');window.location.href='admin/tpList.jsp';</script>");
			}
			
		}
	}

}
