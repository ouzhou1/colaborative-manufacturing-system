package edu.tongji.CMS.dao.orders;

import edu.tongji.CMS.domain.order.SubOrders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SubOrdersDao extends CrudRepository<SubOrders, Long> {
    Iterable<SubOrders> findSubOrdersByParentOrderId(Long id);
}
