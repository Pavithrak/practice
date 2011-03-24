<%@ page  language="java" import="com.rs.core.Job" %>
<html>
<head>
</head>
<body>
<h1>Results</h1>
<%
Job[] jobList = (Job[]) getServletContext().getAttribute("jobList");
for(int i=0;i < jobList.length; i++){
%>
<a href=<%= new String("desc.jsp?i="+i) %> >
<%=jobList[i].getCompanyName()%> </a><br/>
<% }
%>
</body>
</html>