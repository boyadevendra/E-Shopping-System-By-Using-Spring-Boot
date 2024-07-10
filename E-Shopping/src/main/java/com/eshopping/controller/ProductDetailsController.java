package com.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshopping.DAO.CartDao;
import com.eshopping.DAO.ProductDetailsDao;
import com.eshopping.DTO.ProductDetailsDTO;
import com.eshopping.entity.CartDetails;
import com.eshopping.entity.ProductDetails;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductDetailsController
{
	@Autowired
	ProductDetailsDao productDetailsDao;
	
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/productRegistrationPage")
	public String saveProductDetailsPage(Model model)
	{
		model.addAttribute("productDetails", new ProductDetailsDTO());
		return"ProductsRegistration";
	}
	@RequestMapping("/productRegistration")
	public String productRegistration(ProductDetailsDTO productDetailsDTO,Model model)
	{
		ProductDetails saveDetails = productDetailsDao.saveProductDetails(productDetailsDTO);
		if(saveDetails!=null)
		{
			model.addAttribute("msg", "Registration Sucessfull");
			model.addAttribute("productDetails", new ProductDetailsDTO());
		    return"ProductsRegistration";
		}
		else
		{
			model.addAttribute("msg", "Registration Not  Sucessfull");
			model.addAttribute("productDetails", new ProductDetailsDTO());
		    return"ProductsRegistration";
		}
	}
	
	@RequestMapping("/FilterByPrice")
	public String filterByUsingGivenProducts(double minprice,double maxprice,Model model,HttpServletRequest request)
	{
		List<ProductDetails> productByPrice = productDetailsDao.getProductByPrice(minprice, maxprice);
		String firstname = (String) request.getSession().getAttribute("username");
		if(productByPrice.size()!=0)
		{
			model.addAttribute("msg",firstname);
//			model.addAttribute("prod","products are available");
			model.addAttribute("listofproduct", productByPrice);
			return"AllProductDetails";
		}
		else 
		{
			model.addAttribute("msg",firstname);
			model.addAttribute("prod","No products avaialable");
			model.addAttribute("listofproduct", productByPrice);
			return"AllProductDetails";
		}
	}
	@RequestMapping("/addToCart")
	//@ResponseBody
	public String addToCart(Integer id, HttpServletRequest request, Model model) 
	{
		ProductDetails productById = productDetailsDao.getProductById(id);
		Integer userid = (Integer) request.getSession().getAttribute("userid");

		String firstname = (String) request.getSession().getAttribute("username");

		List<ProductDetails> list = (List<ProductDetails>) request.getSession().getAttribute("allproducts");
		CartDetails idAndProductId = cartDao.findCartDetailsUserIdAndProductId(userid, productById.getProductid());
		if (idAndProductId != null)
		{
			model.addAttribute("prod", "Already   :" + productById.getProductname() + "is added in cart");
			model.addAttribute("msg", firstname);
			model.addAttribute("listofproduct", list);
			return "AllProductDetails";
		}

		else 
		{

			CartDetails cartDetails = new CartDetails();
			cartDetails.setProductid(productById.getProductid());
			cartDetails.setProductname(productById.getProductname());
			cartDetails.setPrice(productById.getPrice());
			cartDetails.setUserid(userid);
			CartDetails cart = cartDao.saveCartDetails(cartDetails);
			if (cart != null)
			{
				model.addAttribute("prod", productById.getProductname() +  "  :    is added in cart");
				model.addAttribute("msg", firstname);
				model.addAttribute("listofproduct", list);
				return "AllProductDetails";
			} 
			else 
			{
				return "Nooo Details found";
			}
		}
	}
}
