package edu.tongji.CMS.dao.demands;

import edu.tongji.CMS.domain.demands.Demands;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemandsDao extends CrudRepository<Demands, Long> {

    List<Demands> findByStatus(String status);

    long countByStatus(String status);
}