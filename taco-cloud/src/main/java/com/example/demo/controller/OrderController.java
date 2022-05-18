package com.example.demo.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Order;
import com.example.demo.model.Taco;

@Controller
@RequestMapping("/orders")
public class OrderController {
	private RestTemplate rest= new RestTemplate();
	@GetMapping("/current") 
	public String orderForm(Model model) { 
	model.addAttribute("order", new Order()); 
	return "orderForm"; 
	} 
	
	@PostMapping
	public String processOrder(Order order, HttpServletRequest request) {
	Taco taco = (Taco) request.getSession().getAttribute("taco");
	System.out.println(taco.getName());
	order.setTacos(Arrays.asList(taco));
	rest.postForObject("http://localhost:8080/orders", order, Order.class);
	//log.info("Order submitted: " + order); 
	return "redirect:/"; 
	}


}
