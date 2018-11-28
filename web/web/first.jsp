<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/11/28
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个jsp</title>
</head>
<body>
<%
    Date d = new Date();
    System.out.println(d.toLocaleString());
    out.write(d.toLocaleString());
%>
<!--html 注释 页面源码可以看见-->
<%--jsp注释， 页面源码不能看见 --%>

<%!
   public void m(){
       System.out.println("This is function");
   }
%>
<%=
   "这里可以输出常量和变量，不能使用分号分割"
%>
<%--
  调用函数方法
--%>
<%
    m();
%>


</body>
</html>
