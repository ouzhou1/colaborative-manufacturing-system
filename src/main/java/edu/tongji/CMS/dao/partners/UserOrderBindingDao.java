package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.UserOrderBinding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderBindingDao extends JpaRepository<UserOrderBinding, Long> {
    Iterable<UserOrderBinding> findByOrderId(Long id);
}
