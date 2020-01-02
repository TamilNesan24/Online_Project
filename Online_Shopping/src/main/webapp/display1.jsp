<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="utility.Storage,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
margin-top: 20px;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
width: calc(100%/3);
  float: left;


}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
  padding: 2px 16px;
}
.col-3{
  width: calc(100%/3);
  background: red;
  height: 300px;
  float: left;
  border: 1px solid black;
    box-sizing: border-box;
}
img{
  width: 100px;
  height: 100px;
  margin: 10px;
}
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.topnav .icon {
  display: none;
}
.topnav a.home {
  float: right;
  background-color:#333 ;
  color: white;}


@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}
</style>
</head>
<body>

<%
if(session.getAttribute("id")==null)
{
	response.sendRedirect("index.jsp");
	}
ArrayList list=(ArrayList)request.getAttribute("productname");
Iterator itr =list.iterator();
%>

<div class="topnav" id="myTopnav">
  <a href="#home" class="active">Home</a>
  <a href="/logout" class="home">Logout</a>
  <%
while(itr.hasNext())
{
	String name=itr.next().toString();
%>
<a href="/products/<%= name %>"><%= name %></a>
<% 
}


%>
  
  </div>
<%-- <%
if(request.getAttribute("ItemList")!=null)
{
ArrayList list1=(ArrayList)request.getAttribute("ItemList");
Iterator itr2=list1.iterator();
while(itr2.hasNext())
{
%>


<div class="col-3">
  <img src="https://images.unsplash.com/photo-1575859431774-2e57ed632664?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ" alt="">
  <p><%= itr2.next() %></p>
  </div>
  <div class="card">
  <img src="img_avatar.png" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b><%= itr2.next() %></b></h4>  
  </div>
</div>
  


<%
} }
%> --%>

</body>
</html>











<!--   <span><button onclick="window.location.href = '/">Click Here</button></span>
 --> 
  <%-- <%     ArrayList name=(ArrayList)session.getAttribute("productname");
  Iterator itr=name.iterator();
  while(itr.hasNext())
  {
	  %>
	  
    <a href="<%= itr.next()%>">"<%= itr.next()%>"</a>
    
    <% }%> --%>
    