<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="utility.Storage,java.util.*,utility.Product"%>
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
    padding: 2px 16px;
  box-sizing:border-box;
}
.cleafix{
content: '';
clear: both;
display: block;
}
img{
  width: 100px;
  height: 100px;
  margin: 10px;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
.display
{
float:left;
}
.add 
{
margin: 0 30px 0 0;
float:right;
}
.add p input
{
width:30px;
}
.add b
{
/*   text-align: center;
 */  margin-top:30px
}
.add button
{
  background-color: #4CAF50;
  border:none;
  padding:5px;
  border-radius:5px;
}

img{
  width: 170px;
  height: 170px;
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
.topnav a.home {
  float: right;
  background-color:#333 ;
  color: white;}

.topnav .icon {
  display: none;
}

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
  
     #btn_s{
    width: 100px;
    margin-left: auto;
    margin-right: auto;
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
else{
%>
<div class="topnav" id="myTopnav">
  <a href="#home" class="active">Cart</a>
  <a href="/backtohome" class="home">BackToHome</a>
  </div>
 <%
ArrayList<Product> list1=(ArrayList<Product>)request.getAttribute("ItemList");
Iterator itr2=list1.iterator();
while(itr2.hasNext())
{
	Product product=(Product)itr2.next();
	String name=product.getProductname();
%>


  <div class="card clearfix">
  <div class="display">
  <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/assortment-of-colorful-ripe-tropical-fruits-top-royalty-free-image-995518546-1564092355.jpg?crop=0.657xw:0.983xh;0.191xw,0&resize=640:*" alt="Avatar" >
  </div>
  
  <div class="add">
           <b><h4><%= name %></h4> </b> 
  
<p><input type="number" name="quantity" value="<%= request.getAttribute("quantity") %>"min="0" max="<%= product.getProductAvailability() %>"><label for="value1">Quantity</label></p>
<p> PRICE:<%=  product.getProductPrice() %></p>
<form action="/remove">
<input type="hidden" name="productID" value="<%=product.getProductID() %>">
<input type="submit" name="item" value="Delete">
</form>
</div>
 
</div>
  <%
 }}
  %>
  <div class="order">
  <form action="/order">
  <input type="submit"  value="Place the Order" id="btn_s">
  </form>
  </div>
  
 
</body>
</html>