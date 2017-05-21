package edu.tongji.CMS.dao.orders;

import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Orders;

public interface OrdersDao extends CrudRepository<Orders, Long>{

}
