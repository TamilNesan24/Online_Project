<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="utility.Storage,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
 <style>
.button {
  background-color: #4CAF50; //#ADD8E6
  border: none;
  color: white;
  padding: 15px 32px;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button1 {
  background-color: #6699FF;
  border: none;
  color: white;
  padding: 15px 32px;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.container {
    width: 406px;
    max-width: 406px;
    margin: 0 auto;
}
.sep {
    height: 0.5px;
    background: #e8e8e8;
    width: 406px;
    margin: 0px -25px;
}

.inputs {
    margin-top: 25px;
}
.inputs input[type=text], input[type=password] ,input[type=text]{
    background: #f5f5f5;
    font-size: 0.8rem;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    padding: 13px 10px;
    width: 330px;
    margin-bottom: 20px;
    box-shadow: inset 0px 2px 3px rgba( 0,0,0,0.1 );
    clear: both;
}
.header
{
color: #0000A0;
    
}
body {
background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwkutm4xhqyZHO0i-mEuP_TpejLkTtGuspAcNpilwBGS3R44vS&s');
background-repeat: no-repeat;
background-size: cover;
}
</style>
</head>
<body>
<% 
 if(session.getAttribute("id")==null)
{
	response.sendRedirect("index.jsp");
	}
else{
%>

<div class="container">

    <form action="/admin" method="post">

        <div class="header">
        
            <h3>ADMIN PAGE</h3>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
            Product Name:<br>
            <input type="text" placeholder="Productname" name="Productname"/>
        <br>
        <br>
           ID:<br>
            <input type="password" placeholder="ProductID"  name="ID"/>
            <br>
            <br>
            <% 
    ArrayList list=(ArrayList)request.getAttribute("productname");
    Iterator itr =list.iterator();
    %> 
    
    
Type:<input type="text" name="Type" list="cityname">
    <datalist id="cityname">  
    <%
while(itr.hasNext())
{
	String name=itr.next().toString();
%>
<option value="<%= name %>">
<% 
}
}
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

%>
    </datalist>
            
        
        Availability:<br>
            <input type="text" placeholder="Availability" name="Availability"/>
        <br>
        <br>
        Price:<br>
            <input type="text" placeholder="Price" name="Price"/>
        <br>
        <br>
            <input type="submit"  class="button" value="ADD PRODUCT">
              </form>   
                   </div>
           
</body>
</html>