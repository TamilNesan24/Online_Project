package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import utility.Product;
import utility.Storage;
@Controller
public class ProductController 
{
	@RequestMapping("/products/{selectedName}")
	public ModelAndView availableItem(@PathVariable("selectedName")String selectedName,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		
		if((session.getAttribute("id")==null))
		{
			ModelAndView view = new ModelAndView("index");
			return view;
		}
		ArrayList<Product> ItemList = Storage.getDataList("Product","Type", selectedName);
		ArrayList<String> productNameList=Storage.getProductList();
		ModelAndView view = new ModelAndView("Product");
		view.addObject("active",selectedName);
		view.addObject("productname",productNameList);
		view.addObject("ItemList", ItemList);
	
		return view;
	}
	
	@RequestMapping(value="/addtoCart",method=RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException
	{
		
		String itemName=request.getParameter("item");
		if(session.getAttribute("cart")==null)
		{
			session.setAttribute("cart", new ArrayList<String>());
		}
		String quantity=request.getParameter("quantity");
		String productID=request.getParameter("productID");
		String userID=(String) session.getAttribute("id");
		if(!Storage.addtoCart(userID, productID, quantity))
		{
			ArrayList<String> productNameList=Storage.getProductList();
			response.getWriter().println("Already added");
			request.setAttribute("productname", productNameList);
			ModelAndView view = new ModelAndView("display1");
			return view;
		}
		else
		{
		ArrayList<Product> ItemList = Storage.displayCart(userID);
		request.setAttribute("quantity",quantity);
		request.setAttribute("ItemList",ItemList);
		ModelAndView view = new ModelAndView("Cart");
		return view;
		}
	}
	
	@RequestMapping("/remove")
	public ModelAndView removeFromCart(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		String productID=request.getParameter("productID");
		String userid=session.getAttribute("id").toString();
		Storage.removeCart(productID,userid);
		ArrayList<Product> ItemList = Storage.displayCart(userid);
		request.setAttribute("ItemList",ItemList);
		ModelAndView view = new ModelAndView("Cart");
		Integer.valueOf("12");
		return view;
	}
	
	
	@RequestMapping("/cart")
	public ModelAndView displayCart(HttpServletRequest request,HttpSession session)
	{
		String userID=session.getAttribute("id").toString();
		ArrayList<Product> ItemList = Storage.displayCart(userID);
		request.setAttribute("ItemList",ItemList);
		ModelAndView view = new ModelAndView("Cart");
		return view;
	}
	@RequestMapping("/order")
	public ModelAndView addTo()
	{
//		Storage.addToOder();
		ModelAndView view = new ModelAndView("Order");
		return view;
		
	}

}

