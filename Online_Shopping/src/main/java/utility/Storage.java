package utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Storage  implements Serializable
{
	
	
	
//	static public boolean addToOrder()
//	{
//		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//	     Entity item = new Entity("Cart");   //(String, Key);
//	     item.setProperty("UserId", userId);
//	     item.setProperty("ProductID", productID);
//	     item.setProperty("Quantity",quantity);
//		return false;
//	}
//	public static boolean()
//	{
//	
//	
//		}
	
	
	public static String getUserID(String email,String password)
	{
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Query query = new Query("LoginDetail").addFilter("Email", FilterOperator.EQUAL, email);
			PreparedQuery pq = datastore.prepare(query);
			Storage.getProductList();
			Entity display = pq.asSingleEntity();
			if(!(display==null))
			{ 
				if(display.getProperty("password").toString().equals(password))
	           {
					String id=display.getProperty("UserID").toString().trim();
				return id;
				}
			}	
				return null;
	}
	static public boolean addtoCart(String userId,String productID,String quantity )
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	     Entity item = new Entity("Cart");   //(String, Key);
	     item.setProperty("UserId", userId);
	     item.setProperty("ProductID", productID);
	     item.setProperty("Quantity",quantity);
	     if(!(item.toString().isEmpty()))
	     {
	    	 datastore.put(item);
	    	 return true;
	     }
	    	 return false;
	}
	
	
	
	static public ArrayList<Product> displayCart(String userId)
	{
		ArrayList <Product>productList=new ArrayList<Product>();
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 Query query = new Query("Cart").addFilter("UserId", FilterOperator.EQUAL, userId);
			PreparedQuery preparequery = datastore.prepare(query);
			Iterator <Entity> product = preparequery.asIterator();
			while(product.hasNext())
			{
				String productid=(String)product.next().getProperty("ProductID");
				 Query cartquery = new Query("Product").addSort("ProductID");
				 PreparedQuery pq = datastore.prepare(cartquery);
				 Iterator <Entity>itr = pq.asIterator();
				 while(itr.hasNext())
				 {
					 Entity ent=itr.next();
					 String proid=ent.getProperty("ProductID").toString();
					 if(proid.equals(productid))
					 {
						 Product pro=new Product(ent);
//						 System.out.println(pro.getProductname());
						 productList.add(pro);
				 } 
				 }
			}
		return productList;
	}
	
	public static void removeCart(String ProductID,String userId)
	{
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 Query query = new Query("Cart").addFilter("UserId", FilterOperator.EQUAL, userId);
			PreparedQuery preparequery = datastore.prepare(query);
			Iterator <Entity> product = preparequery.asIterator();
			while(product.hasNext())
			{
				
				Entity entry=product.next();
				String id=entry.getProperty("ProductID").toString();
				System.out.println(ProductID.equals(id)+"  remove");
				if(ProductID.equals(id))
				{
					datastore.delete(entry.getKey());
					
				}
				
				}
		
	}
	
	
	
	static public ArrayList getProductList()
	{
		ArrayList productList=new ArrayList();
		String name=new String();
		
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 Query query = new Query("Product").addSort("Type");
		PreparedQuery pq = datastore.prepare(query);
		Iterator <Entity> productname = pq.asIterator();
		while(productname.hasNext())
		{
			name=productname.next().getProperty("Type").toString();
			if(!productList.contains(name))
			productList.add(name);
		}
		
//		System.out.print("here"+productList);
		
		return productList;
	}

	static public ArrayList<Product> getDataList(String table,String property,String item)
	{
		ArrayList <Product>productList=new ArrayList<Product>();
		String name=new String();
		
		 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		 Query query = new Query(table).addFilter(property, FilterOperator.EQUAL, item);
		 PreparedQuery preparequery = datastore.prepare(query);
		 if(property.equals("ProductID"))
		 {
			Entity entity=preparequery.asSingleEntity();
			productList.add(new Product(entity));
			System.out.println(productList.isEmpty());
			return productList;
		 }
		
		Iterator <Entity> productname = preparequery.asIterator();
		while(productname.hasNext())
		{
			Entity entry=productname.next();
				productList.add(new Product(entry));
				
		}
		
//		System.out.print("here"+productList);
		
		return productList;
	}
	
	
	
	static public boolean getSingleEnitity(String Productname,String ID,String Type,String Availability,String Price) 
	{
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Entity product = new Entity("Product",Productname);//(String, Key);
	product.setProperty("Productname", Productname);
	product.setProperty("ProductID", ID);
	product.setProperty("Type",Type);
	product.setProperty("Availability",Availability);
	product.setProperty("Price",Price);
	product.setProperty("Offers",null);
	Query query = new Query("Product").
    addFilter("Productname", FilterOperator.EQUAL,Productname);
        	PreparedQuery preparequery = datastore.prepare(query);
    		Entity display = preparequery.asSingleEntity();
    		
    		 if(display==null)
    	       { 
    	    	   datastore.put(product);
    	    	   return true;
    	        }
    		return false;
	}
	
	
	
	static public boolean addNewUser(String name,String password,String email,String phonenumber,String address)
	{
		Random random = new Random();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	     Entity customer = new Entity("LoginDetail",email);//(String, Key);
	     String result=new String();
	        customer.setProperty("name", name);
	        customer.setProperty("password", password);
	        customer.setProperty("Email",email);
	        customer.setProperty("Phonenumber",phonenumber);
	        customer.setProperty("Address",address);
	        customer.setProperty("UserID",(1000+random.nextInt(100)));
	        	Query query = new Query("LoginDetail").
	        			addFilter("Email", FilterOperator.EQUAL,email);
	        	PreparedQuery preparequery = datastore.prepare(query);
	    		Entity display = preparequery.asSingleEntity();
	    		if(display==null)
	    	       { 
	    	    	   datastore.put(customer);
	    	           return true;
	    	        }
		return false;
	}

}
	
	
	
	

	
	
	









//Key key = KeyFactory.createKey("Product",80);
//Entity product = new Entity("Product","Hero Pen");//(String, Key);
//String result=new String();
//product.setProperty("Productname", "Hero Pen");
//product.setProperty("ProductID", pID+600);
//product.setProperty("Type","Stationary");
//product.setProperty("Availability","10");
//product.setProperty("Price","200");
//product.setProperty("Offers",null);
//datastore.put(product);

