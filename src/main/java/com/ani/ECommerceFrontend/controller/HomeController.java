package com.ani.ECommerceFrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;

@Controller
public class HomeController {
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
public HomeController() {
System.out.println("HomeController is loading");	// TODO Auto-generated constructor stub
}
	
	@RequestMapping("/home")
	public String homePage()
	{
		return "homePage";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~UserHomePageController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	@RequestMapping("/userHomePage")
	public String userHomePage(HttpSession session)
	{
		session.setAttribute("catList",categoryDaoImpl.getCategoryList());
		return "userHomePage";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~UserAboutUsController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@RequestMapping("/userAboutUs")
	public String userAboutUsPage()
	{
		return "userAboutUs";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~AboutUsController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@RequestMapping("/about")
	public String aboutUsPage()
	{
		return "aboutUs";
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~UserContactUsController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@RequestMapping("/userContactUs")
	public String userContactUsPage()
	{
		return "userContactUs";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ContactUsController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@RequestMapping("/contact")
	public String contactUsPage()
	{
		return "contactUs";
	}

}
