<%@ page  language="java" import="com.rs.core.Job, com.rs.core.User" %>
<html>
<head></head>
<body>
<h3>The following error occured while processing your request<br/>
<%=
request.getAttribute("message")
%>
</h3>
</body>
</html>