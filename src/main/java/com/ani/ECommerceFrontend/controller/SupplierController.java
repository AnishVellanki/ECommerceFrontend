package com.ani.ECommerceFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.SupplierDaoImpl;
import com.ani.ECommerceBackend.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;

public SupplierController() {
System.out.println("SupplierController is loading");
}	
	@RequestMapping("/cbc")
	public ModelAndView goToSupplierForm()
    {
        ModelAndView  mv=new ModelAndView("addSupplier");
        
        mv.addObject("addSup",new Supplier());
        mv.addObject("button","Add Supplier");
        mv.addObject("form","Add Supplier");
        return  mv;
    }
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
    public String recieveSupplierFormData(@ModelAttribute ("addSup") Supplier sp)
    {
//TestSessionFactory testSF=new TestSessionFactory();
		//ts.TestingSessionFactory();
		System.out.println(sp.getSupplierName());
        System.out.println(sp.getSupplierDescription());
        if(sp.getSupplierId()==0)
        {
        supplierDaoImpl.saveSupplier(sp);
        }
        else
        {
        	supplierDaoImpl.editSupplier(sp);
            	
        }
        return "homePage";
    }
 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ShowSupplierController~~~~~~~~~~~~~~~~~~~~~~~	

	@RequestMapping("/dbc")
	public 	ModelAndView m1()
		{
			System.out.println("--------------------test0");
			
			List<Supplier> list=null;
			list=supplierDaoImpl.getSupplierList();
			System.out.println("--------------------test1");
			/*for(Category c:list)
			{
				System.out.println("---"+c.getCategoryId());
				System.out.println(c.getCategoryName());
				System.out.println(c.getCategoryDescription());
			}*/
			
			System.out.println("--------------------test2");
			ModelAndView modelAndView=new ModelAndView("showSupplier");
			modelAndView.addObject("supList",list);
			
			return modelAndView;
		}
		@RequestMapping("/delSup")
		public ModelAndView deleteCategoryData(@RequestParam("supId") int supplierId)
		{
			System.out.println(supplierId);
			Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
			supplierDaoImpl.deleteSupplier(supplier);
			ModelAndView modelAndView=new ModelAndView("showSupplier");
			List<Supplier> list=supplierDaoImpl.getSupplierList();
			modelAndView.addObject("supList",list);
			return modelAndView ;
		}
@RequestMapping("/editSup")
public ModelAndView editCategoryData(@RequestParam("supId") int supplierId)
{
Supplier supplier=supplierDaoImpl.getSupplier(supplierId);
ModelAndView modelAndView=new ModelAndView("addSupplier");
modelAndView.addObject("button","Update Supplier");
modelAndView.addObject("addSup",supplier);
modelAndView.addObject("form","Update Supplier");
return modelAndView;
}



}
