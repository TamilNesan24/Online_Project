package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.apphosting.api.DatastorePb.Query.Filter;

import utility.Storage;

@Controller
public class LoginController 
{
	 int customerid =5000;
	 int productid =1000;

	 @RequestMapping(value="/backtohome")
	 public ModelAndView Home(HttpServletRequest request)
	 {
		
			ArrayList<String> productNameList=Storage.getProductList();
			request.setAttribute("productname",productNameList);
			ModelAndView view = new ModelAndView("display1");
		 return view;

	 }
	 
	 @RequestMapping(value="/logout")
	 public void logout(HttpSession session, HttpServletResponse response) throws IOException
	 {
		
		 session.invalidate();
		 response.sendRedirect("index.jsp");

	 }
	


	@RequestMapping(value="/login")
	public ModelAndView Validation (String email,String password,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, ServletException
	{
		
		//------------ ADMIN---------------------------//
		if(email.equals("admin")&&password.equals("1234"))
		{
			ArrayList<String> productName=Storage.getProductList();
			session.setAttribute("id","admin");
			request.setAttribute("productname",productName);
			ModelAndView view=new ModelAndView("Admin");
			return view;
			
		}
		String id=Storage.getUserID(email,password);
		if(id!=null) 
		{
			session.setAttribute("id",id);			
			ArrayList productName=Storage.getProductList();
				request.setAttribute("productname",productName);
		ModelAndView view=new ModelAndView("display1");
		return view;
		}
		else {
			response.getWriter().println("<h1>Wrong User name OR Password</h1>");
			response.getWriter().flush();
			ModelAndView view=new ModelAndView("index");
	return view;
		}
	}


@RequestMapping(value="/signup",method=RequestMethod.POST )
public ModelAndView addUser(String name,String password,String email,String phonenumber,String address,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws EntityNotFoundException, IOException
{
	 
    		if(Storage.addNewUser(name, password, email, phonenumber, address)) 
    		{
    			response.getWriter().println("<h1>User Added</h1>");
    			ModelAndView view=new ModelAndView();
    		    view.setViewName("index");
    		    return view;
    		}
    		else
    		{
       response.getWriter().println("<h1>Email Already Exist</h1>");
		ModelAndView view=new ModelAndView();
	    view.setViewName("Signup");			
return view;
    		}
}

@RequestMapping(value="/admin",method=RequestMethod.POST )
public ModelAndView addProduct(String Productname,String ID,String Type,String Availability,String Price,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws EntityNotFoundException, IOException
{
	
    		 if(Storage.getSingleEnitity(Productname, ID, Type, Availability, Price))
    		 {
    			ModelAndView view=new ModelAndView();
    		    view.setViewName("index");
    		    return view;
    		 }
    		 else
    		 {
       response.getWriter().println("<h1>Product Updated</h1>");
       ArrayList productName=Storage.getProductList();
	   request.setAttribute("productname",productName);
		ModelAndView view=new ModelAndView();
		view.setViewName("index");			
return view;
}
    		 
    		 
}








//@RequestMapping("/login/{productname}")
//public ModelAndView availableItem(@PathVariable()String productname,HttpServletRequest request)
//{
//	ArrayList ItemList=Storage.getDataList("Product", "Type", productname);
//	request.setAttribute("ItemList",ItemList);
//	ModelAndView view=new ModelAndView();
//	view.addObject("ItemList",ItemList);
//	view.setViewName("home.jsp");
//return view;		
//}
//
















//	----------          fetching from the datastore       --------------\
	
//	System.out.println("display");
//    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//	Query q = new Query("user_old").addFilter("name", FilterOperator.EQUAL, name);
//	PreparedQuery pq = datastore.prepare(q);
//	Entity pquser = pq.asSingleEntity();
//	System.out.println(pquser);
//	return "validdated";
//	



//------------------------- Using Key Check-----------------//

//// Some time later (for example, after using personKeyStr in a link).
//Key personKey = KeyFactory.stringToKey(email);
//Entity person = datastore.get(personKey);

}