<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
  <style>
.button {
  background-color:#4CAF50; //#ADD8E6
  border: none;
  color: white;
  padding: 15px 32px;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button1 {
  background-color: #ADD8E6;
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
.inputs input[type=text], input[type=password] {
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
body {
background-image: url('https://image.freepik.com/free-photo/black-friday-concept-with-cart-space_23-2147709970.jpg');
background-repeat: no-repeat;
background-size: cover;
}
</style>
  </head>
  <div class="container">

    <form action="/signup" method="post">

        <div class="header">
        
            <h3>SIGN UP</h3>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
            Username:<br>
            <input type="text" placeholder="username" name="name"/>
        <br>
        <br>
            Password:<br>
            <input type="password" placeholder="Password"  name="password"/>
            <br>
            <br>
            Email Address:<br>
            <input type="text" placeholder="Email Address"  name="email"/>
            <br>
            <br>
            PhoneNumber:<br>
            <input type="text" placeholder="PhoneNumber"  name="phonenumber"/>
            <br>
            <br>
            Address:<br>
            <input type="text" placeholder="Address"  name="address"/>
            <br>
            <br>
            
            <input type="submit"  class="button" value="Create">
            </div>
            </form>
</div>
  </body>
</html>