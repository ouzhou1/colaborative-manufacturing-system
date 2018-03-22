package edu.tongji.CMS.Service.order;

import edu.tongji.CMS.dao.orders.OrdersDao;
import edu.tongji.CMS.domain.Users.Partner;
import edu.tongji.CMS.domain.order.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderManager {
    @Autowired
    private OrdersDao ordersDao;

    public List<Partner> getPartnerInOrder(Long orderId) {
        return null;
    }
}
