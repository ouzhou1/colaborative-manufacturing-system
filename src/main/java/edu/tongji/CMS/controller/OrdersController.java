package edu.tongji.CMS.controller;

import edu.tongji.CMS.dao.orders.OrdersDao;
import edu.tongji.CMS.dao.orders.SubOrdersDao;
import edu.tongji.CMS.dao.partners.CandidatesDao;
import edu.tongji.CMS.dao.partners.UserOrderBindingDao;
import edu.tongji.CMS.dao.partners.PartnersDao;
import edu.tongji.CMS.dao.services.ServiceOrderBindingDao;
import edu.tongji.CMS.dao.services.ServicesDao;
import edu.tongji.CMS.domain.Services.ServiceOrderBinding;
import edu.tongji.CMS.domain.Services.Services;
import edu.tongji.CMS.domain.Users.Candidates;
import edu.tongji.CMS.domain.Users.Partner;
import edu.tongji.CMS.domain.Users.UserOrderBinding;
import edu.tongji.CMS.domain.order.Orders;
import edu.tongji.CMS.domain.order.SubOrders;
import edu.tongji.CMS.domain.vo.OrderStatus;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private ServicesDao servicesDao;

    @Autowired
    private PartnersDao partnersDao;

    @Autowired
    private ServiceOrderBindingDao serviceOrderBindingDao;

    @Autowired
    private UserOrderBindingDao userOrderBindingDao;

    @Autowired
    private SubOrdersDao subOrdersDao;

    @Autowired
    private CandidatesDao candidatesDao;

    @Autowired
    private ServicesController servicesController;

    @Autowired
    private UsersController usersController;

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
        // Order details
        Orders order = ordersDao.findOne(id);
        // To specific page by order status
        OrderStatus orderStatus = order.getStatus();
        ModelAndView modelAndView = null;
        if (orderStatus.toString().equalsIgnoreCase("waiting")) {
            modelAndView = new ModelAndView("orders/order_waiting");
            modelAndView.addObject("orderId", order.getOrder_id());
        } else if (orderStatus.toString().equalsIgnoreCase("cancelled")) {
            modelAndView = new ModelAndView("redirect:/orders");
        } else {
            modelAndView = new ModelAndView("orders/order_details");
            // Sub Orders
            Iterable<SubOrders> suborders = subOrdersDao.findAll();
            modelAndView.addObject("order", order);
            modelAndView.addObject("suborders", suborders);
            // Partners in order
            Iterable<UserOrderBinding> partnerOrderBindings = userOrderBindingDao.findByOrderId(id);
            List<Partner> partners = new ArrayList<>();
            for (UserOrderBinding userOrderBinding : partnerOrderBindings) {
                List<Partner> partnerList = partnersDao.findByUserId(userOrderBinding.getUserId());
                partners.add(partnerList.get(0));
            }
            modelAndView.addObject("partners", partners);
            // Services in order
            Iterable<ServiceOrderBinding> serviceOrderBindings = serviceOrderBindingDao.findByOrderId(id);
            List<Services> currentServices = new ArrayList<>();
            for (ServiceOrderBinding serviceOrderBinding: serviceOrderBindings) {
                Services currentService = servicesDao.findOne(serviceOrderBinding.getServiceId());
                currentServices.add(currentService);
            }
            modelAndView.addObject("currentservices", currentServices);
        }
        return modelAndView;
    }

    @GetMapping("/details/{id}/suborders/{subid}")
    public ModelAndView subOrderDetails(@PathVariable("id") long id, @PathVariable("subid") long subid, @ModelAttribute SubOrders subOrders) {
        return new ModelAndView("orders/suborder_details");
    }

    @GetMapping("/candidates/{orderId}")
    public ModelAndView candidatesResult(@PathVariable Long orderId) {
        List<Candidates> candidates = candidatesDao.findAll();
        ModelAndView modelAndView = new ModelAndView("orders/candidatesresult");
        modelAndView.addObject("candidates", candidates);
        modelAndView.addObject("orderId", orderId);
        return new ModelAndView("orders/candidatesresult", "candidates", candidates);
    }

    @RequestMapping(value = "binding/{orderId}/{serviceId}/{userId}", method = RequestMethod.POST)
    public ModelAndView bindingCandidateResult(@PathVariable("orderId") Long orderId,
                                               @PathVariable("serviceId") Long serviceId,
                                               @PathVariable("userId") Long userId) {
        servicesController.serviceOrderBinding(serviceId, orderId);
        usersController.userOrderBinding(userId, orderId);
        Orders orders = ordersDao.findOne(orderId);
        orders.setStatus(OrderStatus.PROCESSING);
        ordersDao.save(orders);
        return new ModelAndView("redirect:/orders");
    }
}