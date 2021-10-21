<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/17
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <form action="${pageContext.request.contextPath}/registerUser"  method="post">
        <table style="width:350px; margin: 50px auto;" border=1>
            <tr>
                <td>
                    UserName:
                </td>
                <td>
                    <input type="text" name="username"  />
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type="password" name="password"  />
                </td>
            </tr>
            <tr>
                <input type="submit" value="注册" />
            </tr>
        </table>
    </form>
</body>
</html>
