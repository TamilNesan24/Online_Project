package utility;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import com.google.appengine.api.datastore.Entity;

public class Product implements Serializable
{
private String productname;
private String productID;
private String productPrice;
private String productAvailability;
private String productImg;
public  Product(Entity entity) 
{
	  
	this.productname=entity.getProperty("Productname").toString();
	  this.productID=entity.getProperty("ProductID").toString();
	  this.productPrice=entity.getProperty("Price").toString();
	  this.productAvailability=entity.getProperty("Availability").toString();
//	  this.productImg=entity.getProperty("ProductImg").toString();
	  
	}
public String getProductname() 
{
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductPrice() {
	return productPrice;
}
public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}
public String getProductID() {
	return productID;
}
public void setProductID(String productID) {
	this.productID = productID;
}
public String getProductAvailability() {
	return productAvailability;
}
public void setProductAvailability(String productAvailability) {
	this.productAvailability = productAvailability;
}
public String getProductImg() {
	return productImg;
}
public void setProductImg(String productImg) {
	this.productImg = productImg;
}


}
