package com.ani.ECommerceFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.ShippingAddressDaoImpl;
import com.ani.ECommerceBackend.daoImpl.UserDaoImpl;
import com.ani.ECommerceBackend.model.ShippingAddress;
import com.ani.ECommerceBackend.model.User;


@Controller
public class LoginRegisterController {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	ShippingAddressDaoImpl shipDaoImpl;
	public LoginRegisterController() {
	System.out.println("LoginRegisterController is loading");
	}

	@RequestMapping("/register")
	public ModelAndView getRegister()
	{
		//ModelAndView modelAndView=new ModelAndView("userRegister");
		//ModelAndView modelAndView=new ModelAndView("userRegister");
		ModelAndView modelAndView=new ModelAndView("userRegister");
		modelAndView.addObject("reg",new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/addregdata",method=RequestMethod.POST)
	public String AddUserData(@ModelAttribute("reg") User user)
	{
		ShippingAddress address=new ShippingAddress();
		address.setDoorNumber(user.getAddress().getDoorNumber());
		address.setStreetName(user.getAddress().getStreetName());
		address.setCity(user.getAddress().getCity());
		address.setState(user.getAddress().getState());
		address.setCountry(user.getAddress().getCountry());
		address.setZipcode(user.getAddress().getZipcode());
		//shipDaoImpl.addShipAddress(address);
		userDaoImpl.addUser(user);
       
	return "userHomePage";	
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LoginController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@RequestMapping("/login")
public ModelAndView goToLoginForm()
{
		ModelAndView modelAndView=new ModelAndView("LoginSnipp");
		User user=new User();
		modelAndView.addObject("login",user);
		return modelAndView;
}
	@RequestMapping(value="/gologin",method=RequestMethod.POST)
	public ModelAndView recieveLoginDetails(@ModelAttribute("login") User user)
	{
System.out.println("from login " +user);		
		boolean b=userDaoImpl.checkLogin(user);
				if(b==true)
				{
					ModelAndView modelAndView=new ModelAndView("LoginSuccesful");
					return modelAndView; 
				}
				else
				{
					ModelAndView modelAndView=new ModelAndView("LoginSnipp");
					modelAndView.addObject("WrongUser","wrongusername/password");
					return modelAndView;
				}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~afterloginsuccesful~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
	@RequestMapping("/loginError")
	public ModelAndView loginError()
	{
		ModelAndView modelAndView=new ModelAndView("LoginSnipp");
modelAndView.addObject("login",new User());
modelAndView.addObject("loginerror","invalid username/password");
		return modelAndView;
	}
	
	@RequestMapping("/afterLoginSuccess")
	public String afterLoginSuccess(HttpSession session)
	{
		
		String pageName="";
		System.out.println("in controller after login success");
	SecurityContext securityContext=SecurityContextHolder.getContext();
	Authentication authentication=securityContext.getAuthentication();
	
	String userId=authentication.getName();
	session.setAttribute("un",userId);
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@Name@@@@@@@@@@@@@@@@@@@@@"+userId);
Collection<GrantedAuthority> grantedAuthorities=	(Collection<GrantedAuthority>)authentication.getAuthorities();
	for (GrantedAuthority grantedAuthority : grantedAuthorities) {
		System.out.println(grantedAuthorities);
		String authority=grantedAuthority.getAuthority();
	if(authority.equals("ROLE_USER"))
	{
		pageName="userHomePage";
	}
	else if(authority.equals("ROLE_ADMIN"))
	{
		pageName="homePage";
	} 
	
	}
	return pageName;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LogoutController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/*@RequestMapping("/logout")
	public String logout()
	{
		return "userHomePage";
	}*/
	

}
