package com.ani.ECommerceFrontend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.CartDaoImpl;
import com.ani.ECommerceBackend.daoImpl.OrderDaoImpl;
import com.ani.ECommerceBackend.daoImpl.UserDaoImpl;
import com.ani.ECommerceBackend.model.Cart;
import com.ani.ECommerceBackend.model.ShippingAddress;
import com.ani.ECommerceBackend.model.User;
import com.ani.ECommerceBackend.model.UserOrder;

@Controller
public class OrderController {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
	@Autowired
	OrderDaoImpl orderDaoImpl;
	
public OrderController() {

System.out.println("OrderController is loading");
}	

@RequestMapping("/placeOrder")
public ModelAndView placeOrder(HttpSession session)
{
	
	String userName=(String)session.getAttribute("un");
	User user=userDaoImpl.getUser(userName);

	ShippingAddress shipAdd=new ShippingAddress();
	shipAdd=user.getAddress();
	ModelAndView modelAndView=new ModelAndView("ShippingAddressSnipp");
	modelAndView.addObject("order",shipAdd);
	return modelAndView;
}

@RequestMapping(value="/placedOrder", method=RequestMethod.POST)
public ModelAndView receivePlaceOrderData(@ModelAttribute("order") ShippingAddress shipAdd,HttpSession session)
{
	//ModelAndView modelAndView=new ModelAndView("orderDetails");
	ModelAndView modelAndView=new ModelAndView("orderDetails");
	

Date date=new Date();
String userName=(String)session.getAttribute("un");
User user=userDaoImpl.getUser(userName);
List<Cart> list= cartDaoImpl.getCartList(userName);
for(Cart cart:list)
{
cart.getCartId();
cartDaoImpl.deleteCart(cart);
}

int grandTotal=0;
for(Cart cart:list)
{
	grandTotal=grandTotal+cart.getTotalPrice();
}
UserOrder userOrder=new UserOrder();
user.setAddress(shipAdd);
userOrder.setAddress(shipAdd);
userOrder.setDate(date);
userOrder.setUser(user);
userOrder.setGrandTotal(grandTotal);
//userOrder.setAddress(shipAdd);
modelAndView.addObject("userData",userOrder);
modelAndView.addObject("cartList",list);
orderDaoImpl.saveOrder(userOrder);
//userDaoImpl.addUser(user);
return modelAndView;

}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MyOrdersController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

@RequestMapping("/myOrders")
public ModelAndView getMyOrders(HttpSession session)
{
	ModelAndView modelAndView=new ModelAndView("MyOrdersPage");
	String userName=(String)session.getAttribute("un");
System.out.println("UserName :"+userName);
	List<UserOrder> list= orderDaoImpl.getMyOrders(userName);
for(UserOrder order:list)
{
	System.out.println("------------------------------------------");
	System.out.println(order.getUserOrderId());
	System.out.println(order.getDate());
	System.out.println(order.getGrandTotal());
	System.out.println(order.getUser());
	System.out.println(order.getUser().getAddress().getCity());
	System.out.println(order.getUser().getAddress().getCountry());
	System.out.println(order.getUser().getAddress().getStreetName());
	
	
}
modelAndView.addObject("orderList",list);
	return modelAndView;
}

}
