package edu.tongji.CMS.dao.orders;

import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.order.Orders;

public interface OrdersDao extends CrudRepository<Orders, Long> {

}
