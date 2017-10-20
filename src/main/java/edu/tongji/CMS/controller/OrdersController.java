package edu.tongji.CMS.controller;

import edu.tongji.CMS.dao.orders.OrdersDao;
import edu.tongji.CMS.dao.orders.SubOrdersDao;
import edu.tongji.CMS.domain.order.Orders;
import edu.tongji.CMS.domain.order.SubOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private SubOrdersDao subOrdersDao;

    @GetMapping(value = "")
    public ModelAndView servicesAllList(Model model) {
        ModelAndView modelAndView = new ModelAndView("orders/dashboard");
        Iterable<Orders> orders = ordersDao.findAll();
        modelAndView.addObject("orders", orders);
        modelAndView.addObject("orders_count", ordersDao.count());
        return modelAndView;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Orders viewOrder(@PathVariable("id") long id) {
        Orders orders = ordersDao.findOne(id);
        return orders;
    }

    @GetMapping("/create")
    public ModelAndView orderCreateForm(@ModelAttribute Orders orders, Model model) {
        model.addAttribute("orders", orders);
        return new ModelAndView("orders/order_create");
    }

    @GetMapping("/details/{id}")
    public ModelAndView orderDetails(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("orders/order_details");
        Orders order = ordersDao.findOne(id);
        Iterable<SubOrders> suborders = subOrdersDao.findSubOrdersByParentOrderId(id);
        modelAndView.addObject("order", order);
        modelAndView.addObject("suborders", suborders);
        return modelAndView;
    }

    @GetMapping("/details/{id}/suborders/{subid}")
    public ModelAndView subOrderDetails(@PathVariable("id") long id, @PathVariable("subid") long subid, @ModelAttribute SubOrders subOrders) {
        return new ModelAndView("orders/suborder_details");
    }
}