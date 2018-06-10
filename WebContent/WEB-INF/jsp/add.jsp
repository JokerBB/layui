<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/operater" method="post">
    <table>
        <tr>
            <th colspan="2">请输入添加学生的信息</th>
        </tr>
        <tr>
            <td>书名</td>
            <td><input type="text" name="bookName" value=""/></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="bookAuthor"  value=""/></td>
        </tr>
         <tr>
            <td>出版社</td>
            <td><input type="text" name="publisher"  value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                
                <input type="submit" value="添加"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>