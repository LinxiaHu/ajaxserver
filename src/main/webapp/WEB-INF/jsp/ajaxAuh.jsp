<%@ page import="java.util.List" %>
<%@ page import="com.hd.pojo.Person" %>
<%@ page  isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>测试</title>
    <script type="text/javascript" src="js/jquery-1.6.1.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $("#submit").click(function () {
                var usernameObj = $("#username");
                var username = usernameObj.val();
                //alert(username);
                var divObj = $("#result");

                $.ajax({
                    type: "POST",
                    url: "indexcontroller",
                    data: {"username": username},
                    success: function (data) {
//                        alert(data);
                        divObj.html("<h2>" + data + "</h2>");
                    }
                });


            });


        });

    </script>


</head>
<body>


请输入用户名:<input type="text" id="username"/>
<input type="button" value="校验" id="submit"/><br/>

<div id="result">

</div>

<form method="post" action="logincontroller">

    请输入密码：<input name="password" type="password"/>
    <input value="提交" type="submit"/>

</form>

<%

    String t1 = "测试字符串1";
//    System.out.println( "测试字符串1" + t1);
    out.println(t1 + "<br>");
    StringBuffer url = request.getRequestURL();
//    System.out.println("请求的地址是：" + url.toString());
    out.println("请求的地址是：" + url.toString() + "<br>");
    List<Person> p = (List<Person>) request.getAttribute("p");
    if (p != null) {
        out.println("服务器端返回的列表是：" + p + "<br>");
    }

%>

<table border="3">
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>用户年龄</th>
    </tr>
    <c:forEach var="u" items="${p}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
        </tr>
    </c:forEach>
</table>

<c:forEach var="i" begin="1" end="5">
  Item <c:out value="${i}"/><br>
</c:forEach>


</body>
</html>
