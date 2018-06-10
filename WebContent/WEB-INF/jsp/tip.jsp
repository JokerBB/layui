<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/book/return" method="post">
    <table>
        <tr>
            <th colspan="2" >操作成功</th>
        </tr>
        <tr>
            <td colspan="2">
         
                <input type="submit" value="返回管理界面"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>