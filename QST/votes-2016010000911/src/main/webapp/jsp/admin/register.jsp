<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getSchema() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<題page language=" java" contentType-"text/html; charset-UTF-8"
pageEncoding-"UTF-8"〉
sICOCTYPE html PUELIC " //N3C/DTD HTML 4.01 Transitional//EN" "http: //ww .w3 -org/TR/ htm14/1cosc .dtd"ゝくntmi>thead>
tmeta htt9- equiv="Content - Type" content= "text/htm1; charset=UTF -g"ゝ<besc href-*<%-r cquest. gstContextPath( )%>/"ystitlex/title>
klink rel-"stvlesheet" href-"css/reg.css" />
<cript type- "text/javascript" src-js/jquery-i .x. js x/scriptゞ<script type= -textrjavascrpt >
function checknane() {
var: name-document , eetElementById "username ) .value;
$- gct("AjaxRcgistcrScrvlct ["uscr namc" : mamc], function(data)[
var msg-document. gett lementbyla "msg" );msg. innerHM -data;msg- value-data;

);
functdon check){
var pmsg-document. getElementById "pmsg" );if Crasswnrd value !=paccwnrd1 -value){
pmsg. inncr密砕不- 玖" ;return false;
}else if(password. value-="" I lpassword.value--null)
pmsg- innerHTM =密砺*空";relurt false;
}else if(msg. value ="用戸名可以使用){
return false;

</script></headsKbodyt
<div class="main">
<div class="top"》
kimg src-img/l1ogo-gif" !><jd1v2
<div class-"line1"x/div><div clas s=" second" >/div><div class-"third"ゝ
<aiv class= need">新用广注册</aiv>
<form action-"regi sterServ1et" nethod="post" onsubmit="returr check();"〉
くtableゝ



<tr>
<td>EPz: </td>
<tdxinput type=" text" id="username" name="username" class=" aa" onblur= " checkname()" /X/td><tdXspan id="msg" X/spanX/td></tr><tr>

<td>ZiB: </td>
<td><input type="password" name= . password" class=" aa" id= " password" /X/ td></tr><tr;

<td>HaiAEB </td>
<td><input type="password" name= . password1" class="aa" id= " passwordl"/X/td><td align="left" Xspan id="pmsg" X/spanX/td></tr><tr>

<tdX/td>
td align="left">
<input type=" submit" value="" style= "width:120px; he ight : 30px; border:0;background :url(img/button_ register . gif);"/X/td>
</tr></table></form></div>
<div class=" line2"X/div><div class="end">
FXill &copy; JEtXFF</div></div></body></ntml>

</body>
</html>