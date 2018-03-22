package edu.tongji.CMS.dao.services;

import edu.tongji.CMS.domain.Services.ServiceOrderBinding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderBindingDao extends JpaRepository<ServiceOrderBinding, Long> {
    Iterable<ServiceOrderBinding> findByOrderId(long id);
}
