<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/jquery-1.x.js"></script>
		<script type="text/javascript" src="js/changeH.js"></script>
	</head>
	<body>
		<div class="main">
			<div class="top">
				<img src="img/logo.gif"  />
			</div>
			<div class="line1"></div>
			<div class="second">
			
			
			<form action="articleListServlet?flag=search"  method="post" target="mainframe">
				<table class="table1">
					<tr>
						<td width="220px">您好，${sessionScope.username}</td>
						<td width="220px"><a href="exitServlet">注销</a></td>
						<td width="260px"><img src="img/new.gif" /> <a href="admin/tpList.jsp"  onclick="hi();"  target="mainframe">返回列表</a></td>
						<td width="280px"><img src="img/addnew.gif" /> <a href="admin/addNewtp.jsp" target="mainframe">添加新投票</a></td>
						<c:if test="${sessionScope.username=='jiangshil'}">
							<td width="280px"><img src="img/edit.gif" /> <a href="articleListServlet?del=d" onclick="hi();" target="mainframe">维护</a><input type="hidden"  name="hi" id="hi" value="0"></td>
						</c:if>
						<td width="150px"><input name="search"  type="text" style="margin-bottom: 4px;"/></td>
						<td width="50px"><input type="submit" value=""  style="width:40px; height:23px;border:0;background:url(img/button_search.gif);" /></td>
						
					</tr>
				</table>
				</form>
				

			</div>
			
			<div class="mid">
				
				<iframe src="admin/tpList.jsp" width="900" id="win" name="mainframe"  onload="Javascript:SetWinHeight(this)" frameborder="0" scrolling="no" /></iframe>
					
			</div>
			
			<div class="line2"></div>
			<div class="end">
				青软实训 &copy; 版权所有
			</div>
			
		</div>	
	</body>
</html>