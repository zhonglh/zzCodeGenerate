<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Exception!</title>
</head>
<body>
<%  ((Exception)request.getAttribute("ex")).printStackTrace(); %>
<%--<% Exception e = (Exception)request.getAttribute("ex"); %>
<H2>错误异常: <%= ((Exception)request.getAttribute("ex")).getClass().getSimpleName()%></H2>
<hr />
<P>错误描述：</P>
<%= ((Exception)request.getAttribute("ex")).getMessage()%>
<P>错误信息：</P>
<% ((Exception)request.getAttribute("ex")).printStackTrace(new java.io.PrintWriter(out)); %>--%>
</body>
</html>