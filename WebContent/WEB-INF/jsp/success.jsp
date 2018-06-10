<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p align="center">欢迎：${currentUser.userName } 来到小丑书店</p>
<table>
<tr>
<th colspan="2">书店自助管理系统</th>
</tr>
<tr>
<td>查询书籍</td>
<td >
 <a href="${pageContext.request.contextPath}/book/read">查看</a>
</td>
</tr>


<tr>
<td>添加书籍</td>
<td>
 <a href="${pageContext.request.contextPath}/book/add">添加</a>
</td>
</tr>

</table>
</body>
</html>