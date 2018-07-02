<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form method="post" action="<c:url value="/user"/>">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input name="username" type="text"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
