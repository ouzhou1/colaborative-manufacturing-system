package edu.tongji.CMS.controller;

import edu.tongji.CMS.dao.orders.OrdersDao;
import edu.tongji.CMS.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/form/create")
	public ModelAndView orderCreateForm(@ModelAttribute Orders orders) {
		return new ModelAndView("orders/order_create");
	}

	@PostMapping("/create")
	public ModelAndView orderCreateAction(@ModelAttribute Orders orders) {
		return new ModelAndView("orders/publish");
	}

	@GetMapping("/status")
	public ModelAndView orderStatus(@ModelAttribute Orders orders) {
		return new ModelAndView("orders/status");
	}
}