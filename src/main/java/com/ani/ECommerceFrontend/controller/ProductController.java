package com.ani.ECommerceFrontend.controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ani.ECommerceBackend.daoImpl.CategoryDaoImpl;
import com.ani.ECommerceBackend.daoImpl.ProductDaoImpl;
import com.ani.ECommerceBackend.daoImpl.SupplierDaoImpl;
import com.ani.ECommerceBackend.model.Category;
import com.ani.ECommerceBackend.model.Product;
import com.ani.ECommerceBackend.model.Supplier;
import com.ani.ECommerceBackend.utility.ProductUtility;

@Controller
public class ProductController {
	
	@Autowired
	ProductDaoImpl productDaoImpl;

	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	
public ProductController() {
System.out.println("productController is loading");	// 
}
	@RequestMapping("/ebc")
	public ModelAndView AddProductData()
	{
		ModelAndView modelAndView=new ModelAndView("addProduct");
		List<Category> list=null;
		list=categoryDaoImpl.getCategoryList();
		modelAndView.addObject("catList",list);
		List<Supplier> suplist=null;
		suplist=supplierDaoImpl.getSupplierList();
		modelAndView.addObject("supList",suplist);
		
		Product product=new Product();
				
		modelAndView.addObject("addPro",product);
		modelAndView.addObject("button","Add Product");
        //modelAndView.addObject("form","Add Product");
		return modelAndView;
	}
	/*@RequestMapping(value="/addProduct",method=RequestMethod.POST)
public String recieveProductFormData(@ModelAttribute("addPro") Product product)
{
		MultipartFile imageFile=product.getProductImage();
		System.out.println("~~~~~~~~~~~~~~~~~imagefile"+imageFile);
		BufferedOutputStream bos=null;
		try {
			
			
				byte byteArray[];
				byteArray = imageFile.getBytes();
				FileOutputStream fos=new FileOutputStream("D:\\ECommerce-workspace\\ECommerceFrontend\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg");
				bos=new BufferedOutputStream(fos);
				bos.write(byteArray);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
		 catch (IOException e) {
			e.printStackTrace();
		}
	finally
	{
		
		try {
			bos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
		productDaoImpl.saveProduct(product);
	return "homePage";
}*/

	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String recieveProductFormData(@ModelAttribute("addPro") Product product)

{
		ProductUtility productUtility=new ProductUtility();
		
		if(product.getProductId()==0)
		{
			int id=(int)(Math.random()*10000);
			product.setProductId(id);

		productDaoImpl.saveProduct(product);
		}
		else
		{
			productDaoImpl.editProduct(product);
		}
		productUtility.fileUpload(product);
		return "homePage";
		
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ShowProductsController~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
	@RequestMapping("/fbc")
	public ModelAndView recieveProductsData()
	{
			List<Product> list=productDaoImpl.getProductList();
			ModelAndView modelAndView=new ModelAndView("showProduct");
			modelAndView.addObject("proList",list);
		return modelAndView;
	}
		@RequestMapping("/delPro")
		public ModelAndView deleteProductData(@RequestParam("proId") int productId)
		{
			Product product= productDaoImpl.getProduct(productId);
			productDaoImpl.deleteProduct(product);
			/*try {
				FileInputStream fis=new FileInputStream("D:\\ECommerce-workspace\\ECommerceFrontend\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg");
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			ModelAndView modelAndView=new ModelAndView("showProduct");
			List<Product> list=productDaoImpl.getProductList();
			modelAndView.addObject("proList",list);
			return modelAndView ;
			
		}
		
		
		@RequestMapping("/editPro")
		public ModelAndView editProductsData(@RequestParam("proId") int productId)
		{
			Product product= productDaoImpl.getProduct(productId);
			ModelAndView modelAndView=new ModelAndView("addProduct");
			List<Category> list=null;
			list=categoryDaoImpl.getCategoryList();
			modelAndView.addObject("catList",list);
			List<Supplier> suplist=null;
			suplist=supplierDaoImpl.getSupplierList();
			modelAndView.addObject("supList",suplist);
		
			modelAndView.addObject("button","Update Product");
			modelAndView.addObject("addPro",product);
			modelAndView.addObject("form","Update Product");
			return modelAndView;
			
		}
	
}
