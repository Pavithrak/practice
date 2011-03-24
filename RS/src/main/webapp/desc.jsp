<%@ page  language="java" import="com.rs.core.Job, com.rs.core.User" %>
<html>
<head>
<link rel="stylesheet" href="css/lightbox.css" type="text/css" />
<script src="script/prototype.js" type="text/javascript"></script>
<script src="script/lightbox.js" type="text/javascript"></script>
<script src="script/loginCall.js" type="text/javascript"></script>
</head>
<body>
<%
Job[] jobList = (Job[]) getServletContext().getAttribute("jobList");
int i = Integer.parseInt(request.getParameter("i"));
User user = (User) getServletContext().getAttribute("user");
String link = "Profile?id=" + jobList[i].getId();
String loginStyle="display:inline";
String applyStyle="display:none";
String name ="";
if(!(user == null)){
  name = user.getName();
  loginStyle = "display:none";
  applyStyle = "display:inline";

}

%>
<div id="welcome"><%= name %></div>
<h1> Job Description </h1>

<b>Company Name: </b> <%= jobList[i].getCompanyName() %>
<br/><b>Location: </b> <%= jobList[i].getLocation() %>
<br/><b>Experience limit: </b><%= jobList[i].getExperience() %>
<br/><b>Industry: </b> <%= jobList[i].getIndustry() %>
<br/><b>Post: </b><%= jobList[i].getFunction() %>
<br/>
<a href="result.jsp">Back to search results</a><br/>
<a href="search.jsp">Start a new search</a>
<br/>
<a href="login.jsp" class="lbOn" id="apply" style= <%= loginStyle %>>login to Apply</a>
<a href=<%=link %> id="save" style= <%= applyStyle %> >Apply</a>
</body>
</html>