package com.ani.ECommerceFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;
import com.ani.ECommerceBackend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	public CategoryController() {
	System.out.println("CategoryController is loading");	// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/addCategory", method = RequestMethod.GET)
	public ModelAndView goToCategoryForm()
	{
		Category category=new Category();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("cat",category);
		modelAndView.addObject("button","Add Category");
		return modelAndView;
		
	}
@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String receiveCategoryForm(@ModelAttribute("cat") Category ca)
	{
	if(ca.getCategoryId()==0)
	{
	categoryDaoImpl.saveCategory(ca);
			}
	else
	{
		categoryDaoImpl.editCategory(ca);
			
	}
	return "homePage";

	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ShowCategoryController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

@RequestMapping("/bbc")
public 	ModelAndView m1()
	{
		System.out.println("--------------------test0");
		
		List<Category> list=null;
		list=categoryDaoImpl.getCategoryList();
		System.out.println("--------------------test1");
		/*for(Category c:list)
		{
			System.out.println("---"+c.getCategoryId());
			System.out.println(c.getCategoryName());
			System.out.println(c.getCategoryDescription());
		}*/
		
		System.out.println("--------------------test2");
		ModelAndView modelAndView=new ModelAndView("showCategory");
		modelAndView.addObject("catList",list);
		
		return modelAndView;
	}
	@RequestMapping("/del")
	public ModelAndView deleteCategoryData(@RequestParam("catId") int categoryId)
	{
		System.out.println(categoryId);
		Category category=categoryDaoImpl.getCategory(categoryId);
		categoryDaoImpl.deleteCategory(category);
		ModelAndView modelAndView=new ModelAndView("showCategory");
		List<Category> list=categoryDaoImpl.getCategoryList();
		modelAndView.addObject("catList",list);
		return modelAndView ;
	}
@RequestMapping("/edit")
public ModelAndView editCategoryData(@RequestParam("catId") int categoryId)
{
Category category=categoryDaoImpl.getCategory(categoryId);
ModelAndView modelAndView=new ModelAndView("addCategory");
modelAndView.addObject("button","Update Category");
modelAndView.addObject("cat",category);
modelAndView.addObject("form","Update Category");
return modelAndView;
}

}
