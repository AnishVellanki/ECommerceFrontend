package com.ani.ECommerceFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.CartDaoImpl;
import com.ani.ECommerceBackend.daoImpl.ProductDaoImpl;
import com.ani.ECommerceBackend.model.Cart;
import com.ani.ECommerceBackend.model.Product;

@Controller
public class CartController {
	 
	@Autowired
	CartDaoImpl cartDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~AddToCart~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	@RequestMapping("/addToCart")
	public String cartProDetails(HttpServletRequest request,HttpSession session)
	    {
	Product product=productDaoImpl.getProduct(Integer.parseInt(request.getParameter("proId"))) ;
	int quantity=Integer.parseInt(request.getParameter("qty"));
	System.out.println("@@@@@@@@@@@@@@"+quantity);
	String userName=(String)session.getAttribute("un");
	cartDaoImpl.saveCart(product, quantity,userName);
	return "userHomePage";
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ShowCartController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	@RequestMapping("/cart")
	public ModelAndView recieveProductsData(HttpSession session)
	{
	
			String userName=(String)session.getAttribute("un");
			List<Cart> list=cartDaoImpl.getCartList(userName);
			ModelAndView modelAndView=new ModelAndView("checkoutSnipp");
			modelAndView.addObject("cartList",list);
		return modelAndView;
	}
	
	/*@RequestMapping("/cart")
	public ModelAndView recieveProductsData()
	{
			List<Cart> list=cartDaoImpl.getCartList();
			ModelAndView modelAndView=new ModelAndView("userViewCart");
			modelAndView.addObject("cartList",list);
		return modelAndView;
	}*/

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DeleteCartController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@RequestMapping("/delCart")
	public String deleteProductData(@RequestParam("cartId") int cartId)
	{

		Cart cart= cartDaoImpl.getCart(cartId);
		cartDaoImpl.deleteCart(cart);
		
		return "redirect:cart";
		
	}
}