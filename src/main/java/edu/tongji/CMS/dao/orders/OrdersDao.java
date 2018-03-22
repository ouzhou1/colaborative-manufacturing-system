package edu.tongji.CMS.dao.orders;

import edu.tongji.CMS.domain.Users.Partner;
import edu.tongji.CMS.domain.order.SubOrders;
import edu.tongji.CMS.domain.vo.OrderStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.order.Orders;

import java.util.List;

public interface OrdersDao extends CrudRepository<Orders, Long> {
    @Query("select orders from Orders orders where orders.status = ?1 or orders.status = ?2")
    List<Orders> findActiveOrders(OrderStatus status1, OrderStatus status2);
}
