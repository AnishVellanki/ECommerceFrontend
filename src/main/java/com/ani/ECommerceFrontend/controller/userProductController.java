package com.ani.ECommerceFrontend.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.CartDaoImpl;
import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;
import com.ani.ECommerceBackend.daoImpl.ProductDaoImpl;
import com.ani.ECommerceBackend.daoImpl.SupplierDaoImpl;
import com.ani.ECommerceBackend.model.Product;



@Controller
public class userProductController {

    @Autowired
    SupplierDaoImpl supplierDaoImpl;
    
    @Autowired
    CategoryDaoImpl categoryDaoImpl;
    
    @Autowired
    CartDaoImpl cartDaoImpl;
    
    @Autowired
    ProductDaoImpl productDaoImpl;
    public userProductController() {
    System.out.println("userProductController is loading");    
    }
    @RequestMapping("/showproducts")
    public ModelAndView goToShowProduct()
    {
        ModelAndView modelandview=new ModelAndView("userGrid");
           List<Product> listProduct = productDaoImpl.getProductList();
          
           //List<Supplier> listSupplier = supplierDaoImpl.retrieveSupplierData();
               
              
               //modelandview.addObject("supList", listSupplier);
              
        
          modelandview.addObject("proList", listProduct);
        return modelandview;
    }
    @RequestMapping("/viewDetails")
    public ModelAndView ViewProduct(@RequestParam("proId") int productId)
       {
           System.out.println("from product controller Product Id="+productId);
          
           Product product=productDaoImpl.getProduct(productId);
    
    System.out.println("~~~~~~~~~~~"+product);
           ModelAndView modelandview=new ModelAndView("userViewSinglePro");
          
          modelandview.addObject("pr",product);
        
        
           return modelandview;
       }
	
	
}
