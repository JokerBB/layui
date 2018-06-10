<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
进行更新
<form action="${pageContext.request.contextPath}/book/save" method="post">
    <table>
        <tr>
            <th colspan="2">书本修改</th>
        </tr>
        <tr>
            <td>书本id</td>
            <td><input type="text" name="id" value="${book.id}"/></td>
        </tr>
         <tr>
            <td>书本名字</td>
            <td><input type="text" name="bookName" value="${book.bookName}"/></td>
        </tr>
         <tr>
            <td>作家</td>
            <td><input type="text" name="bookAuthor" value="${book.bookAuthor}"/></td>
        </tr>
         <tr>
            <td>作家</td>
            <td><input type="text" name="publisher" value="${book.publisher}"/></td>
        </tr>
        
        <tr>
            <td colspan="2">
               
                <input type="submit" value="确认修改"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>