package edu.tongji.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.OrdersDao;
import edu.tongji.CMS.domain.Orders;
import edu.tongji.CMS.domain.Services;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersDao ordersDao;

	@GetMapping(value = "")
	public ModelAndView servicesAllList() {
		Iterable<Orders> orders = ordersDao.findAll();
		return new ModelAndView("orders/dashboard", "orders", orders);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Orders viewOrder(@PathVariable("id") long id) {
		Orders orders = ordersDao.findOne(id);
		return orders;
	}
	
	@GetMapping("/publish")
	public ModelAndView serviceCreateForm(@ModelAttribute Services services) {
		return new ModelAndView("orders/publish");
	}
}