<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.dropdown {
position: relative;

}

.dropdown-content {
display: none;
position: absolute;
background-color: #f9f9f9;   min-width: 200px;
box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
padding: 12px 16px;
right: 200px;
z-index: 1;
}

.dropdown-content.show {
display: block;
}

input[type="number"]{
width: 50px;
margin-right: 30px;
}
.dropdown .clickme{
display: block;
width: 100px;
margin: 0 auto;
}
</style>
</head>
<body>

<h2>Hoverable Dropdown</h2>
<span></span>

<div class="dropdown">
<p class="clickme">Mouse over me</p>
<div class="dropdown-content">
<p><input type="number" id="value1"><label for="value1">pen1</label></p>
<p><input type="text" id="value2"><label for="value2">pen2</label></p>
<p><input type="checkbox" id="value3"><label for="value3">Hello World!</label></p>
<p><input type="checkbox" id="value4"><label for="value4">Hello World!</label></p>
</div>
</div>
<!-- <script>
document.querySelector('.clickme').addEventListener('click',function(){
document.querySelector('.dropdown-content').classList.toggle('show');
});
</script> -->
</body>
</html>