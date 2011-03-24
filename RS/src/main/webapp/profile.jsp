<%@ page  language="java" import="com.rs.core.Job, com.rs.core.User" %>
<html>
<head>
</head>
<body>
<%
Job[] jobsApplied = (Job[]) request.getAttribute("appliedJobs");
User user = (User) getServletContext().getAttribute("user");
%>
<div id="welcome">Welcome <%= user.getName() %></div>
<h3>List of jobs applied</h3>
<table border="1">
<tr>
<th>Company Name</th>
<th>Location</th>
<th>Required Experience</th>
<th>Industry</th>
<th>Function</th>
</tr>
<%
for(Job j : jobsApplied){
%>
<tr>
<td><%=j.getCompanyName()%></td>
<td><%=j.getLocation()%></td>
<td><%=j.getExperience()%></td>
<td><%=j.getIndustry()%></td>
<td><%=j.getFunction()%></td>
</tr>
<% }
%>
</table>
<a href="result.jsp">Back to results</a><br/>
<a href="search.jsp">New Search</a>
</body>
</html>